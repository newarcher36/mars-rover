package com.nasa.rover.console;

import java.util.List;

import com.nasa.exception.InvalidCommandException;
import com.nasa.rover.command.Command;

public interface Parser {
	
	List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	void loadCommands();
}
