package com.nasa.api;

import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.values.Coordinates;
import com.nasa.domain.values.Direction;
import com.nasa.domain.values.MapSettings;
import com.nasa.domain.values.RoverCoordinates;
import com.nasa.usecase.CreateMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MarsMapControllerShould {

    private MarsMapController marsMapController;

    @Mock
    private CreateMap createMap;

    @BeforeEach
    void init() {
        marsMapController = new MarsMapController(createMap);
    }

    @Test
    void create_mars_map_given_a_map_settings() {
        PlanetMap expectedMap = aNewPlanetMap();
        given(createMap.execute(aMapSettings())).willReturn(aNewPlanetMap());

        PlanetMap actualMap = marsMapController.createMap(aMapSettings());

        assertThat(actualMap)
                .usingRecursiveComparison()
                .isEqualTo(expectedMap);
    }

    private MapSettings aMapSettings() {
        return new MapSettings(new Coordinates(5, 5), Set.of(new Coordinates(3,2)), new RoverCoordinates(2,2, Direction.NORTH));
    }

    private PlanetMap aNewPlanetMap() {
        return new PlanetMap(new Coordinates(5, 5));
    }
}