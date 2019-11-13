package com.nasa.marsrover.domain.values;

public enum Cmd {
	
	FOREWARD('f'),
	BACKWARD('b'),
	RIGHT_ROTATION('r'),
	LEFT_ROTATION('l');
	
	private final char commandChar;
	
	Cmd(char commandChar) {
		this.commandChar = commandChar;
	}
	
	public char getChar() {
		return commandChar;
	}
}
