package com.wallapop.rover.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.commands.Command;
import com.wallapop.rover.commands.CommandRegistry;
import com.wallapop.utils.Utils;
import com.wallapop.values.Direction;

public class NavigationConsole implements Console {
	
	private Direction direction;
	private List<Command> commands;
	private String message = "";
	
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
        	Command command = CommandRegistry.getCommand(commandChar);
        	Optional.ofNullable(command).orElseThrow(() -> new InvalidCommandException("Invalid command: " + commandChar));
        	commands.add(command);
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
