package com.nasa.marsrover.usecase;

import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.service.MapService;
import com.nasa.marsrover.domain.values.MapSettings;

import javax.inject.Named;

@Named
public class CreateMap {

    private final MapService mapService;

    public CreateMap(MapService mapService) {
        this.mapService = mapService;
    }

    public PlanetMap execute(MapSettings mapSettings) {
        return mapService.createMap(mapSettings);
    }
}
