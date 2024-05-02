package me.barnaby.horsecore.illness;

import java.util.ArrayList;
import java.util.List;

public enum Ilnesses {

    MELONMAS;
    public static List<Ilnesses> fromStringList(List<String> styleStrings) {
        List<Ilnesses> ilnesses = new ArrayList<>();
        for (String ilnessesString : styleStrings) {
            try {
                ilnesses.add(Ilnesses.valueOf(ilnessesString.toUpperCase()));
            } catch (IllegalArgumentException e) {
                // Handle invalid style strings if needed
                System.err.println("Invalid illness: " + ilnessesString);
            }
        }
        return ilnesses;
    }


}
