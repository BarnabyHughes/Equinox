package me.barnaby.horsecore.horse.breed.breedoptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.barnaby.horsecore.utils.ClassDebug;
import org.bukkit.entity.Horse;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum CoatColor {

    GREY(Horse.Color.GRAY),
    CHESTNUT(Horse.Color.CHESTNUT),
    BLACK(Horse.Color.BLACK),
    BAY(Horse.Color.DARK_BROWN),
    WHITE(Horse.Color.WHITE),
    PALOMINO(Horse.Color.CREAMY),
    BUCKSKIN(Horse.Color.BROWN);

    @Getter
    private final Horse.Color color;

    public static List<CoatColor> fromStringList(List<String> colorStrings) {
        List<CoatColor> coatColors = new ArrayList<>();
        for (String colorString : colorStrings) {
            try {
                coatColors.add(CoatColor.valueOf(colorString.toUpperCase()));
            } catch (IllegalArgumentException e) {
                // Handle invalid color strings if needed
                ClassDebug.error("Invalid coat color: " + colorString);
            }
        }
        return coatColors;
    }

}
