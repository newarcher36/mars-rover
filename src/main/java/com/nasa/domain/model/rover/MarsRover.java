package com.nasa.domain.model.rover;

import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.commands.Command;
import com.nasa.domain.model.rover.console.Console;
import com.nasa.domain.model.rover.console.NavigationConsole;
import com.nasa.domain.values.Direction;

public class MarsRover implements Rover {

	private Position currentPosition;
	private Console navigationConsole = new NavigationConsole();

	@Override
	public Console getNavigationConsole() {
		return this.navigationConsole;
	}

	@Override
	public Position getPosition() {
		return this.currentPosition;
	}

	@Override
	public void setPosition(Position position) {
		this.currentPosition = position;
	}		
	
	@Override
	public void move(Position nextPosition) throws ObstacleException {
		
		if (isObstacleDetected(nextPosition)) {
			throw new ObstacleException("Obstacle detected! Rover has stopped.");
		}
	
		this.currentPosition.setRover(null);
		setPosition(nextPosition);
		this.currentPosition.setRover(this);
	}
	
	@Override
	public boolean isObstacleDetected(Position nextPosition) {
		return nextPosition.getObstacle() != null;
	}
	
	@Override
	public void rotate(Direction direction) {		
		navigationConsole.setDirection(direction);		
	}
	
	@Override
	public void go() throws ObstacleException {		
		for (Command command : navigationConsole.getCommands()) {
			command.execute(this);
		}			
	}

	@Override
    public String toString() {
		return "#";
	}
}
