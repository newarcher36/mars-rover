package com.wallapop;

public enum Direction {
	
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	private final int directionCode;

	private Direction(int directionCode) {
		this.directionCode = directionCode;
	}
	
	public int getValue() {
		return this.directionCode;
	}
}
