package com.googlemaps.service;

import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.dto.converter.PlaceResponseDtoConverter;
import com.googlemaps.dto.request.SendRequest;
import com.googlemaps.model.GoogleResponse;
import com.googlemaps.repository.PlaceResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private final String googleApiKey;

    private final RestTemplate restTemplate;
    private final PlaceResponseDtoConverter placeResponseDtoConverter;
    private final PlaceResponseRepository placeResponseRepository;

    public List<PlaceResponseDto> sendResponse(SendRequest request) {

        String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + request.getLatitude()
                + "," + request.getLongitude() + "&radius="
                + request.getRadius() + "&types=food&key="
                + googleApiKey;

        GoogleResponse response = restTemplate.getForObject(URL, GoogleResponse.class);


        return placeResponseDtoConverter.convertGoogleResponseToPlaceResponse(response);
    }
}
