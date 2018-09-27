package com.myproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaException extends RuntimeException{

    public CategoriaException(String exception) {
        super(exception);
    }
}
