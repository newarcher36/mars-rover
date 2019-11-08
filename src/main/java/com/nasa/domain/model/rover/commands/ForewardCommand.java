package com.nasa.domain.model.rover.commands;

import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Direction;


public class ForewardCommand implements Command {
		
	@Override
	public void execute(Rover rover) throws ObstacleException {
		Direction direction = rover.getNavigationConsole().getDirection();
		Position nextPosition = rover.getPosition().getNextPosition(direction);
		rover.move(nextPosition);
	}
}