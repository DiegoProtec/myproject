package com.myproject.handlers;

import com.myproject.domains.ErrorMessage;
import com.myproject.resources.exceptions.CustomExistEntityException;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
@RestController
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public ResourceExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CustomNotFoundException.class)
    protected ResponseEntity<Object> resourceNotFound(CustomNotFoundException ex, HttpStatus status, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(
                System.currentTimeMillis(),
                status.value(),
                status.getReasonPhrase(),
                "http://errors.livraria.com/404: "
        );
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomExistEntityException.class)
    protected ResponseEntity<Object> resourceConflict(CustomExistEntityException ex, HttpStatus status, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(
                System.currentTimeMillis(),
                status.value(),
                status.getReasonPhrase(),
                "http://errors.livraria.com/409"
        );
        return new ResponseEntity(msg, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        Locale local = LocaleContextHolder.getLocale();

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<String> mensagens = new ArrayList<>();

        errors.stream().forEach(
                msg -> {
                    String campo = msg.getField().substring(msg.getField().indexOf(".") + 1);
                    String error = messageSource.getMessage(msg, local);
                    mensagens.add("Campo " + campo + ": " + error);
                }
        );

        ErrorMessage msg = new ErrorMessage(
                System.currentTimeMillis(),
                status.value(),
                status.getReasonPhrase(),
                "Augmentos inválidos."
        );

        msg.setErrors(mensagens);

        return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
    }
}

