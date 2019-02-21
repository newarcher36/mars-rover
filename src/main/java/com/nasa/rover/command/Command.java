package com.nasa.rover.command;

import com.nasa.exception.ObstacleException;
import com.nasa.rover.Rover;

public interface Command {
	
	void execute(Rover rover) throws ObstacleException;
}
