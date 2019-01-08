package com.wallapop.rover;

import com.wallapop.planet.Position;
import com.wallapop.values.Direction;

public interface Rover {

	Position getPosition();
	
	void setPosition(Position position);
	
	void moveRover(Direction direction);
	
	void turnRover(int directionValue);
	
	NavigationConsole getNavigationConsole();
	
	void go();
	
}
