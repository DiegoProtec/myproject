package com.myproject.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomExistEntity extends RuntimeException {

    public CustomExistEntity(String message) {
        super(message);
    }
}
