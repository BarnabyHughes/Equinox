package me.barnaby.horsecore.horse.breed.breedoptions;

import lombok.Getter;

public enum Category {

    BAROQUE("Baroque");

    @Getter
    private final String name;
    Category(String name) {
        this.name = name;
    }

}
