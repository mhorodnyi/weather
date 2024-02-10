package com.api.weather.mapper;

import com.api.weather.client.dto.WeatherstackResponseDto;
import com.api.weather.controller.dto.CurrentWeatherResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface WeatherstackDtoMapper {
    CurrentWeatherResponseDto toCurrentResponseDto(WeatherstackResponseDto weatherstackResponseDto);
}
