package com.wallapop.values;

import java.util.HashMap;
import java.util.Map;

public enum Command {
	
	FOREWARD('f'),
	BACKWARD('b'),
	RIGHT('r'),
	LEFT('l');
	
	private char name;
	private static Map<Character,Command> mapCommands = new HashMap<>();
	
	static {
		for (Command command : Command.values()) {
			mapCommands.put(command.name, command);
		}
	}
	
	private Command(char commandChar) {
		this.name = commandChar;
	}
	
	public static Command getCommandByChar(char commandName) {
		return mapCommands.get(commandName);
	}
}
