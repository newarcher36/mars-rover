package com.nasa.marsrover.usecase;

import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.service.MarsMapService;
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
class CreateMapShould {

    private CreateMap createMap;

    @Mock
    private MarsMapService marsMapService;

    @BeforeEach
    void init() {
        createMap = new CreateMap(marsMapService);
    }

    @Test void
    create_mars_map_given_a_map_settings() {
        PlanetMap expectedMap = aNewPlanetMap();
        given(marsMapService.createMap(aMapSettings())).willReturn(expectedMap);

        PlanetMap actualMap = createMap.execute(aMapSettings());

        assertThat(actualMap)
                .usingRecursiveComparison()
                .isEqualTo(expectedMap);
    }

    private MapSettings aMapSettings() {
        return new MapSettings(5, 5, Set.of(new Coordinates(3,2)), new RoverCoordinates(2,2, Direction.NORTH));
    }

    private PlanetMap aNewPlanetMap() {
        return new PlanetMap(0, 0);
    }
}