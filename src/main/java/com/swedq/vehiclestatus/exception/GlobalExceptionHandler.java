package com.swedq.vehiclestatus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RestFulException.class)
    public ResponseEntity<RestFulException> handleRestFulException(RestFulException e) {

        return new ResponseEntity<RestFulException>(e, HttpStatus.valueOf(e.getErrorCode()));
    }
}