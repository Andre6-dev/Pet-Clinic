package com.devandre.petclinic.exception;

/**
 * andre on 14/10/2023
 */
public class GenericException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GenericException(String message) {
        super(message);
    }
}
