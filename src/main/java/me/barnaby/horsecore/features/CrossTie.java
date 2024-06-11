package me.barnaby.horsecore.features;

import me.barnaby.horsecore.Horse;
import me.barnaby.horsecore.HorseCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.*;

public class CrossTie {
    private static final Map<UUID, Horse> crossTying = new HashMap<>();
    public static void startCrossTie(Horse horse, Player player) {
        if (horse.getCrossTies() < 2) {
            crossTying.put(player.getUniqueId(), horse);
        }
        else {
            horse.bukkitHorse().getWorld().getNearbyEntities(horse.bukkitHorse().getLocation(), 10,10,10).forEach(entity -> {
                if (entity instanceof Bat bat && bat.getLeashHolder().getUniqueId() == horse.bukkitHorse().getUniqueId()) entity.remove();
            });
            horse.setCrossTies(0);
            horse.bukkitHorse().setAI(true);
        }
    }

    private static Bat crossTie(Location location) {
        return location.getWorld().spawn(location, Bat.class, bat -> {
            bat.setInvisible(true);
            bat.setAI(false);
            bat.setSilent(true);
            bat.setInvulnerable(true);
        });
    }

    public static void interactEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!crossTying.keySet().contains(player.getUniqueId())) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType().name().contains("FENCE")) {
                Bat bat = crossTie(block.getLocation().add(0.5,0.5,0.5));
                Horse horse = crossTying.get(player.getUniqueId());
                horse.bukkitHorse().setAI(false);
                horse.setCrossTies(horse.getCrossTies()+1);

                bat.setLeashHolder(horse.bukkitHorse());
                crossTying.remove(player.getUniqueId());
                player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1,1);

            }
        }
    }
}
