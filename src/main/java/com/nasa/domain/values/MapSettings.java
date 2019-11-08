package com.nasa.domain.values;

import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode
public class MapSettings {

    private final Coordinates mapSize;
    private final Set<Coordinates> obstacleCoordinates;
    private final RoverCoordinates roverCoordinates;

    public MapSettings(Coordinates mapSize, Set<Coordinates> obstacleCoordenates, RoverCoordinates roverCoordinates) {
        this.mapSize = mapSize;
        this.obstacleCoordinates = obstacleCoordenates;
        this.roverCoordinates = roverCoordinates;
    }

    public Coordinates getMapSize() {
        return mapSize;
    }

    public Set<Coordinates> getObstacleCoordinates() {
        return obstacleCoordinates;
    }

    public RoverCoordinates getRoverCoordinates() {
        return roverCoordinates;
    }
}
