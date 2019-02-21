package com.nasa.rover;

import com.nasa.exception.ObstacleException;
import com.nasa.planet.Position;
import com.nasa.rover.console.Console;
import com.nasa.values.Direction;

public interface Rover {

	Position getPosition();
	
	void setPosition(Position position);
	
	void move(Position nextPosition) throws ObstacleException;
	
	void rotate(Direction direction);		
	
	Console getNavigationConsole();
	
	boolean isObstacleDetected(Position nextPosition);		
	
	void go() throws ObstacleException;
}
