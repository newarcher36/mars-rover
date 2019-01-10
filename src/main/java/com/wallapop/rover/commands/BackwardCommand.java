package com.wallapop.rover.commands;

import com.wallapop.planet.Position;
import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class BackwardCommand implements Command {

	@Override
	public void execute(Rover rover) {
		
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
