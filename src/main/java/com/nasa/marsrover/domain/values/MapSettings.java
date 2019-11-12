package com.nasa.marsrover.domain.values;

import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode
public class MapSettings {

    private final int sizeX;
    private final int sizeY;
    private final Set<Coordinates> obstacleCoordinates;
    private final RoverCoordinates roverCoordinates;

    public MapSettings(int sizeX, int sizeY, Set<Coordinates> obstacleCoordinates, RoverCoordinates roverCoordinates) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.obstacleCoordinates = obstacleCoordinates;
        this.roverCoordinates = roverCoordinates;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Set<Coordinates> getObstacleCoordinates() {
        return obstacleCoordinates;
    }

    public RoverCoordinates getRoverCoordinates() {
        return roverCoordinates;
    }

    public boolean hasObstacleCoordinates() {
        return obstacleCoordinates.size() > 0;
    }
}
