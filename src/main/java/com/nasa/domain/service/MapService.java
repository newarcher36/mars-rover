package com.nasa.domain.service;

import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.values.MapSettings;

public interface MapService {
    PlanetMap createMap(MapSettings mapSettings);
}
