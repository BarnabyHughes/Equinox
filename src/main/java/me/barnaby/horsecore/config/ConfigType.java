package me.barnaby.horsecore.config;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
public enum ConfigType {
    BREEDS("breeds.yml"),
    HORSELEVELS("horselevels.yml"),
    MESSAGES("messages.yml");

    private final String configPath;

    @Setter
    @Getter
    private File file;

    ConfigType(String configPath) {
        this.configPath = configPath;
    }

}
