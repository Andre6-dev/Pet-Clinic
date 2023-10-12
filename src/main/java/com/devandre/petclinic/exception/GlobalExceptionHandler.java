package com.devandre.petclinic.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

/**
 * andre on 12/10/2023
 */
@Slf4j(topic = "GlobalExceptionHandler")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException: {}", ex.getMessage());
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                null);
    }
}
