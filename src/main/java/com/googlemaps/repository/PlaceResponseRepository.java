package com.googlemaps.repository;

import com.googlemaps.model.PlaceResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceResponseRepository extends JpaRepository<PlaceResponse, Integer> {
}
