package com.battleship;

import java.util.ArrayList;
import java.util.List;

import com.battleship.constant.ShipType;

public class Ship {

	private int width;
	private int height;
	
	private ShipType type;
	
	private int startingCellRow;
	private int startingCellCol;
	
	private List<Cell> lstCells=new ArrayList<>();
	
	public Ship(ShipType type, int width, int height, int startingCellRow, int startingCellCol) {
		this.type=type;
		this.width=width;
		this.height=height;
		
		this.startingCellRow=startingCellRow;
		this.startingCellCol=startingCellCol;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ShipType getType() {
		return type;
	}

	public List<Cell> getLstCells() {
		return lstCells;
	}

	public void setLstCells(List<Cell> lstCells) {
		this.lstCells = lstCells;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public int getStartingCellRow() {
		return startingCellRow;
	}

	public void setStartingCellRow(int startingCellRow) {
		this.startingCellRow = startingCellRow;
	}

	public int getStartingCellCol() {
		return startingCellCol;
	}

	public void setStartingCellCol(int startingCellCol) {
		this.startingCellCol = startingCellCol;
	}

	public boolean isDestroyed() {
		boolean flag=true;
		for(Cell c:lstCells) {
			if(c.getHitsRemaining()>0) {
				flag=false;
				break;
			}
		}
		return flag;
	}
}
