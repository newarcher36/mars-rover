package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.Position;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.RoverCoordinates;

public class Rover {

	private Position currentPosition;
	private Direction currentDirection;
	private final CommandParser commandParser;

	public Rover(CommandParser parser) {
		this.commandParser = parser;
	}
	// out startPosition
	public void setPosition(Position position) {
		this.currentPosition = position;
	}

	public void moveTo(Direction direction) {

		Position nextPosition = currentPosition.getNextPosition(direction);
		
		if (nextPosition.hasObstacle()) {
			throw new ObstacleException("Obstacle detected, rover cannot perform orders!");
		}
	
		currentPosition.setRover(null);
		currentPosition = nextPosition;
		currentPosition.setRover(this);
	}

	public void rotate(Direction newDirection) {
		this.currentDirection = newDirection;
	}

	public void go(String cmdChars) {
		commandParser.parse(cmdChars)
				.forEach(command -> command.execute(this));
	}

    public String toString() {
		return "#";
	}

	// check
	public RoverCoordinates getRoverInfo() {
		return new RoverCoordinates(currentPosition.getX(), currentPosition.getY(), currentDirection);
	}
}
