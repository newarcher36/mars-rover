package com.nasa.domain.model.rover.console;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.model.rover.commands.BackwardCommand;
import com.nasa.domain.model.rover.commands.Command;
import com.nasa.domain.model.rover.commands.CommandRegistry;
import com.nasa.domain.model.rover.commands.ForewardCommand;
import com.nasa.domain.model.rover.commands.LeftRotationCommand;
import com.nasa.domain.model.rover.commands.RightRotationCommand;
import com.nasa.domain.values.CmdChar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		CommandRegistry.register(CmdChar.FOREWARD,new ForewardCommand());
		CommandRegistry.register(CmdChar.BACKWARD,new BackwardCommand());
		CommandRegistry.register(CmdChar.LEFT_ROTATION,new LeftRotationCommand());
		CommandRegistry.register(CmdChar.RIGHT_ROTATION,new RightRotationCommand());
	}	
}
