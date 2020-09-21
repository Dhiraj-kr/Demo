package com.battleship.util;

public class CellUtil {

	public static int getRowPos(String coordinates) {
		return CharacterUtil.convertToInt(coordinates.charAt(0));
	}
	
	public static int getColPos(String coordinates) {
		return Character.getNumericValue(coordinates.charAt(1));
	}
}
