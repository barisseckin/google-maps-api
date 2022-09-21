package com.googlemaps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String name;
    private String vicinity;
    private double rating;
    private Location location;
}
