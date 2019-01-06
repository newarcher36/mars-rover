package com.wallapop;

public class Direction {
	
	private Position nextPosition; 	

	public Direction(Position position) {
		this.nextPosition = position;
	}

	public Position getNextPosition() {
		return nextPosition;
	}
}
