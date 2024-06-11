package me.barnaby.horsecore.listeners;

import me.barnaby.horsecore.features.CrossTie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void playerInteractListener(PlayerInteractEvent event) {
        CrossTie.interactEvent(event);
    }


}
