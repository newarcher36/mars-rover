package com.wallapop.rover;

import java.util.List;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.values.Command;
import com.wallapop.values.Direction;

public interface Console {

	List<Command> getCommands();
	
	void setCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	Direction getDirection();
	
	void setDirection(Direction newDirection);
	
	Direction getOppositeDirection();
}
