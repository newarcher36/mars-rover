package com.wallapop.rover.command;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class RightCommand implements Command {	

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
