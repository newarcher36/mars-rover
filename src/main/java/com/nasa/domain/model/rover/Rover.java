package com.nasa.domain.model.rover;

import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.console.Console;
import com.nasa.domain.values.Direction;

public interface Rover {

	Position getPosition();
	
	void setPosition(Position position);
	
	void move(Position nextPosition) throws ObstacleException;
	
	void rotate(Direction direction);		
	
	Console getNavigationConsole();
	
	boolean isObstacleDetected(Position nextPosition);		
	
	void go() throws ObstacleException;
}
