package com.wallapop.rover.commands;

import com.wallapop.planet.Position;
import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;


public class ForewardCommand implements Command {
		
	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection();
		Position nextPosition = rover.getPosition().getNextPosition(direction);
		rover.move(nextPosition);
	}
}