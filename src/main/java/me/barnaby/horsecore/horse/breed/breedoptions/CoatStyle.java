package me.barnaby.horsecore.horse.breed.breedoptions;

import lombok.AllArgsConstructor;
import me.barnaby.horsecore.utils.ClassDebug;
import org.bukkit.entity.Horse;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum CoatStyle {

    NONE(Horse.Style.NONE),
    SNIP(Horse.Style.WHITE),
    PAINT(Horse.Style.WHITEFIELD),
    HEART(Horse.Style.WHITE_DOTS),
    BLAZE(Horse.Style.BLACK_DOTS);

    private Horse.Style style;

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
