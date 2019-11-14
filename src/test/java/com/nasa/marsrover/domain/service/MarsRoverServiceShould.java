package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.exception.InvalidCommandException;
import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.Obstacle;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.model.rover.CommandParserService;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Coordinates;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
@ExtendWith(MockitoExtension.class)
class MarsRoverServiceShould {

    private MarsRoverService marsRoverService;

    @Mock
    private CommandParserService commandParserService;

    @BeforeEach
    void init() {
        marsRoverService = new MarsRoverService(commandParserService);
    }

    @Test void
    create_mars_map_given_a_map_settings() {
        PlanetMap actualMap = marsRoverService.createMap(aMapSettings());

        PlanetMap expectedMap = new PlanetMap(5, 5);
        expectedMap.getPosition(2,2).setRover(new Rover());
        expectedMap.getPosition(3,3).setObstacle(new Obstacle());

        assertThat(expectedMap)
                .usingRecursiveComparison()
                .isEqualTo(actualMap);
    }

    @Test void
    move_rover_to_a_given_position_in_the_map() throws ObstacleException, InvalidCommandException {
        RoverCoordinates expectedCoordinates = new RoverCoordinates(1,4, Direction.NORTH);
        PlanetMap planetMap = new PlanetMap(0, 0);

        marsRoverService.getMarsRover().setStartPoint(expectedCoordinates);

        RoverCoordinates actualCoordinates = marsRoverService.moveRover(new Orders("fflb"));

        Assertions.assertEquals(expectedCoordinates, actualCoordinates);
    }

    private MapSettings aMapSettings() {
        return new MapSettings(5, 5, Set.of(new Coordinates(3,3)), new RoverCoordinates(2,2, Direction.NORTH));
    }
}