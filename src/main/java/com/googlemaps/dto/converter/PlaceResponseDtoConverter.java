package com.googlemaps.dto.converter;

import com.googlemaps.dto.LocationDto;
import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.model.GoogleResponse;
import com.googlemaps.model.Location;
import com.googlemaps.model.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlaceResponseDtoConverter {

    private final LocationDtoConverter locationDtoConverter;

    public PlaceResponseDto convert(PlaceResponse placeResponse) {
        return new PlaceResponseDto(
                locationDtoConverter.convert(placeResponse.getLocation()),
                placeResponse.getName(),
                placeResponse.getRating(),
                placeResponse.getVicinity()
        );
    }

    public List<PlaceResponseDto> convertGoogleResponseToPlaceResponse(GoogleResponse response) {

        List<PlaceResponseDto> result = new ArrayList<>();
        response.getResults()
                .forEach(results ->
                    result.add(new PlaceResponseDto(
                            new LocationDto(
                                    results.getLocation().getLongitude(),
                                    results.getLocation().getLatitude()
                            ),
                            results.getName(),
                            results.getRating(),
                            results.getVicinity()))
                );

        return result;
    }
}
