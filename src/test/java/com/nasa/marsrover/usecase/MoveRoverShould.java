package com.nasa.marsrover.usecase;

import com.nasa.marsrover.domain.exception.InvalidCommandException;
import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.service.MarsRoverService;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MoveRoverShould {

    private MoveRover moveRover;

    @Mock
    private MarsRoverService marsRoverService;

    @BeforeEach
    void init() {
        moveRover = new MoveRover(marsRoverService);
    }

    @Test void
    move_rover_to_a_given_position_in_the_map() throws ObstacleException, InvalidCommandException {
        Orders orders = new Orders("f,f,l,b");
        RoverCoordinates expectedCoordinates = aRoverCoordinates();

        given(moveRover.execute(orders)).willReturn(expectedCoordinates);

        RoverCoordinates actualCoordinates = moveRover.execute(orders);

        assertThat(expectedCoordinates)
                .usingRecursiveComparison()
                .isEqualTo(actualCoordinates);
    }

    private RoverCoordinates aRoverCoordinates() {
        return new RoverCoordinates(3, 3, Direction.NORTH);
    }
}