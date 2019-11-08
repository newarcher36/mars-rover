package com.nasa.api;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.values.Direction;
import com.nasa.domain.values.Orders;
import com.nasa.domain.values.RoverCoordinates;
import com.nasa.usecase.MoveRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RoverControllerShould {

    private RoverController roverController;

    @Mock
    private MoveRover moveRover;

    @BeforeEach
    void init() {
        roverController = new RoverController(moveRover);
    }

    @Test void
    move_rover_to_a_given_position_in_the_map() throws ObstacleException, InvalidCommandException {
        Orders orders = new Orders("fflb");
        RoverCoordinates expectedCoordinates = aRoverCoordinates();
        given(moveRover.execute(orders)).willReturn(expectedCoordinates);

        RoverCoordinates actualCoordinates = roverController.driveRover(orders);

        assertThat(expectedCoordinates)
                .usingRecursiveComparison()
                .isEqualTo(actualCoordinates);
    }

    private RoverCoordinates aRoverCoordinates() {
        return new RoverCoordinates(3, 3, Direction.NORTH);
    }
}
