package com.wallapop.rover.console;

import java.util.List;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.commands.Command;
import com.wallapop.values.Direction;

public interface Console {

	List<Command> getCommands();
	
	void setCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	Direction getDirection();
	
	void setDirection(Direction newDirection);	
	
	String getMessage();
	
	Console setMessage(String msg);
	
	void print();
}
