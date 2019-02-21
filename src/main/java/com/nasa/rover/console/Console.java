package com.nasa.rover.console;

import java.util.List;

import com.nasa.exception.InvalidCommandException;
import com.nasa.rover.command.Command;
import com.nasa.values.Direction;

public interface Console {

	List<Command> getCommands();
	
	void setCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	Direction getDirection();
	
	void setDirection(Direction newDirection);	
}
