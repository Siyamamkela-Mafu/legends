package com.siyama.legends.controller.advice;

import com.siyama.legends.domain.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handle(final MethodArgumentNotValidException e) {
        var error = Error.builder()
                .message(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .retryAfter(0)
                .build();
        return ResponseEntity.badRequest().body(error);
    }
}