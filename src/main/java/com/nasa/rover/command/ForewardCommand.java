package com.nasa.rover.command;

import com.nasa.exception.ObstacleException;
import com.nasa.planet.Position;
import com.nasa.rover.Rover;
import com.nasa.values.Direction;


public class ForewardCommand implements Command {
		
	@Override
	public void execute(Rover rover) throws ObstacleException {
		Direction direction = rover.getNavigationConsole().getDirection();
		Position nextPosition = rover.getPosition().getNextPosition(direction);
		rover.move(nextPosition);
	}
}