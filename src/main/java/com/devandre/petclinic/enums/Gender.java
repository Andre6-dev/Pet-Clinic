package com.devandre.petclinic.enums;

import lombok.Getter;

@Getter
public enum Gender {
    M("MALE"),
    F("FEMALE"),
    O("OTHER");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
