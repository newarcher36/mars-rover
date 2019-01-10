package com.wallapop.rover;

import com.wallapop.planet.Position;
import com.wallapop.rover.console.Console;
import com.wallapop.values.Direction;

public interface Rover {

	Position getPosition();
	
	void setPosition(Position position);
	
	void move(Position nextPosition);
	
	void move(Direction direction);		
	
	Console getNavigationConsole();
	
	void detectObstacle(Position nextPosition);
	
	void rearmRover();
	
	boolean isObstacleDetected();
	
	void go();
}
