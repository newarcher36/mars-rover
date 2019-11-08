package com.nasa.domain.model.rover.commands;

import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Direction;

public class LeftRotationCommand implements Command {
	
	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection(); 		
		int directionValue = direction.getValue();
		
		if (--directionValue < 0) {
			directionValue = Direction.WEST.getValue();
		} 
		
		direction = Direction.getDirectionByValue(directionValue);
		rover.rotate(direction);		
	}
}
