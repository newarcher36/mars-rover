package com.wallapop.planet;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private Rover marsRover;	
	private Position[] positionsAround = new Position[4];
	private Obstacle obstacle;
	
	public Rover getRover() {
		return this.marsRover;
	}

	public void setRover(Rover marsRover) {
		this.marsRover = marsRover;
	}
	
	public Position getNextPosition(Direction orientation) {
		return positionsAround[orientation.getValue()];
	}

	public void setPositionAround(Position position, int direction) {
		this.positionsAround[direction] = position;
	}	

	public Obstacle getObstacle() {
		return this.obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	
	@Override
	public String toString() {
		String position = "";
		
		if (marsRover != null) {
			position = marsRover.toString();
		} else if(obstacle != null) {
			position = obstacle.toString();
		}
		
		return position;
	}
}
