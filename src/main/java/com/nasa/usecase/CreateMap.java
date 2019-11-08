package com.nasa.usecase;

import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.service.MapService;
import com.nasa.domain.values.MapSettings;

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
