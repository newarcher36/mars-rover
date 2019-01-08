package com.wallapop.rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.values.Command;
import com.wallapop.values.Direction;

public class NavigationConsole implements Console {
	
	private Direction direction;
	private List<Command> commands;
	
	public List<Command> getCommands() {
		return this.commands;
	}
	
	@Override
	public void setCommands(List<Character> commandCharacters) throws InvalidCommandException {
		this.commands = parseCommands(commandCharacters);
	}

	@Override
	public List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException {
		
		List<Command> commands = new ArrayList<>();
		
		for (char commandChar : commandCharacters) {
			Command command = Command.getCommandByChar(commandChar);
			Optional<Command> optional = Optional.ofNullable(command);
			commands.add(optional.orElseThrow(() -> new InvalidCommandException("Invalid command: " + commandChar)));
		}
		
		return commands;
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
	
	@Override
	public Direction getOppositeDirection() {		
		
		switch (direction) {
			case NORTH:
				 return Direction.SOUTH;				
			case EAST:
				return Direction.WEST;
			case SOUTH:
				return Direction.NORTH;
			case WEST:
				return Direction.EAST;	
			default:
				return this.direction;
		}		
	}
}
