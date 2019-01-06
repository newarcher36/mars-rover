package com.wallapop;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private Rover rover;
	private Position[] positionsAround = new Position[4];

	public void setRover(Rover rover) {
		this.rover = rover;
	}
	
	public Position getNextPosition(Direction orientation) {
		return positionsAround[orientation.getValue()];
	}

	public void setPositionAround(Position position, int direction) {
		this.positionsAround[direction] = position;
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
