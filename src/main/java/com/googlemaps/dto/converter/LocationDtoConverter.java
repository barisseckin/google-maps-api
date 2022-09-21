package com.googlemaps.dto.converter;

import com.googlemaps.dto.LocationDto;
import com.googlemaps.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationDtoConverter {

    public LocationDto convert(Location location) {
        return new LocationDto(
                location.getLongitude(),
                location.getLongitude()
        );
    }
}
