package com.googlemaps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceResponseDto {
    private LocationDto locationDto;
    private String name;
    private Double rating;
    private String vicinity;
}
