package com.myproject.handler;

import com.myproject.domain.ErrorDetails;
import com.myproject.resources.exceptions.CustomExistEntity;
import com.myproject.resources.exceptions.CustomNotFoundException;
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

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(CustomNotFoundException e, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                System.currentTimeMillis(), 404L, "Entidade não encontrada", "http://errors.livraria.com/404"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CustomExistEntity.class )
    protected ResponseEntity<Object> resourceConflict(CustomExistEntity e, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                System.currentTimeMillis(), 404L, "Entidade já persistida", "http://errors.livraria.com/409"
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
