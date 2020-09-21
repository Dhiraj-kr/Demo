package com.battleship;

import java.util.List;

public class Player {

	BattleGrid grid;
	private List<Missile> missiles;
	private int currentMissileToFire=1;
	String name;
	
	public Player(BattleGrid grid,String name) {
		this.grid=grid;
		this.name=name;
	}
	
	public int hitMissile(Player oppPlayer) {
		if(missiles.size() >= currentMissileToFire) {
			Missile m=missiles.get(currentMissileToFire-1);
			currentMissileToFire++;
			return oppPlayer.grid.fire(this.name,m.getTargetRow(),m.getTargetCol());
		}
		else {
			System.out.println(this.name+" has no more missiles left to launch");
			return -1;
		}
		
	}

	public String getName() {
		return name;
	}

	public int getCurrentMissileToFire() {
		return currentMissileToFire;
	}

	public void setCurrentMissileToFire(int currentMissileToFire) {
		this.currentMissileToFire = currentMissileToFire;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

	public void setMissiles(List<Missile> missiles) {
		this.missiles = missiles;
	}
	
	public boolean hasLost() {
		List<Ship> lstShip=this.grid.getLstShip();
		for(Ship s:lstShip) {
			if(!s.isDestroyed()) {
				return false;
			}
		}
		return true;
	}
}
