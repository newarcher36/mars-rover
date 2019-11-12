package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.values.MapSettings;

public interface MapService {
    PlanetMap createMap(MapSettings mapSettings);
}
