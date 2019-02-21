package com.nasa.rover.command;

import java.util.HashMap;
import java.util.Map;

import com.nasa.values.CmdChar;

public class CommandRegistry {
	
	private CommandRegistry() {}

	private static Map<Character,Command> registry = new HashMap<>();

    public static void register(CmdChar commandChar, Command command) {
    	registry.put(commandChar.getChar(),command);
    }
    
    public static Command getCommand(char commandChar) {
    	return registry.get(commandChar);
    }
}
