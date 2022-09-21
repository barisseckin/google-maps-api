package com.googlemaps.service;

import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.dto.converter.PlaceResponseDtoConverter;
import com.googlemaps.dto.request.SendRequest;
import com.googlemaps.exception.PlaceExistException;
import com.googlemaps.model.GoogleResponse;
import com.googlemaps.model.Location;
import com.googlemaps.model.PlaceResponse;
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
    String googleApiKey;

    private final RestTemplate restTemplate;
    private final PlaceResponseDtoConverter placeResponseDtoConverter;
    private final PlaceResponseRepository placeResponseRepository;

    public List<PlaceResponseDto> sendResponse(SendRequest request) {

        String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + request.getLatitude()
                + "," + request.getLongitude()
                + "&radius=" + request.getRadius()
                + "&types=food&key=" + googleApiKey;

        GoogleResponse response = restTemplate.getForObject(URL, GoogleResponse.class);

        List<PlaceResponseDto> responseDto = placeResponseDtoConverter.convertGoogleResponseToPlaceResponse(response);

        for (PlaceResponseDto result : responseDto) {
            if (!placeResponseRepository.existsByName(result.getName())) {
                PlaceResponse placeResponse = new PlaceResponse(new Location(result.getLocationDto().getLongitude(), result.getLocationDto().getLatitude()),
                        result.getName(), result.getRating(), result.getVicinity());

                placeResponseRepository.save(placeResponse);
                return placeResponseDtoConverter.convertGoogleResponseToPlaceResponse(response);
            }
            throw new PlaceExistException(result + "exist");
        }
        return null;
    }
}

