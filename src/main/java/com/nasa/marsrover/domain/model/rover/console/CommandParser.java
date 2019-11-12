package com.nasa.marsrover.domain.model.rover.console;

import com.nasa.marsrover.domain.model.rover.commands.Command;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Named
class CommandParser {

	private final Map<Character,Command> roverCommands = new HashMap<>();
	private final Set<Command> commamnds;

	CommandParser(Set<Command> commamnds) {
		this.commamnds = commamnds;
	}

	List<Command> parseCommands(List<Character> commandCharacters) {

		commandCharacters.stream();
//		loadCommands();
//
//		List<Command> commands = new ArrayList<>();
//		Command command;
//        for (char commandChar : commandCharacters) {
//        	Optional<Command> optional = Optional.ofNullable(CommandRegistry.getCommand(commandChar)) ;
//        	command = optional.orElseThrow(() -> new IllegalArgumentException("Invalid command: " + commandChar));
//        	commands.add(command);
//        }
//
//		return commands;
		return null;
	}

//	private void loadCommands() {
//		roverCommands.put(CmdChar.FOREWARD.getChar(), new ForewardCommand());
//		roverCommands.put(CmdChar.BACKWARD.getChar(), new BackwardCommand());
//		roverCommands.put(CmdChar.LEFT_ROTATION.getChar(), new LeftRotationCommand());
//		roverCommands.put(CmdChar.RIGHT_ROTATION.getChar(), new RightRotationCommand());
//	}
}
