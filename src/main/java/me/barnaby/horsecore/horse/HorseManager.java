package me.barnaby.horsecore.horse;

import lombok.Getter;
import me.barnaby.horsecore.Horse;
import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.horse.breed.Breed;
import me.barnaby.horsecore.utils.ParticleUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class HorseManager {

    private final HorseCore horseCore;

    @Getter
    private final Map<UUID, Horse> claimedHorses = new HashMap<>();

    public HorseManager(HorseCore horseCore) {
        this.horseCore = horseCore;
    }

    public void addClaimedHorse(UUID horse) {
        claimedHorses.put(horse, new Horse(horse, this));
    }

    public void createHorseFromBreed(Breed breed, Player player) {
        org.bukkit.entity.Horse horse = player.getWorld().spawn(player.getLocation(), org.bukkit.entity.Horse.class, horseEntity -> {
           horseEntity.setCustomName(ChatColor.LIGHT_PURPLE + player.getName() + "'s " + breed.getName());
           horseEntity.setCustomNameVisible(true);

           horseEntity.setColor(breed.getRandomCoatColor().getColor());
           horseEntity.setStyle(org.bukkit.entity.Horse.Style.values()[new Random().nextInt(org.bukkit.entity.Horse.Style.values().length)]);
           horseEntity.getInventory().setSaddle(new ItemStack(Material.SADDLE));


           ParticleUtil.outlineHorse(horseEntity);
           //horseEntity.setStyle()
        });
    }
}
