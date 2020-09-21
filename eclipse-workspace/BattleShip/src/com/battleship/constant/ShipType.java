package com.battleship.constant;

public enum ShipType {

	P(1),Q(2);
	
	private int hitRequired;
	
	ShipType(int hitRequired){
		this.hitRequired=hitRequired;
	}
	
	public int getHitRequired() {
		return hitRequired;
	}
	
	public static ShipType getShipType(String type) {
		return ShipType.valueOf(type);
	}
}
