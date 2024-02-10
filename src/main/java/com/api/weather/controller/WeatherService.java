package com.api.weather.controller;

import com.api.weather.controller.dto.CurrentWeatherResponseDto;

public interface WeatherService {
    CurrentWeatherResponseDto getWeatherByCity(String city);
}
