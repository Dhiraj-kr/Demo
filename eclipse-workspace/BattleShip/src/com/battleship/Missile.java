package com.battleship;

public class Missile {

	private int targetRow;
	private int targetCol;
	
	public int getTargetRow() {
		return targetRow;
	}

	public void setTargetRow(int targetRow) {
		this.targetRow = targetRow;
	}

	public int getTargetCol() {
		return targetCol;
	}

	public void setTargetCol(int targetCol) {
		this.targetCol = targetCol;
	}

	Missile(int targetRow, int targetCol){
		this.targetRow=targetRow;
		this.targetCol=targetCol;
	}
}
