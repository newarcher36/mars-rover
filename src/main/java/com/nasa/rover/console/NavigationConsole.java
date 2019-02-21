package com.nasa.rover.console;

import java.util.List;

import com.nasa.exception.InvalidCommandException;
import com.nasa.rover.command.Command;
import com.nasa.values.Direction;

public class NavigationConsole implements Console {
	
	private Direction direction;
	private List<Command> commands;
	private Parser parser = new CommandParser();
	
	public List<Command> getCommands() {
		return this.commands;
	}
	
	@Override
	public void setCommands(List<Character> commandCharacters) throws InvalidCommandException {
		this.commands = parser.parseCommands(commandCharacters);
	}	
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
}
