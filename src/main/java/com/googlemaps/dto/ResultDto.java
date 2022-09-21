package com.googlemaps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDto {
    private String name;
    private String vicinity;
    private double rating;
    private LocationDto locationDto;
}
