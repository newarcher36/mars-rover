package com.nasa.domain.model.rover.console;

import java.util.List;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.model.rover.commands.Command;
import com.nasa.domain.values.Direction;

public interface Console {

	List<Command> getCommands();
	
	void setCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	Direction getDirection();
	
	void setDirection(Direction newDirection);	
}
