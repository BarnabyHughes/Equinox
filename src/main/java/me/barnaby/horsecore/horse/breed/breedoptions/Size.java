package me.barnaby.horsecore.horse.breed.breedoptions;

import lombok.Getter;

public enum Size {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    @Getter
    private final String name;

    Size(String name) {
        this.name = name;
    }


}
