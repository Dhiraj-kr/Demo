package com.battleship.util;

public class CharacterUtil {

	public static int convertToInt(char c) {
		
		return (int)c-64;
	}
	public static char convertToChar(int c) {
		
		return (char)(c+65);
	}
}
