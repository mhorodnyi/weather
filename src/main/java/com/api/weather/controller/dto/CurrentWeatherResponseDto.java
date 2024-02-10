package com.api.weather.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentWeatherResponseDto {
    private String observationTime;
    private String temperature;
    private String windSpeed;
    private String windDegree;
    private String windDirection;
    private String pressure;
    private String precipitation;
    private String humidity;
    private String cloudCover;
    private String feelsLike;
    private String uvIndex;
    private String visibility;
}
