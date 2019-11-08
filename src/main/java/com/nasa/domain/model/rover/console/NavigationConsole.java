package com.nasa.domain.model.rover.console;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.model.rover.commands.Command;
import com.nasa.domain.values.Direction;

import java.util.List;

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
