package com.battleship;

public class Cell {

	private int row;
	private int col;
	boolean hasShip=false;
	int hitsRemaining=1;
	
	public int getHitsRemaining() {
		return hitsRemaining;
	}

	public void setHitsRemaining(int hitsRemaining) {
		this.hitsRemaining = hitsRemaining;
	}

	public Cell(int row, int col) {
		this.row=row;
		this.col=col;
	}
	
	public boolean isHasShip() {
		return hasShip;
	}

	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}
	
}
