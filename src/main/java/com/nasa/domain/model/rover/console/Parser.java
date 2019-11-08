package com.nasa.domain.model.rover.console;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.model.rover.commands.Command;

import java.util.List;

public interface Parser {
	
	List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	void loadCommands();
}
