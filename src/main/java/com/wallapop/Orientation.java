package com.wallapop;

public enum Orientation {
	
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	private final int orientationCode;

	private Orientation(int orientationCode) {
		this.orientationCode = orientationCode;
	}
	
	public int getValue() {
		return this.orientationCode;
	}
}
