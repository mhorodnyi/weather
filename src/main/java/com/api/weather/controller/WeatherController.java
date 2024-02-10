package com.api.weather.controller;

import com.api.weather.controller.dto.CurrentWeatherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{cityName}")
    public CurrentWeatherResponseDto getWeatherByCity(@PathVariable("cityName") String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}
