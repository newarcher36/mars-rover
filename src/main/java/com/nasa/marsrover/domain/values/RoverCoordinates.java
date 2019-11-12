package com.nasa.marsrover.domain.values;


public class RoverCoordinates extends Coordinates {

    private final Direction direction;

    public RoverCoordinates(int x, int y, Direction direction) {
        super(x,y);
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("Mars Rover moved to coordinates x:%d y:%d and is facing to the %s",x,y,direction);
    }
}
