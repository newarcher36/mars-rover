package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.model.planet.Obstacle;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Coordinates;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MarsMapServiceShould {

    private MarsMapService marsMapService;

    @Mock
    private Rover rover;

    @Mock
    private MarsRoverService marsRoverService;

    @BeforeEach
    void init() {
        marsMapService = new MarsMapService(marsRoverService);
    }

    @Test void
    create_mars_map_given_a_map_settings() {
        given(marsRoverService.getRover()).willReturn(rover);

        PlanetMap actualMap = marsMapService.createMap(aMapSettings());

        PlanetMap expectedMap = new PlanetMap(5, 5);
        expectedMap.getPosition(2,2).setRover(rover);
        expectedMap.getPosition(3,3).setObstacle(new Obstacle());

        assertThat(expectedMap).usingRecursiveComparison().isEqualTo(actualMap);
    }

    private MapSettings aMapSettings() {
        return new MapSettings(5, 5, Set.of(new Coordinates(3,3)), new RoverCoordinates(2,2, Direction.NORTH));
    }
}