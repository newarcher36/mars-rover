package com.nasa.domain.service;

import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.model.rover.MarsRover;
import com.nasa.domain.values.Coordinates;
import com.nasa.domain.values.Direction;
import com.nasa.domain.values.MapSettings;
import com.nasa.domain.values.RoverCoordinates;
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
    private MarsRover marsRover;

    @Mock
    private MarsRoverService marsRoverService;

    @BeforeEach
    void init() {
        marsMapService = new MarsMapService(marsRoverService);
    }

    @Test void
    create_mars_map_given_a_map_settings() {
        given(marsRoverService.getRover()).willReturn(marsRover);

        PlanetMap actualMap = marsMapService.createMap(aMapSettings());

        PlanetMap expectedMap = new PlanetMap(new Coordinates(5, 5));
        expectedMap.setRover(new RoverCoordinates(2,2, Direction.NORTH),marsRover);
        expectedMap.setObstacles(Set.of(new Coordinates(3,2)));

        assertThat(expectedMap).usingRecursiveComparison().isEqualTo(actualMap);
    }

    private MapSettings aMapSettings() {
        return new MapSettings(new Coordinates(5, 5), Set.of(new Coordinates(3,2)), new RoverCoordinates(2,2, Direction.NORTH));
    }
}