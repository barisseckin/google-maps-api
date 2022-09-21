package com.googlemaps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlaceResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    private String name;
    private Double rating;
    private String vicinity;

    public PlaceResponse(Location location, String name, Double rating, String vicinity) {
        this.location = location;
        this.name = name;
        this.rating = rating;
        this.vicinity = vicinity;
    }
}
