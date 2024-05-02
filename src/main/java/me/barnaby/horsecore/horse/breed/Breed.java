package me.barnaby.horsecore.horse.breed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.barnaby.horsecore.horse.breed.breedoptions.Category;
import me.barnaby.horsecore.horse.breed.breedoptions.CoatColor;
import me.barnaby.horsecore.horse.breed.breedoptions.CoatStyle;
import me.barnaby.horsecore.horse.breed.breedoptions.Size;
import me.barnaby.horsecore.illness.Ilnesses;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Breed {

    private final String name;
    private final Category category;

    private final Size size;

    private final int minHeight;
    private final int maxHeight;

    private final int minWeight;
    private final int maxWeight;

    private final List<CoatColor> coatColors;
    private final List<CoatStyle> coatStyles;

    private final int minAge;
    private final int maxAge;

    private final List<Ilnesses> ilnesses;

    public static Breed fromConfig(String breedName, ConfigurationSection configData) {
        Category category = Category.valueOf(configData.getString("category").toUpperCase());
        Size size = Size.valueOf(configData.getString("size").toUpperCase());
        int minHeight = configData.getInt("min-height");
        int maxHeight = configData.getInt("max-height");
        int minWeight = configData.getInt("min-weight");
        int maxWeight = configData.getInt("max-weight");
        List<String> coatColors = configData.getStringList("coat-colors");
        List<String> coatStyles = configData.getStringList("coat-styles");
        int minAge = configData.getInt("min-expected-age");
        int maxAge = configData.getInt("max-expected-age");
        List<String> illnesses = configData.getStringList("problems");
        return new Breed(breedName, category, size, minHeight, maxHeight, minWeight, maxWeight,
                CoatColor.fromStringList(coatColors), CoatStyle.fromStringList(coatStyles),
                minAge, maxAge,
                Ilnesses.fromStringList(illnesses));
    }


    public CoatColor getRandomCoatColor() {
        return coatColors.get(new Random().nextInt(coatColors.size()));
    }


}
