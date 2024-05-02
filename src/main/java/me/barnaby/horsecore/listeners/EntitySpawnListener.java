package me.barnaby.horsecore.listeners;

import me.barnaby.horsecore.HorseCore;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {

    private final HorseCore horseCore;
    public EntitySpawnListener(HorseCore horseCore) {
        this.horseCore = horseCore;
    }

    @EventHandler
    public void entitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Horse horse) {
            //horseCore.getHorseManager().addWildHorse(horse.getUniqueId());
        }
    }


}
