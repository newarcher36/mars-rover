package com.nasa.marsrover.domain.model.rover.commands;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Cmd;
import com.nasa.marsrover.domain.values.Direction;

import javax.inject.Named;

@Named
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

		rover.moveTo(direction);
	}

	@Override
	public boolean isImplemented(int cmdValue) {
		return Cmd.BACKWARD.getChar() == cmdValue;
    }
}
