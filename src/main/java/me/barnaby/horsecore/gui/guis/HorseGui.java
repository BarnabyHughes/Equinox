package me.barnaby.horsecore.gui.guis;

import me.barnaby.horsecore.Horse;
import me.barnaby.horsecore.gui.Gui;
import me.barnaby.horsecore.gui.GuiItem;
import me.barnaby.horsecore.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class HorseGui extends Gui {
    public HorseGui(Horse horse) {
        super(27, "Your Horse");
        setItem(new GuiItem(
                new ItemBuilder(Material.EMERALD_BLOCK)
                        .name("&a&lLevelling").addLore("&7Right-Click to open the rewards menu")
                        .build(), clickEvent -> {
                    new HorseLevelGui().open((Player) clickEvent.getWhoClicked());
        }
        ), 1, 2);
    }
}
