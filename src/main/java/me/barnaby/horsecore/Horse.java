package me.barnaby.horsecore;

import lombok.Getter;
import lombok.Setter;
import me.barnaby.horsecore.features.CrossTie;
import me.barnaby.horsecore.horse.HorseManager;
import me.barnaby.horsecore.utils.ClassDebug;
import me.barnaby.horsecore.utils.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Horse {

    private final HorseManager horseManager;
    private final UUID horseUUID;

    public Horse(UUID horseUUID, HorseManager horseManager) {
        this.horseUUID = horseUUID;
        this.horseManager = horseManager;
    }

    /**
     * Horse getter
     * @return the bukkit horse
     */
    public org.bukkit.entity.Horse bukkitHorse() {
        return (org.bukkit.entity.Horse) Bukkit.getEntity(horseUUID);
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

    @Getter
    @Setter
    private int crossTies;
    @Getter
    private final List<UUID> bats = new ArrayList<>();
    public void crossTie(Player player) {
        CrossTie.startCrossTie(this, player);
    }
}
