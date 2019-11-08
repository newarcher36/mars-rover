package com.nasa.domain.model.rover.commands;

import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Direction;

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