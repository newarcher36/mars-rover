package com.wallapop.rover.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.rover.command.BackwardCommand;
import com.wallapop.rover.command.Command;
import com.wallapop.rover.command.CommandRegistry;
import com.wallapop.rover.command.ForewardCommand;
import com.wallapop.rover.command.LeftCommand;
import com.wallapop.rover.command.RightCommand;

public class CommandParser implements Parser {

	@Override
	public List<Command> parseCommands(List<Character> commandCharacters) throws InvalidCommandException {				
		
		loadCommands();
		
		List<Command> commands = new ArrayList<>();
		Command command;		
        for (char commandChar : commandCharacters) {
        	Optional<Command> optional = Optional.ofNullable(CommandRegistry.getCommand(commandChar)) ;
        	command = optional.orElseThrow(() -> new InvalidCommandException("Invalid command: " + commandChar));
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
