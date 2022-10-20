package com.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIsNotFoundException extends RuntimeException{
    private static final String message =  "The user wanted update is not active";

    public UserIsNotFoundException() {
        super(message);
    }
}
