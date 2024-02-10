package com.api.weather.client;

import com.api.weather.client.dto.WeatherstackResponseDto;
import com.api.weather.exception.CouldNotRequestException;
import com.api.weather.exception.InternalException;
import com.api.weather.exception.WeatherstackException;
import com.api.weather.service.WeatherClient;
import com.api.weather.util.WeatherstackJsonParserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class WeatherstackClient implements WeatherClient {
    private static final String CURRENT_ENDPOINT_FORMAT = "/current?access_key=%s&query=%s";
    private static final String EMPTY_RESPONSE_BODY = "Empty Return Body";
    private static final String ERROR_FIELD_NAME = "error";

    @Value("${weatherstack.accessKey}")
    private String accessKey;

    @Value("${weatherstack.host}")
    private String host;

    private final RestTemplate restTemplate;
    private final WeatherstackJsonParserUtil weatherstackJsonParserUtil;

    public WeatherstackResponseDto getWeatherByCity(String city) {
        String url = host + String.format(CURRENT_ENDPOINT_FORMAT, accessKey, city);

        try {
            return makeRequest(url);
        } catch (RestClientException restClientException) {
            throw new CouldNotRequestException(restClientException.getLocalizedMessage());
        } catch (JsonProcessingException e) {
            throw new InternalException();
        }
    }

    private WeatherstackResponseDto makeRequest(String url) throws JsonProcessingException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URI.create(url), String.class);

        Optional.ofNullable(responseEntity.getBody()).orElseThrow(() -> new WeatherstackException(EMPTY_RESPONSE_BODY));

        if (responseEntity.getBody().contains(ERROR_FIELD_NAME)) {
            throw new WeatherstackException(weatherstackJsonParserUtil.readErrorInfoField(responseEntity.getBody()));
        }

        return weatherstackJsonParserUtil.parseFromJson(responseEntity.getBody());
    }


}
