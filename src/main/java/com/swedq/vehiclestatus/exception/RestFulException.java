package com.swedq.vehiclestatus.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class RestFulException extends RuntimeException {
    private Map<String, Object> properties;
    private Integer errorCode;
    private String errorMessage;

    public RestFulException(Integer errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestFulException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }



}