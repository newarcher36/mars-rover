package com.wallapop.rover;

import com.wallapop.planet.Position;

public interface Rover {

	Position getPosition();
	
	void setPosition(Position position);
	
	void moveRover(Position nextPosition);
	
	void turnRover(int directionValue);
	
	Console getNavigationConsole();
	
	void go();
}
