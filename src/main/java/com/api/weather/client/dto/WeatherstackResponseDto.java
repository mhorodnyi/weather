package com.api.weather.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherstackResponseDto implements Serializable {
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

    @JsonProperty("current")
    private void parseCurrent(Map<String,Object> current) {
        this.observationTime = String.valueOf(current.get("observation_time"));
        this.temperature = String.valueOf(current.get("temperature"));
        this.windSpeed = String.valueOf(current.get("wind_speed"));
        this.windDegree = String.valueOf(current.get("wind_degree"));
        this.windDirection = String.valueOf(current.get("wind_dir"));
        this.pressure = String.valueOf(current.get("pressure"));
        this.precipitation = String.valueOf(current.get("precip"));
        this.humidity = String.valueOf(current.get("humidity"));
        this.cloudCover = String.valueOf(current.get("cloudcover"));
        this.feelsLike = String.valueOf(current.get("feelslike"));
        this.uvIndex = String.valueOf(current.get("uv_index"));
        this.visibility = String.valueOf(current.get("visibility"));
    }
}
