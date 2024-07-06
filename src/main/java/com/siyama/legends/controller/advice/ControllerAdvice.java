package com.siyama.legends.controller.advice;

import com.siyama.legends.domain.Error;
import com.siyama.legends.exception.ObjectAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> handle(final MethodArgumentNotValidException e) {
        var error = Error.builder()
                .message(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage())
                .statusCode(HttpStatus.BAD_REQUEST.toString())
                .retryAfter(0)
                .build();
        log.error(String.valueOf(error));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({ObjectAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Error> handle(final ObjectAlreadyExistsException e) {
        var error = Error.builder()
                .message(e.getMessage())
                .statusCode(String.valueOf(HttpStatus.CONFLICT.value()))
                .retryAfter(0)
                .build();
        log.error(String.valueOf(error));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
