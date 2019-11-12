package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.exception.InvalidCommandException;
import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MarsRoverServiceShould {

    private MarsRoverService marsRoverService;

    @BeforeEach
    void init() {
        marsRoverService = new MarsRoverService();
    }

    @Test void
    get_rover() {
        marsRoverService.getRover();
    }

    @Test void
    move_rover_to_a_given_position_in_the_map() throws ObstacleException, InvalidCommandException {
        RoverCoordinates expectedCoordinates = new RoverCoordinates(1,4, Direction.NORTH);
        PlanetMap planetMap = new PlanetMap(0, 0);

        marsRoverService.getRover().setPosition(planetMap.getPosition(3,3));
        marsRoverService.getRover().getNavigationConsole().setDirection(Direction.NORTH);

        RoverCoordinates actualCoordinates = marsRoverService.moveRover(new Orders("fflb"));

        assertEquals(expectedCoordinates,actualCoordinates);
    }
}