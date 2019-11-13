package com.nasa.marsrover.domain.model.rover.commands;

import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Cmd;
import com.nasa.marsrover.domain.values.Direction;

import javax.inject.Named;

@Named
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

	@Override
	public boolean isImplemented(int cmdValue) {
		return Cmd.LEFT_ROTATION.getChar() == cmdValue;
	}
}
