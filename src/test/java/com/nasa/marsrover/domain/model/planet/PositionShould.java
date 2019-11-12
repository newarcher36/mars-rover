package com.nasa.marsrover.domain.model.planet;

import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionShould {

    private Position currentPosition;

    @BeforeEach
    void init() {
        currentPosition = new Position(2, 3);
    }

    @Test void
    get_coordinates_given_a_position() {
        assertEquals(2, currentPosition.getX());
        assertEquals(3, currentPosition.getY());
    }

    @Test void
    set_rover_in_a_position() {
        Rover rover = new Rover();
        currentPosition.setRover(rover);

        assertEquals(currentPosition.getRover(), rover);
    }

    @Test void
    set_obstacle_in_a_position() {
        Obstacle obstacle = new Obstacle();
        currentPosition.setObstacle(obstacle);

        assertEquals(currentPosition.getObstacle(), obstacle);
    }

    @Test void
    given_a_current_position_get_north_position() {
        Position northPosition = new Position(1,1);
        currentPosition.setPositionAround(northPosition, Direction.NORTH.getValue());

        assertEquals(northPosition, currentPosition.getNextPosition(Direction.NORTH));
    }

    @Test void
    given_a_current_position_get_south_position() {
        Position southPosition = new Position(1,1);
        currentPosition.setPositionAround(southPosition, Direction.SOUTH.getValue());

        assertEquals(southPosition, currentPosition.getNextPosition(Direction.SOUTH));
    }

    @Test void
    given_a_current_position_get_east_position() {
        Position currentPosition = new Position(0, 0);

        Position eastPosition = new Position(1,1);
        currentPosition.setPositionAround(eastPosition, Direction.EAST.getValue());

        assertEquals(eastPosition, currentPosition.getNextPosition(Direction.EAST));
    }

    @Test void
    given_a_current_position_get_west_position() {
        Position westPosition = new Position(1,1);
        currentPosition.setPositionAround(westPosition, Direction.WEST.getValue());

        assertEquals(westPosition, currentPosition.getNextPosition(Direction.WEST));
    }

    @Test void
    fail_when_create_a_position_with_coordinate_X_less_than_zero() {
        Assertions.assertThatThrownBy(() -> { new Position(-1,0); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Coordinate [x] cannot be less than 0");
    }

    @Test void
    fail_when_create_a_position_with_coordinate_Y_less_than_zero() {
        Assertions.assertThatThrownBy(() -> { new Position(0,-1); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Coordinate [y] cannot be less than 0");
    }

    @Test void
    render_position_when_rover() {
        currentPosition.setRover(new Rover());
        assertEquals(currentPosition.toString(), "#");
    }

    @Test void
    render_position_when_obstacle() {
        currentPosition.setObstacle(new Obstacle());
        assertEquals(currentPosition.toString(), "X");
    }

    @Test void
    render_position_when_empty() {
        assertEquals(currentPosition.toString(), "");
    }
}