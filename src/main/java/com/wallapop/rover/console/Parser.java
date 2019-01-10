package com.wallapop.rover.console;

import java.util.List;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.commands.Command;

public interface Parser {
	
	List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException;
	
	void loadCommands();
}
