package com.devandre.petclinic.enums;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("PENDING"),
    IN_PROGRESS("IN PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

}
