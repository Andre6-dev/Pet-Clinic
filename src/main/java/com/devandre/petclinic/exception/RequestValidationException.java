package com.devandre.petclinic.exception;

/**
 * andre on 13/10/2023
 */
public class RequestValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RequestValidationException(String message) {
        super(message);
    }

}
