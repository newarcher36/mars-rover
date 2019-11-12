package com.nasa.marsrover.api;

import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.usecase.CreateMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/mars")
public class MarsMapController {

    private final CreateMap createMap;

    public MarsMapController(CreateMap createMap) {
        this.createMap = createMap;
    }

    @PostMapping(value = "/map", consumes = APPLICATION_JSON_VALUE)
    public PlanetMap createMap(@RequestBody MapSettings mapSettings) {
        return createMap.execute(mapSettings);
    }
}