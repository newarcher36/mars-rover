package com.wallapop.values;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
	
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	private final int directionCode;
	private static Map<Integer,Direction> mapDirections = new HashMap<>();
	
	static {
		for (Direction direction : Direction.values()) {
			mapDirections.put(direction.getValue(), direction);
		}
	}

	private Direction(int directionCode) {
		this.directionCode = directionCode;
	}
	
	public int getValue() {
		return this.directionCode;
	}
	
	public static Direction getDirectionByValue(int value) {
		return mapDirections.get(value);
	}
}
