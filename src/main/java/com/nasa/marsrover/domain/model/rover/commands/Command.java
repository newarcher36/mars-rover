package com.nasa.marsrover.domain.model.rover.commands;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.rover.Rover;

public interface Command {

	void execute(Rover rover) throws ObstacleException;

    boolean isImplemented(int cmdValue);
}
