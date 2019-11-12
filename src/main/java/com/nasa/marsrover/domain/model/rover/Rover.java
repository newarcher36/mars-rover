package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.Position;
import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.model.rover.console.NavigationConsole;
import com.nasa.marsrover.domain.values.Direction;

public class Rover {

	private Position currentPosition;
	private NavigationConsole navigationConsole = new NavigationConsole();

	public NavigationConsole getNavigationConsole() {
		return this.navigationConsole;
	}

	public Position getPosition() {
		return this.currentPosition;
	}

	public void setPosition(Position position) {
		this.currentPosition = position;
	}		

	public void moveTo(Direction direction) throws ObstacleException {

		Position nextPosition = currentPosition.getNextPosition(direction);
		
		if (isObstacleDetected(nextPosition)) {
			throw new ObstacleException("Obstacle detected! Rover has stopped.");
		}
	
		this.currentPosition.setRover(null);
		setPosition(nextPosition);
		this.currentPosition.setRover(this);
	}

	boolean isObstacleDetected(Position nextPosition) {
		return nextPosition.getObstacle() != null;
	}

	public void rotate(Direction direction) {		
		navigationConsole.setDirection(direction);		
	}

	public void go() throws ObstacleException {		
		for (Command command : navigationConsole.getCommands()) {
			command.execute(this);
		}			
	}

    public String toString() {
		return "#";
	}
}
