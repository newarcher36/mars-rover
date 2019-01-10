package com.wallapop.rover.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.commands.BackwardCommand;
import com.wallapop.rover.commands.Command;
import com.wallapop.rover.commands.CommandRegistry;
import com.wallapop.rover.commands.ForewardCommand;
import com.wallapop.rover.commands.LeftCommand;
import com.wallapop.rover.commands.RightCommand;

public class CommandParser implements Parser {

	@Override
	public List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException {				
		
		loadCommands();
		
		List<Command> commands = new ArrayList<>();
				
        for (char commandChar : commandCharacters) {
        	Command command = CommandRegistry.getCommand(commandChar);
        	Optional.ofNullable(command).orElseThrow(() -> new InvalidCommandException("Invalid command: " + commandChar));
        	commands.add(command);
        }					
        
		return commands;		
	}
	
	public void loadCommands() {		
		CommandRegistry.register('f',new ForewardCommand());
		CommandRegistry.register('b',new BackwardCommand());
		CommandRegistry.register('l',new LeftCommand());
		CommandRegistry.register('r',new RightCommand());
	}	
}
