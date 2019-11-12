package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.model.planet.Obstacle;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.model.planet.Position;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.RoverCoordinates;

import javax.inject.Named;

@Named
public class MarsMapService implements MapService {

    private final RoverService roverService;

    public MarsMapService(RoverService roverService) {
        this.roverService = roverService;
    }

    @Override
    public PlanetMap createMap(MapSettings mapSettings) {
        PlanetMap planetMap = new PlanetMap(mapSettings.getSizeX(), mapSettings.getSizeY());

        RoverCoordinates roverCoordinates = mapSettings.getRoverCoordinates();
        Position roverPosition = planetMap.getPosition(roverCoordinates.getX(), roverCoordinates.getY());

        Rover rover = roverService.getRover();
        roverPosition.setRover(rover);
        rover.setPosition(roverPosition);

        if (mapSettings.hasObstacleCoordinates()) {
            mapSettings.getObstacleCoordinates()
                    .forEach(coordinate -> {
                        planetMap
                                .getPosition(coordinate.getX(), coordinate.getY())
                                .setObstacle(new Obstacle());
                    });
        }

        return planetMap;
    }
}
