package com.api.weather.controller;

import com.api.weather.exception.CouldNotRequestException;
import com.api.weather.exception.InternalException;
import com.api.weather.exception.WeatherstackException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CouldNotRequestException.class)
    public ResponseEntity<String> handleCouldNotRequestException(CouldNotRequestException couldNotRequestException) {
        return new ResponseEntity<>(couldNotRequestException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<String> handleInternalException(InternalException internalException) {
        return new ResponseEntity<>(internalException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WeatherstackException.class)
    public ResponseEntity<String> handleWeatherstackException(WeatherstackException weatherstackException) {
        return new ResponseEntity<>(weatherstackException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
