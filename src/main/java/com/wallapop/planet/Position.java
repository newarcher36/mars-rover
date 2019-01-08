package com.wallapop.planet;

import com.wallapop.rover.MarsRover;
import com.wallapop.values.Direction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private MarsRover rover;
	private Position[] positionsAround = new Position[4];

	public void setRover(MarsRover rover) {
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

	public MarsRover getRover() {
		return this.rover;
	}
}
