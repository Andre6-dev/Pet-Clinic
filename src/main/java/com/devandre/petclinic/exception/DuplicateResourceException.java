package com.devandre.petclinic.exception;

/**
 * andre on 13/10/2023
 */
public class DuplicateResourceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateResourceException(String message) {
        super(message);
    }

}
