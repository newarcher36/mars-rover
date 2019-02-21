package com.nasa.planet;

import com.nasa.rover.Rover;
import com.nasa.values.Direction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
	
	private Rover marsRover;	
	private Position[] positionsAround = new Position[4];
	private Obstacle obstacle;
	private int row;
	private int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public Rover getRover() {
		return this.marsRover;
	}

	public void setRover(Rover marsRover) {
		this.marsRover = marsRover;
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
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
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
