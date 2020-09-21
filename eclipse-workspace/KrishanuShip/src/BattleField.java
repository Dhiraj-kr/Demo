
public class BattleField {

	private int width;
	private char height;
	private int noOfShips;

	public BattleField(int width, char height, int noOfShips) {
		this.width = width;
		this.height = height;
		this.noOfShips = noOfShips;
	}

	public int getWidth() {
		return width;
	}

	public char getHeight() {
		return height;
	}

	public int getNoOfShips() {
		return noOfShips;
	}

	@Override
	public String toString() {
		return String.format("BattleField [width=%s, height=%s, noOfShips=%s]", width, height, noOfShips);
	}

}