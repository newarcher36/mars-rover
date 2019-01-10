package com.wallapop.rover.commands;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class BackwardCommand implements Command {

	static {
		CommandRegistry.register('b',new ForewardCommand());
	}

	@Override
	public void execute(Rover rover) {
		
		Direction direction = rover.getNavigationConsole().getDirection(); 
		
		switch (direction) {
		case NORTH:
			 direction =  Direction.SOUTH;				
		case EAST:
			direction =  Direction.WEST;
		case SOUTH:
			direction =  Direction.NORTH;
		case WEST:
			direction =  Direction.EAST;	
		}		
		rover.move(direction);
	}	
}
