package com.rolemberg.eventostech.Handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppError.class)
    public ResponseEntity<Object> handleAppError(AppError error, WebRequest request) {
        return new ResponseEntity<>(Map.of("error", error.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
