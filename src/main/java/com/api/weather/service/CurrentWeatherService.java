package com.api.weather.service;

import com.api.weather.controller.WeatherService;
import com.api.weather.controller.dto.CurrentWeatherResponseDto;
import com.api.weather.mapper.WeatherstackDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CurrentWeatherService implements WeatherService {
    private final WeatherClient weatherClient;
    private final WeatherstackDtoMapper weatherstackDtoMapper;

    public CurrentWeatherResponseDto getWeatherByCity(String city) {
        return weatherstackDtoMapper.toCurrentResponseDto(weatherClient.getWeatherByCity(city));
    }
}
