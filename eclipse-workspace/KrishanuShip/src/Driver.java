import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

	private static List<String> lines;
	
	/*
	 * 
	 * 
	 * 
	 * 
The first line of the input contains the width and height of the battle area respectively.
The second line of the input contains the number of battleships that each player gets.
The third and 4th line of the input contains the type of the battleship, its dimensions (width and height) and coordinates for
Player-1 and Player-2.
The fifth line contains the sequence of the target locations of missiles fired by Player-1.
The sixth line contains the sequence of the target locations of missiles fired by Player-2.
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 B3
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
	 */

	public static void main(String[] args) {
		readDataFromFile();
		//BattleField battleField = inputBattleField();
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		inputShip(lines.get(2), player1, player2);
		inputShip(lines.get(3), player1, player2);
		Map<String, Integer> firstPlayerCells = calculateCells(player1);
		Map<String, Integer> secondPlayerCells = calculateCells(player2);
		playGame(0, player1, firstPlayerCells, lines.get(4).split(" "), 0, player2, secondPlayerCells,
				lines.get(5).split(" "), true);
	}

	private static void playGame(int attackIndexPlayer1, Player player1, Map<String, Integer> firstPlayerCells,
			String[] attackSequencePlayer1, int attackIndexPlayer2, Player player2,
			Map<String, Integer> secondPlayerCells, String[] attackSequencePlayer2, boolean flag) {

		if (player1.getCellsToDestroy() == 0) {
			System.out.println("Player-2 won the battle");
			return;
		}
		if (player2.getCellsToDestroy() == 0) {
			System.out.println("Player-1 won the battle");
			return;
		}
		if ((attackIndexPlayer1 == attackSequencePlayer1.length)
				&& (attackIndexPlayer2 == attackSequencePlayer2.length)) {
			System.out.println("Draw"); // Draw
			return;
		}
		// ----------------------------------------------------------------------------------------
		if (flag) {
			// For player1
			if (attackIndexPlayer1 == attackSequencePlayer1.length) {
				System.out.println("Player-1 has no more missiles left to launch");
				flag = !flag;
			} else if (check(attackIndexPlayer1, attackSequencePlayer1, secondPlayerCells)) {
				System.out.println("Player-1 fires a missile with target " + attackSequencePlayer1[attackIndexPlayer1]
						+ " which got hit"); // Player1 hits
				player2.setCellsToDestroy(player2.getCellsToDestroy() - 1);
				secondPlayerCells.put(attackSequencePlayer1[attackIndexPlayer1],
						secondPlayerCells.get(attackSequencePlayer1[attackIndexPlayer1++]) - 1);
			} else {
				System.out.println("Player-1 fires a missile with target " + attackSequencePlayer1[attackIndexPlayer1++]
						+ " which got miss"); // Player1 misses
				flag = !flag;
			}
		} else {
			// For player2
			if (attackIndexPlayer2 == attackSequencePlayer2.length) {
				System.out.println("Player-1 has no more missiles left to launch");
				flag = !flag;
			} else if (check(attackIndexPlayer2, attackSequencePlayer2, firstPlayerCells)) {
				System.out.println("Player-2 fires a missile with target " + attackSequencePlayer2[attackIndexPlayer2]
						+ " which got hit"); // Player2 hits
				player1.setCellsToDestroy(player1.getCellsToDestroy() - 1);
				firstPlayerCells.put(attackSequencePlayer2[attackIndexPlayer2],
						firstPlayerCells.get(attackSequencePlayer2[attackIndexPlayer2++]) - 1);
			} else {
				System.out.println("Player-2 fires a missile with target " + attackSequencePlayer2[attackIndexPlayer2++]
						+ " which got miss"); // Player2 misses
				flag = !flag;
			}
		}
		playGame(attackIndexPlayer1, player1, firstPlayerCells, attackSequencePlayer1, attackIndexPlayer2, player2,
				secondPlayerCells, attackSequencePlayer2, flag);
	}

	private static boolean check(int attackIndex, String[] attackSequence, Map<String, Integer> playerCells) {
		return (playerCells.get(attackSequence[attackIndex]) != null)
				&& (playerCells.get(attackSequence[attackIndex]) != 0);
	}

	private static Map<String, Integer> calculateCells(Player player) {
		Map<String, Integer> map = new HashMap<>();
		for (Ship ship : player.getShips()) {
			char startHeight = ship.getCoordinate().charAt(0),
					endHeight = (char) (ship.getCoordinate().charAt(0) + ship.getHeight());
			while (startHeight < endHeight) {
				int startWidth = ship.getCoordinate().charAt(1) - '0',
						endWidth = ship.getCoordinate().charAt(1) - '0' + ship.getWidth();
				while (startWidth < endWidth) {
					if (ship.getType() == 'Q') {
						map.put(new StringBuffer().append(startHeight).append(startWidth).toString(), 2);
						player.setCellsToDestroy(player.getCellsToDestroy() + 2);
					} else {
						map.put(new StringBuffer().append(startHeight).append(startWidth).toString(), 1);
						player.setCellsToDestroy(player.getCellsToDestroy() + 1);
					}
					startWidth++;
				}
				startHeight++;
			}
		}
		return map;
	}

	/*
	 * private static BattleField inputBattleField() { String widthAndHeight =
	 * lines.get(0); int noOfShip = Integer.parseInt(lines.get(1)); return new
	 * BattleField(widthAndHeight.charAt(0) - '0',
	 * widthAndHeight.charAt(widthAndHeight.length() - 1), noOfShip); }
	 */

	//P 2 1 D4 C3
	private static void inputShip(String line, Player player1, Player player2) {
		String[] shipInput = line.split(" ");
		int partitionIndex = (shipInput.length - 3) / 2 + 3;
		for (int i = 3; i < partitionIndex; ++i) {
			player1.addShip(new Ship(shipInput[0].charAt(0), shipInput[1].charAt(0) - '0', shipInput[2].charAt(0) - '0',
					shipInput[i]));
		}
		for (int i = partitionIndex; i < shipInput.length; ++i) {
			player2.addShip(new Ship(shipInput[0].charAt(0), shipInput[1].charAt(0) - '0', shipInput[2].charAt(0) - '0',
					shipInput[i]));
		}
	}

	private static void readDataFromFile() {
		String source = "C:\\Users\\dheeraj.kumar\\Desktop\\input.txt";
		try {
			lines = Files.readAllLines(Paths.get(source), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}