package com.devandre.petclinic.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * andre on 12/10/2023
 */
@Getter
@Setter
public class ErrorMessage {

    private final int statusCode;
    private final String message;
    private Date timestamp;
    private String description;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
