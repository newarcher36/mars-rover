package com.wallapop;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private Rover rover;
	private Direction[] directions = new Direction[4];

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public Direction getDirection(Orientation orientation) {
		return directions[orientation.getValue()];
	}

	public void setDirection(Direction direction, int orientation) {
		this.directions[orientation] = direction;
	}
	
	@Override
	public String toString() {
		String position = "";
		
		if (rover != null) {
			position = rover.toString();
		}
		
		return position;
	}

	public Rover getRover() {
		return this.rover;
	}
}
