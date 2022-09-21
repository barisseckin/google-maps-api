package com.googlemaps.dto.converter;

import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.model.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    public List<PlaceResponseDto> convert(List<PlaceResponse> placeResponses) {
        return placeResponses.stream().map(this::convert).collect(Collectors.toList());
    }
}
