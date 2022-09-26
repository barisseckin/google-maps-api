package com.googlemaps.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class SendRequest {
    @NotBlank
    private double longitude;
    @NotBlank
    private double latitude;
    private double radius;
}
