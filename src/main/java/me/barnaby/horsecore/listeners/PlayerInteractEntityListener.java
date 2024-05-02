package me.barnaby.horsecore.listeners;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.gui.Guis.HorseGui;
import me.barnaby.horsecore.utils.ParticleUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    private final HorseCore horseCore;
    public PlayerInteractEntityListener(HorseCore horseCore) {
        this.horseCore = horseCore;
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Horse horse) {
            System.out.println("test");
            event.setCancelled(true);
            if (!horseCore.getHorseManager().getClaimedHorses().keySet().contains(horse.getUniqueId())) {
                ParticleUtil.outlineHorse(horse);
                Player player = event.getPlayer();
                player.sendMessage(ChatColor.GREEN + "You claimed a horse!");
                horseCore.getHorseManager().addClaimedHorse(horse.getUniqueId());
                horse.setCustomNameVisible(true);
                horse.setCustomName(ChatColor.LIGHT_PURPLE + player.getName() + "'s Horse");
            }
            else {
                me.barnaby.horsecore.Horse claimedHorse = horseCore.getHorseManager().getClaimedHorses().get(horse.getUniqueId());
                new HorseGui(claimedHorse).open(event.getPlayer());
            }
        }
    }
}
