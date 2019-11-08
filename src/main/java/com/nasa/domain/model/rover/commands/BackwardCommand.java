package com.nasa.domain.model.rover.commands;

import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Direction;

public class BackwardCommand implements Command {

	@Override
	public void execute(Rover rover) throws ObstacleException {
		
		Direction direction = rover.getNavigationConsole().getDirection(); 
		
		switch (direction) {
		case NORTH:
			 direction =  Direction.SOUTH;
			 break;
		case EAST:
			direction =  Direction.WEST;
			break;
		case SOUTH:
			direction =  Direction.NORTH;
			break;
		case WEST:
			direction =  Direction.EAST;
			break;
		}
		
		Position nextPosition = rover.getPosition().getNextPosition(direction);
		rover.move(nextPosition);
	}	
}
