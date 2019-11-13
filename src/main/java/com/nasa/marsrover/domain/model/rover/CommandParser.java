package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.model.rover.commands.Command;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CommandParser {

    private final List<Command> commands;

    public CommandParser(List<Command> commands) {
        this.commands = commands;
    }

    public List<Command> parse(String commandChars) {
        return commandChars.chars()
                .mapToObj(cmdChar -> commands.stream()
                        .filter(cmd -> cmd.isImplemented(cmdChar))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Invalid command " + (char) cmdChar)))
                .collect(Collectors.toList());
    }
}
