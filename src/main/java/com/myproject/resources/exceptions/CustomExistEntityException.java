package com.myproject.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomExistEntityException extends RuntimeException {

    public CustomExistEntityException(String message) {
        super(message);
    }

}
