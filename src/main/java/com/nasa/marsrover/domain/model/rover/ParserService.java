package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.model.rover.commands.Command;

import java.util.List;

public interface ParserService {
    List<Command> parse(String commandChars);
}
