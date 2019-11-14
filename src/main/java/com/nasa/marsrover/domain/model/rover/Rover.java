package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.Position;
import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.RoverCoordinates;

import java.util.List;

public class Rover {

	private Position position;
	private Direction direction;

	public void moveTo(Direction direction) {

		Position nextPosition = position.getNextPosition(direction);

		if (nextPosition.hasObstacle()) {
			throw new ObstacleException("Obstacle detected, rover cannot perform orders!");
		}

		position.setRover(null);
		position = nextPosition;
		position.setRover(this);
	}

	public void rotate(Direction newDirection) {
		this.direction = newDirection;
	}

	public RoverCoordinates getRoverInfo() {
		return new RoverCoordinates(position.getX(), position.getY(), direction);
	}

	public void go(List<Command> commands) {
		commands.forEach(command -> command.execute(this));
	}

	public void setStartPoint(RoverCoordinates roverCoordinates) {
		position = new Position(roverCoordinates.getX(),roverCoordinates.getY());
		direction = roverCoordinates.getStartDirection();
	}

	public Direction getDirection() {
		return direction;
	}

	public String toString() {
		return "#";
	}
}
