package me.barnaby.horsecore.config;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.horse.breed.BreedManager;
import me.barnaby.horsecore.utils.ClassDebug;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private final HorseCore plugin;
    private final Map<ConfigType, YamlConfiguration> configs = new HashMap<>();

    public ConfigManager(HorseCore plugin) {
        this.plugin = plugin;
    }

    public void loadConfigs() {
        // Create the plugin data folder if it doesn't exist
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        for (ConfigType config : ConfigType.values()) {
            config.setFile(new File(plugin.getDataFolder(), config.getConfigPath()));
            configs.put(config, YamlConfiguration.loadConfiguration(config.getFile()));
            if (!config.getFile().exists()) copyDefaultConfig(config);
        }
    }

    public FileConfiguration getConfig(ConfigType configType) {
        return configs.get(configType);
    }

    public void saveConfig(ConfigType configType) {
        try {
            configs.get(configType).save(configType.getFile());
        } catch (IOException e) {
            ClassDebug.error("IOException - Config is saving incorrectly!");
        }
    }

    private void copyDefaultConfig(ConfigType configType) {
        try (InputStream inputStream = plugin.getResource(configType.getConfigPath())) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + configType.getConfigPath());
            }

            Files.copy(inputStream, configType.getFile().toPath());
        } catch (IOException e) {
            ClassDebug.error("IOException - Config is copying incorrectly!");
        }
    }

}
