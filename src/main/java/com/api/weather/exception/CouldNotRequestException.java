package com.api.weather.exception;

public class CouldNotRequestException extends RuntimeException {
    public CouldNotRequestException(String message) {
        super(message);
    }
}
