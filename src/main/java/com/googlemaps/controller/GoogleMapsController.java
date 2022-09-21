package com.googlemaps.controller;

import com.googlemaps.dto.PlaceResponseDto;
import com.googlemaps.dto.request.SendRequest;
import com.googlemaps.service.GoogleMapsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@CrossOrigin
public class GoogleMapsController {

    private final GoogleMapsService googleMapsService;

    @GetMapping
    public ResponseEntity<List<PlaceResponseDto>> sendResponse(@RequestParam double longitude, @RequestParam double latitude
            , @RequestParam double radius) {

        return new ResponseEntity<>(googleMapsService.sendResponse(new SendRequest(longitude, latitude, radius)), HttpStatus.OK);
    }
}
