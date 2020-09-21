package com.battleship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.battleship.constant.ShipType;
import com.battleship.util.CellUtil;
import com.battleship.util.CharacterUtil;

public class BattleShip {
	
	static Player p1;
	static Player p2;
	
	final static String SPACE=" ";

	public static void main(String[] args) {
		
		setUp();
		
		int p1FireResult=-1;
		int p2FireResult=-1;
		
		boolean p1Chance=true;
		boolean p2Chance=true;
		
		while(true) {
			
			if(p1Chance) {
				if(p1.hasLost()) {
					System.out.println(p2.getName()+" won the battle");
					break;
				}
				else {
					p1FireResult=p1.hitMissile(p2);
					if(p1FireResult==1) {
						p1Chance=true;
						p2Chance=false;
					}
					else {
						p2Chance=true;
						p1Chance=false;
					}
				}
			}
			if(p2Chance) {
				
				if(p2.hasLost()) {
					System.out.println(p1.getName()+" won the battle");
					break;
				}
				else {
					p2FireResult=p2.hitMissile(p1);
					if(p2FireResult==1) {
						p2Chance=true;
						p1Chance=false;
					}
					else {
						p1Chance=true;
						p2Chance=false;
					}
				}
			}
				
			
		   if(p2FireResult == -1 && p2FireResult == -1) { 
			  break; 
		   }
			 
		}
		System.out.println("Game End");
		
	}

	private static void setUp() {
		try(BufferedReader br=new BufferedReader(new FileReader(new File(ClassLoader.getSystemResource("Input.txt").getFile())))) {
			String line=br.readLine();
			String[] lineArr=line.split(SPACE);
			int heightOfGrid=CharacterUtil.convertToInt(lineArr[1].charAt(0));
			
			BattleGrid p1Grid=new BattleGrid(Integer.parseInt(lineArr[0]),heightOfGrid);
			p1=new Player(p1Grid,"Player-1");
			
			BattleGrid p2Grid=new BattleGrid(Integer.parseInt(lineArr[0]),heightOfGrid);
			p2=new Player(p2Grid,"Player-2");
			
			//read line 2
			line=br.readLine();
			lineArr=line.split(SPACE);
			int numOfShips=Integer.parseInt(lineArr[0]);
			
			//Validation
			
			//based on value at line number 2 in input file, there would be number of lines having ships information
			//If value at line number 2 is 3 then there would be 3 lines having ships information and line 6 and 7 would have missile info of player 1 and player 2
			
			for(int i=0;i<numOfShips;i++) {
				line=br.readLine();		//read number of lines based on numOfShips(defined at line number 2)
				lineArr=line.split(SPACE);
				
				p1.grid.addShip(new Ship(ShipType.getShipType(lineArr[0]),Integer.parseInt(lineArr[1]),Integer.parseInt(lineArr[2]),CellUtil.getRowPos(lineArr[3])-1,CellUtil.getColPos(lineArr[3])-1));
				
				p2.grid.addShip(new Ship(ShipType.getShipType(lineArr[0]),Integer.parseInt(lineArr[1]),Integer.parseInt(lineArr[2]),CellUtil.getRowPos(lineArr[4])-1,CellUtil.getColPos(lineArr[4])-1));
			}
			
			//read line for player 1 
			List<Missile> lstMissiles=new ArrayList<>();
			line=br.readLine();
			lineArr=line.split(SPACE);
			for(int i=0;i<lineArr.length;i++) {
				lstMissiles.add(new Missile(CellUtil.getRowPos(lineArr[i])-1,CellUtil.getColPos(lineArr[i])-1));
			}
			p1.setMissiles(lstMissiles);
			
			lstMissiles=new ArrayList<>();
			//read line for player 2
			line=br.readLine();
			lineArr=line.split(SPACE);
			for(int i=0;i<lineArr.length;i++) {
				lstMissiles.add(new Missile(CellUtil.getRowPos(lineArr[i])-1,CellUtil.getColPos(lineArr[i])-1));
			}
			p2.setMissiles(lstMissiles);
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
