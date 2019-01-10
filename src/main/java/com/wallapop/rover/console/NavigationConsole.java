package com.wallapop.rover.console;

import java.util.List;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.commands.Command;
import com.wallapop.utils.Utils;
import com.wallapop.values.Direction;

public class NavigationConsole implements Console {
	
	private Direction direction;
	private List<Command> commands;
	private String message = "";
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
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public Console setMessage(String msg) {
		this.message = msg;
		return this;
	}
	
	public void print() {
		Utils.printMessage(this.message);
	}
}
