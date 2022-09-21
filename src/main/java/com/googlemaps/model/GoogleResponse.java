package com.googlemaps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleResponse {
    private String page;
    private List<Result> results;
    private String status;
}
