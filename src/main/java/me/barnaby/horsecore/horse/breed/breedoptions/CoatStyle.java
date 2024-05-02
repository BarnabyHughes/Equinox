package me.barnaby.horsecore.horse.breed.breedoptions;

import me.barnaby.horsecore.utils.ClassDebug;

import java.util.ArrayList;
import java.util.List;

public enum CoatStyle {

    PAINT;

    public static List<CoatStyle> fromStringList(List<String> styleStrings) {
        List<CoatStyle> coatStyles = new ArrayList<>();
        for (String styleString : styleStrings) {
            try {
                coatStyles.add(CoatStyle.valueOf(styleString.toUpperCase()));
            } catch (IllegalArgumentException e) {
                // Handle invalid style strings if needed
                ClassDebug.error("Invalid coat style: " + styleString);
            }
        }
        return coatStyles;
    }

}
