package com.nasa.marsrover.domain.model.rover.commands;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Cmd;
import com.nasa.marsrover.domain.values.Direction;

import javax.inject.Named;

@Named
public class ForewardCommand implements Command {
		
	@Override
	public void execute(Rover rover) throws ObstacleException {
		Direction direction = rover.getDirection();
		rover.moveTo(direction);
	}

	@Override
	public boolean isImplemented(int cmdValue) {
		return Cmd.FOREWARD.getChar() == cmdValue;
	}
}