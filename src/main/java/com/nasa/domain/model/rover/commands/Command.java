package com.nasa.domain.model.rover.commands;

import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.rover.Rover;

public interface Command {
	
	void execute(Rover rover) throws ObstacleException;
}
