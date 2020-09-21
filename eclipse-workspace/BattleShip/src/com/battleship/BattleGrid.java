package com.battleship;

import java.util.ArrayList;
import java.util.List;

import com.battleship.constant.ShipType;
import com.battleship.util.CharacterUtil;

public class BattleGrid {

	private int width;
	private int height;
	private Cell[][] cells;
	private List<Ship> lstShip=new ArrayList<>();
	
	public BattleGrid(int width, int height) {
		
		this.width=width;
		this.height=height;
		
		cells=new Cell[width][height];
		for(int i=0;i < cells.length;i++) {
			
			for(int j=0;j < cells[i].length;j++) {
				cells[i][j]=new Cell(i,j);
			}
		}
	}
	
	public Cell getCell(int row, int col) {
		return cells[row][col];
	}
	
	public void addShip(Ship s) {
		lstShip.add(s);
		int row=s.getStartingCellRow();
		int col=s.getStartingCellCol();
		
		boolean setTwoHitsRequired=false;
		if(s.getType().equals(ShipType.Q)) {
			setTwoHitsRequired=true;
		}
		
		for(int i=0;i < s.getWidth();i++) {
			Cell c=cells[row][col+i];
			c.setHasShip(true);
			s.getLstCells().add(c);
			if(setTwoHitsRequired) {
				c.setHitsRemaining(2);
			}
			
			for(int j=0;j < s.getHeight();j++) {
				c=cells[row+j][col];
				s.getLstCells().add(c);
				c.setHasShip(true);
				if(setTwoHitsRequired) {
					c.setHitsRemaining(2);
				}
			}
		}
		
	}
	
	public List<Ship> getLstShip() {
		return lstShip;
	}

	public void setLstShip(List<Ship> lstShip) {
		this.lstShip = lstShip;
	}

	public int fire(String nameOfPlayerWhoHit,int row, int col) {
		if(cells[row][col].isHasShip()) {
			int hitsRemaining=-1;
			if((hitsRemaining=cells[row][col].hitsRemaining) > 0) {
				cells[row][col].setHitsRemaining(hitsRemaining-1);
				System.out.println(nameOfPlayerWhoHit+" fires a missile with target "+CharacterUtil.convertToChar(row)+(col+1)+" which got hit");
				return 1;
			}
			else {
				System.out.println("This cell is already destroyed");
				return 0;
			}
		}
		else {
			System.out.println(nameOfPlayerWhoHit+" fires a missile with target "+CharacterUtil.convertToChar(row)+(col+1)+" which got miss");
			return 0;
		}
	}
	
}
