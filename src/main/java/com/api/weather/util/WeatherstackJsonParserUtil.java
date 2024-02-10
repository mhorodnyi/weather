package com.api.weather.util;

import com.api.weather.client.dto.WeatherstackResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherstackJsonParserUtil {
    private static final String ERROR_FIELD_NAME = "error";
    private static final String INFO_FIELD_NAME = "info";

    private final ObjectMapper mapper;

    public String readErrorInfoField(String json) throws JsonProcessingException {
        return mapper.readValue(json, JsonNode.class).get(ERROR_FIELD_NAME).get(INFO_FIELD_NAME).asText();
    }

    public WeatherstackResponseDto parseFromJson(String json) throws JsonProcessingException {
        return mapper.readValue(json, WeatherstackResponseDto.class);
    }
}
