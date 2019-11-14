package com.nasa.marsrover.domain.model.planet;

import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class PlanetMapShould {

    private PlanetMap planetMap;

    @BeforeEach
    void init() {
        planetMap = new PlanetMap(10, 8);
    }

    @Test
    void
    create_an_empty_map_given_a_length_x_and_y() {
        int sizeX = 10;
        int sizeY = 8;

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                Position position = planetMap.getPosition(x, y);
                assertNotNull(position);
                assertNull(position.getRover());
                assertFalse(position.hasObstacle());
            }
        }
    }

    @Test
    void
    map_has_wrapped_edges_from_north_to_south() {

        Position currentPosition = planetMap.getPosition(0, 0);
        Position northPosition = currentPosition.getNextPosition(Direction.NORTH);

        assertNotNull(northPosition);
        assertEquals(9, northPosition.getX());
        assertEquals(0, northPosition.getY());
    }

    @Test
    void
    map_has_wrapped_edges_from_south_to_north() {

        Position currentPosition = planetMap.getPosition(9, 0);
        Position southPosition = currentPosition.getNextPosition(Direction.SOUTH);

        assertNotNull(southPosition);
        assertEquals(0, southPosition.getX());
        assertEquals(0, southPosition.getY());
    }

    @Test
    void
    map_has_wrapped_edges_from_west_to_east() {

        Position currentPosition = planetMap.getPosition(0, 0);
        Position westPosition = currentPosition.getNextPosition(Direction.WEST);

        assertNotNull(westPosition);
        assertEquals(0, westPosition.getX());
        assertEquals(7, westPosition.getY());
    }

    @Test
    void
    map_has_wrapped_edges_from_east_to_west() {

        Position currentPosition = planetMap.getPosition(0, 7);
        Position eastPosition = currentPosition.getNextPosition(Direction.EAST);

        assertNotNull(eastPosition);
        assertEquals(0, eastPosition.getX());
        assertEquals(0, eastPosition.getY());
    }

    @ParameterizedTest
    @MethodSource("direction_and_expected_x")
    void
    get_north_and_south_positions_given_a_current_position(Direction direction, int expectedX) {

        Position currentPosition = planetMap.getPosition(4, 4);
        Position nextPosition = currentPosition.getNextPosition(direction);

        assertNotNull(nextPosition);
        assertEquals(expectedX, nextPosition.getX());
        assertEquals(4, nextPosition.getY());
    }

    private static Stream<Arguments> direction_and_expected_x() {
        return Stream.of(
                Arguments.of(Direction.NORTH, 3),
                Arguments.of(Direction.SOUTH, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("direction_and_expected_y")
    void
    get_west_and_east_positions_given_a_current_position(Direction direction, int expectedY) {

        Position currentPosition = planetMap.getPosition(4, 4);
        Position nextPosition = currentPosition.getNextPosition(direction);

        assertNotNull(nextPosition);
        assertEquals(4, nextPosition.getX());
        assertEquals(expectedY, nextPosition.getY());
    }

    private static Stream<Arguments> direction_and_expected_y() {
        return Stream.of(
                Arguments.of(Direction.WEST, 3),
                Arguments.of(Direction.EAST, 5)
        );
    }

    @Test
    void
    create_map_by_default_values_when_no_size_is_provided() {
        int sizeX = 10;
        int sizeY = 8;

        PlanetMap planetMap = new PlanetMap(0, 0);

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                assertNotNull(planetMap.getPosition(x, y));
            }
        }
    }

    @Test
    void
    render_map() {
        planetMap.getPosition(2, 2).setRover(new Rover());
        planetMap.getPosition(3, 3).setObstacle(new Obstacle());

        String expecedMap =
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|#|_|_|_|_|_|\n" +
                        "|_|_|_|X|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|\n" +
                        "|_|_|_|_|_|_|_|_|";

        assertEquals(expecedMap, planetMap.toString().trim());
    }

    @Test void
    fail_when_map_size_x_less_than_zero() {
        Assertions.assertThatThrownBy(() -> { new PlanetMap(-1,0); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Size [x] cannot be less than 0");
    }

    @Test void
    fail_when_map_size_y_less_than_zero() {
        Assertions.assertThatThrownBy(() -> { new PlanetMap(-1,0); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Size [x] cannot be less than 0");
    }
}