package me.barnaby.horsecore;

import me.barnaby.horsecore.horse.HorseManager;
import me.barnaby.horsecore.utils.ClassDebug;
import me.barnaby.horsecore.utils.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Horse {

    private final HorseManager horseManager;
    private final UUID horseUUID;


    public Horse(UUID horseUUID, HorseManager horseManager) {
        this.horseUUID = horseUUID;
        this.horseManager = horseManager;
    }

    /**
     * Sets a horses armor
     * @param material the horse armor material
     */

    public void setArmor(Material material) {
        if (!material.name().contains("HORSE_ARMOR")) {
            ClassDebug.error("Armor has not been set to a horse armor material!");
            return;
        }
        if (Bukkit.getEntity(horseUUID) instanceof org.bukkit.entity.Horse horse) {
            horse.getInventory().setArmor(new ItemStack(material));
            ParticleUtil.outlineHorse(horse);
        }
        else ClassDebug.error("UUID stored is not a horse");
    }
}
