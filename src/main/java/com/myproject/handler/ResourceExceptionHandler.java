package com.myproject.handler;

import com.myproject.domain.ErrorDetails;
import com.myproject.domain.ErrorMessage;
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
import java.util.Arrays;
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
    protected ResponseEntity<Object> resourceNotFound(CustomNotFoundException e, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                System.currentTimeMillis(), 404L,
                "Entidade não encontrada.",
                "http://errors.livraria.com/404: "
        );
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomExistEntityException.class)
    protected ResponseEntity<Object> resourceConflict(CustomExistEntityException e, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                System.currentTimeMillis(), 404L,
                "Entidade já persistida.",
                "http://errors.livraria.com/409"
        );
        return new ResponseEntity(error, HttpStatus.CONFLICT);
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
                status.value(),
                status.getReasonPhrase(),
                "Validção falhou ao enviar os dados."
        );

        msg.setErrors(mensagens);
        return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
    }
}

