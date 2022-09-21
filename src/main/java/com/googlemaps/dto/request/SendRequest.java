package com.googlemaps.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendRequest {
    private double longitude;
    private double latitude;
    private double radius;
}
