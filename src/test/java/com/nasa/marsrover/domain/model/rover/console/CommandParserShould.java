package com.nasa.marsrover.domain.model.rover.console;

import com.nasa.marsrover.domain.model.rover.commands.BackwardCommand;
import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.model.rover.commands.ForewardCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class CommandParserShould {

    private CommandParser commandParser;

    @BeforeEach
    void init() {
        commandParser = new CommandParser(Set.of(new ForewardCommand(), new BackwardCommand()));
    }

    @Test void
    given_a_set_of_chars_parse_to_commands() {
        List<Character> commandChars = List.of('f','b');
        //List<Command> expectedCommands = List.of(new ForewardCommand(), new BackwardCommand());

        List<Command> actualCommands = commandParser.parseCommands(commandChars);

        Assertions.assertThat(actualCommands)
                .isNotNull()
                .contains(new ForewardCommand(), new BackwardCommand());
    }
}