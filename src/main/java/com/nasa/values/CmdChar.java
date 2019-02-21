package com.nasa.values;

public enum CmdChar {
	
	FOREWARD('f'),
	BACKWARD('b'),
	RIGHT_ROTATION('r'),
	LEFT_ROTATION('l');
	
	private final char commandChar;
	
	private CmdChar(char commandChar) {
		this.commandChar = commandChar;
	}
	
	public char getChar() {
		return commandChar;
	}
}
