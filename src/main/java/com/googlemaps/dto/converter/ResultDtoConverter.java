package com.googlemaps.dto.converter;

import com.googlemaps.dto.ResultDto;
import com.googlemaps.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ResultDtoConverter {

    private final LocationDtoConverter locationDtoConverter;

    public ResultDto convert(Result result) {
        return new ResultDto(
                result.getName(),
                result.getVicinity(),
                result.getRating(),
                locationDtoConverter.convert(result.getLocation())
        );
    }

}
