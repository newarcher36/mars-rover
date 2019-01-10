package com.wallapop.rover.commands;

import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class LeftCommand implements Command {
	
	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection(); 		
		int directionValue = direction.getValue();
		
		if (--directionValue < 0) {
			directionValue = Direction.WEST.getValue();
		} 
		
		direction = Direction.getDirectionByValue(directionValue);
		rover.move(direction);		
	}
}
