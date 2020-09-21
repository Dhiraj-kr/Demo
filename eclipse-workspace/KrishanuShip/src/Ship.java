public class Ship {

	private char type;
	private int width;
	private int height;
	private String coordinate;

	public Ship(char type, int width, int height, String coordinate) {
		this.type = type;
		this.width = width;
		this.height = height;
		this.coordinate = coordinate;
	}

	public char getType() {
		return type;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getCoordinate() {
		return coordinate;
	}

	@Override
	public String toString() {
		return String.format("Ship [type=%s, width=%s, height=%s, coordinate=%s]", type, width, height, coordinate);
	}

}