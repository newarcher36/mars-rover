package com.nasa.marsrover.domain.model.rover;

import com.nasa.marsrover.domain.model.rover.commands.BackwardCommand;
import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.model.rover.commands.ForewardCommand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandParserServiceShould {

    private CommandParserService commandParserService;

    @Test
    void
    given_a_set_of_chars_parse_to_commands() {
        commandParserService = new CommandParserService(List.of(new BackwardCommand(), new ForewardCommand()));
        List<Command> actualCommands = commandParserService.parse("fb");

        assertThat(actualCommands.get(0))
                .isInstanceOf(ForewardCommand.class);
        assertThat(actualCommands.get(1))
                .isInstanceOf(BackwardCommand.class);
    }

    @Test void
    fail_when_command_does_not_exist() {
        assertThatThrownBy(() -> commandParserService.parse("x"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid command x");
    }

}