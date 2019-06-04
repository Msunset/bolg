package com.sunset.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class notfinException extends RuntimeException {
    public notfinException() {
    }

    public notfinException(String message) {
        super(message);
    }

    public notfinException(String message, Throwable cause) {
        super(message, cause);
    }
}
