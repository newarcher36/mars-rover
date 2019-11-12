package com.nasa.marsrover.domain.model.rover.console;

import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.values.Direction;

import java.util.List;

public class NavigationConsole {
	
	private Direction direction;
	private List<Command> commands;
	private CommandParser commandParser = new CommandParser(commamnds);
	
	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Character> commandCharacters) {
		this.commands = commandParser.parseCommands(commandCharacters);
	}	

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
}
