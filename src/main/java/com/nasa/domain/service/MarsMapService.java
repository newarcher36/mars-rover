package com.nasa.domain.service;

import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.values.Direction;
import com.nasa.domain.values.MapSettings;

import javax.inject.Named;

@Named
public class MarsMapService implements MapService {

    private final RoverService roverService;

    public MarsMapService(RoverService roverService) {
        this.roverService = roverService;
    }

    @Override
    public PlanetMap createMap(MapSettings mapSettings) {
        PlanetMap planetMap = new PlanetMap(mapSettings.getMapSize());
        planetMap.setRover(mapSettings.getRoverCoordinates(), roverService.getRover());
        planetMap.setObstacles(mapSettings.getObstacleCoordinates());

        int x = mapSettings.getRoverCoordinates().getX();
        int y = mapSettings.getRoverCoordinates().getY();

        roverService.getRover().setPosition(planetMap.getPosition(x,y));
        roverService.getRover().getNavigationConsole().setDirection(Direction.NORTH);

        return planetMap;
    }
}
