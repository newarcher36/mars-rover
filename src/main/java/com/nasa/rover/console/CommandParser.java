package com.nasa.rover.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nasa.exception.InvalidCommandException;
import com.nasa.rover.command.BackwardCommand;
import com.nasa.rover.command.Command;
import com.nasa.rover.command.CommandRegistry;
import com.nasa.rover.command.ForewardCommand;
import com.nasa.rover.command.LeftRotationCommand;
import com.nasa.rover.command.RightRotationCommand;
import com.nasa.values.CmdChar;

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
