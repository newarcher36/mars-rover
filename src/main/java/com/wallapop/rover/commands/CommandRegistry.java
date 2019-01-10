package com.wallapop.rover.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

	private static Map<Character,Command> registry = new HashMap<Character,Command>();

    public static void register(char commandChar, Command command) {
    	registry.put(commandChar,command);
    }
    
    public static Command getCommand(char commandChar) {
    	return registry.get(commandChar);
    }
}
