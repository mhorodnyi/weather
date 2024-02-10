package com.api.weather.exception;

public class InternalException extends RuntimeException {
    private static final String MESSAGE = "Internal error, please try again later";

    public InternalException() {
        super(MESSAGE);
    }
}
