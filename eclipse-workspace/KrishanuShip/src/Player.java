import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private int cellsToDestroy;
	private List<Ship> ships;

	public Player(int id) {
		this.id = id;
		ships = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public int getCellsToDestroy() {
		return cellsToDestroy;
	}

	public void setCellsToDestroy(int cellsToDestroy) {
		this.cellsToDestroy = cellsToDestroy;
	}

	/**
	 * Convinence method
	 */
	public void addShip(Ship ship) {
		ships.add(ship);
	}

	@Override
	public String toString() {
		return String.format("Player [id=%s, destroyedCells=%s, ships=%s]", id, cellsToDestroy, ships);
	}

}