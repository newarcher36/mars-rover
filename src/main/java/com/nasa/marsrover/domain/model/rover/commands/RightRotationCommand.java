package com.nasa.marsrover.domain.model.rover.commands;

import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Cmd;
import com.nasa.marsrover.domain.values.Direction;

import javax.inject.Named;

@Named
public class RightRotationCommand implements Command {	

	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getDirection();
		int directionValue = direction.getValue();
		
		if (++directionValue == Direction.values().length) {
			directionValue = Direction.NORTH.getValue();
		}
		
		direction = Direction.getDirectionByValue(directionValue);
		rover.rotate(direction);
	}

	@Override
	public boolean isImplemented(int cmdValue) {
		return Cmd.RIGHT_ROTATION.getChar() == cmdValue;
	}
}
