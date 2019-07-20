package com.swedq.vehiclestatus.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends  RuntimeException{
    private Long errorCode;
    private String errorMessage;

    public BusinessException(Long errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
