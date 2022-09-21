package com.googlemaps.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendRequest {
    private String longitude;
    private String latitude;
    private String radius;
}
