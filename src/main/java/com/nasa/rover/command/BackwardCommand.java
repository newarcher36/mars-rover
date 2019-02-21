package com.nasa.rover.command;

import com.nasa.exception.ObstacleException;
import com.nasa.planet.Position;
import com.nasa.rover.Rover;
import com.nasa.values.Direction;

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
