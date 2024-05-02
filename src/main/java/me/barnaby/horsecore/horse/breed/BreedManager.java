package me.barnaby.horsecore.horse.breed;

import lombok.Getter;
import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.config.ConfigManager;
import me.barnaby.horsecore.config.ConfigType;
import me.barnaby.horsecore.utils.ClassDebug;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class BreedManager {

    @Getter
    private final List<Breed> breeds = new ArrayList<>();
    private final HorseCore plugin;
    public BreedManager(HorseCore plugin) {
        this.plugin = plugin;
    }

    public void init() {
        ConfigurationSection section = plugin.getConfigManager().getConfig(ConfigType.BREEDS)
                .getConfigurationSection("categories");

        for (String key : section.getKeys(false)) {
            breeds.add(Breed.fromConfig(key,
                    plugin.getConfigManager().getConfig(ConfigType.BREEDS).getConfigurationSection("categories." + key)));
            ClassDebug.info("Loaded Breed: " + key);
        }
    }
}
