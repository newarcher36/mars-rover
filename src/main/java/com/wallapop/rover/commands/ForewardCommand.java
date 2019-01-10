package com.wallapop.rover.commands;

import com.wallapop.planet.Position;
import com.wallapop.rover.Rover;
import com.wallapop.values.Direction;

public class ForewardCommand implements Command {
	
	static char c = 'f';
	
	static {
		CommandRegistry.register(c,new ForewardCommand());
	}
		
	@Override
	public void execute(Rover rover) {
		Direction direction = rover.getNavigationConsole().getDirection();
		Position nextPosition = rover.getPosition().getNextPosition(direction);
		rover.move(nextPosition);
	}
}