package com.wallapop.rover.commands;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class RightCommand implements Command {
	
	static {
		CommandRegistry.register('r',new ForewardCommand());
	}

	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection(); 		
		int directionValue = direction.getValue();
		
		if (++directionValue == Direction.values().length) {
			directionValue = Direction.NORTH.getValue();
		}
		
		direction = Direction.getDirectionByValue(directionValue);
		rover.move(direction);
	}
}
