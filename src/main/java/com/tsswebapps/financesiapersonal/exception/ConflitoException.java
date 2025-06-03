package com.tsswebapps.financesiapersonal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitoException extends RuntimeException{
    public ConflitoException(String message) {
        super(message);
    }

    public ConflitoException(String message, Throwable cause) {
        super(message, cause);
    }
}
