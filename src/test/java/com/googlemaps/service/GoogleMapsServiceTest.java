package com.googlemaps.service;

import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.dto.converter.PlaceResponseDtoConverter;
import com.googlemaps.dto.request.SendRequest;
import com.googlemaps.model.GoogleResponse;
import com.googlemaps.repository.PlaceResponseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


public class GoogleMapsServiceTest {

    private PlaceResponseDtoConverter placeResponseDtoConverter;
    private PlaceResponseRepository placeResponseRepository;
    private RestTemplate restTemplate;

    private GoogleMapsService googleMapsService;

    @Value("${google.maps.api.key}")
    private String googleApiKey;

    @BeforeEach
    public void setUp() {
        placeResponseRepository = mock(PlaceResponseRepository.class);
        placeResponseDtoConverter = mock(PlaceResponseDtoConverter.class);
        restTemplate = mock(RestTemplate.class);

        googleMapsService = new GoogleMapsService(restTemplate, placeResponseDtoConverter, placeResponseRepository);
    }

    @Test
    public void testSendResponse_itShouldReturnPlaceResponseDtoList() {
        GoogleResponse response = new GoogleResponse();
        SendRequest request = new SendRequest(300, 400, 200);
        List<PlaceResponseDto> responseDtoList = new ArrayList<>();

        String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + request.getLatitude()
                + "," + request.getLongitude()
                + "&radius=" + request.getRadius()
                + "&types=food&key=" + googleApiKey;

        when(restTemplate.getForObject(URL, GoogleResponse.class)).thenReturn(response);
        when(placeResponseDtoConverter.convertGoogleResponseToPlaceResponse(response)).thenReturn(responseDtoList);

        List<PlaceResponseDto> resultList = googleMapsService.sendResponse(request);

        assertEquals(resultList, responseDtoList);

    }


}