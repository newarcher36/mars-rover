package com.nasa.rover.command;

import com.nasa.rover.Rover;
import com.nasa.values.Direction;

public class RightRotationCommand implements Command {	

	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection(); 		
		int directionValue = direction.getValue();
		
		if (++directionValue == Direction.values().length) {
			directionValue = Direction.NORTH.getValue();
		}
		
		direction = Direction.getDirectionByValue(directionValue);
		rover.rotate(direction);
	}
}
