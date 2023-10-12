package com.devandre.petclinic.exception;

/**
 * andre on 12/10/2023
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
