package com.wallapop.planet;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private Rover marsRover;
	private Obstacle obstacle;
	private Position[] positionsAround = new Position[4];

	public void setRover(Rover marsRover) {
		this.marsRover = marsRover;
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
		
		if (marsRover != null) {
			position = marsRover.toString();
		}
		
		return position;
	}

	public Rover getRover() {
		return this.marsRover;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public Obstacle getObstacle() {
		return this.obstacle;
	}
}
