package com.wallapop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NavigationConsole {
	
	private Direction direction;
	private List<Command> commands;

	public void setCommands(List<Character> commandCharacters) throws InvalidCommandException {
		this.commands = computeCommands(commandCharacters);
	}

	private List<Command> computeCommands(List<Character> commandCharacters) throws InvalidCommandException {
		
		List<Command> commands = new ArrayList<>();
		
		for (char commandChar : commandCharacters) {
			Command command = Command.getCommandByChar(commandChar);
			Optional<Command> optional = Optional.of(command);
			commands.add(optional.orElseThrow(() -> new InvalidCommandException("Invalid command " + commandChar)));
		}
		
		return commands;
	}

	public List<Command> getCommands() {
		return this.commands;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
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
	
	public void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
}
