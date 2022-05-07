package com.acme.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

/**
 * Shows error details on results
 */
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private final Integer code;
    private final String message;
    private final Object details;

    ApiError(Throwable exception){
        this.code  = 400;
        this.message = exception.getMessage();
        this.details = null;
    }
    public ApiError(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.details = null;
    }
    public ApiError(Integer code, String message, Object details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    ApiError(String message) {
        this.code = 400;
        this.message = message;
        this.details= null;
    }
}
