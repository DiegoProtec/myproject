package com.myproject.handler;

import com.myproject.handler.exceptions.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> resourceError(Exception ex, WebRequest request) {
        ErrorDetails erros = new ErrorDetails(System.currentTimeMillis(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erros, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(CustomNotFoundException e, WebRequest request) {
        ErrorDetails erros = new ErrorDetails(System.currentTimeMillis(), "Dado não encontrado, erro:" + e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
    }
}
