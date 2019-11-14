package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.model.rover.commands.Command;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CommandParserService implements ParserService {

    private final List<Command> commands;

    public CommandParserService(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public List<Command> parse(String commandChars) {
        return commandChars.chars()
                .mapToObj(cmdChar -> commands.stream()
                        .filter(cmd -> cmd.isImplemented(cmdChar))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Invalid command " + (char) cmdChar)))
                .collect(Collectors.toList());
    }
}
