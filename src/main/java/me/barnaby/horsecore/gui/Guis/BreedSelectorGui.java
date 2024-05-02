package me.barnaby.horsecore.gui.Guis;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.gui.Gui;
import me.barnaby.horsecore.gui.GuiItem;
import me.barnaby.horsecore.horse.breed.Breed;
import me.barnaby.horsecore.horse.breed.BreedManager;
import me.barnaby.horsecore.utils.ItemBuilder;
import me.barnaby.horsecore.utils.ParticleUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class BreedSelectorGui extends Gui {
    public BreedSelectorGui(HorseCore horseCore) {
        super(54, "Select Breed");

        for (Breed breed : horseCore.getBreedManager().getBreeds()) {
            addItem(new GuiItem(new ItemBuilder(Material.PAPER)
                    .name(ChatColor.GOLD + "" + ChatColor.BOLD + breed.getName())
                    .addLore("&eCategory: &7" + breed.getCategory().getName())
                    .addLore("&eSize: &7" + breed.getSize().getName()).build(),
                    clickEvent -> {

                clickEvent.setCancelled(true);
                Player player = (Player) clickEvent.getWhoClicked();
                horseCore.getHorseManager().createHorseFromBreed(breed, player);
                player.closeInventory();
                player.sendMessage(ChatColor.GREEN + "Horse was created!");
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1,1);
            }));
        }

    }
}
