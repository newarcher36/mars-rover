package com.nasa.domain.model.planet;

import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Direction;

public class Position {
	
	private Rover rover;
	private Position[] positionsAround = new Position[4];
	private Obstacle obstacle;
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rover getRover() {
		return this.rover;
	}

	public void setRover(Rover marsRover) {
		this.rover = marsRover;
	}
	
	public Position getNextPosition(Direction direction) {
		return positionsAround[direction.getValue()];
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
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		String position = "";
		
		if (rover != null) {
			position = rover.toString();
		} else if(obstacle != null) {
			position = obstacle.toString();
		}
		
		return position;
	}

}
