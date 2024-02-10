package com.api.weather.service;

import com.api.weather.client.dto.WeatherstackResponseDto;

public interface WeatherClient {
    WeatherstackResponseDto getWeatherByCity(String city);
}
