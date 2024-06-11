package me.barnaby.horsecore.gui.guis;

import me.barnaby.horsecore.gui.Gui;
import me.barnaby.horsecore.gui.GuiItem;
import me.barnaby.horsecore.levelling.Reward;
import me.barnaby.horsecore.levelling.levels.HorseLevel;
import me.barnaby.horsecore.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Collections;

public class HorseLevelGui extends Gui {

    public HorseLevelGui() {
        super(27, "Level Up");
        for (int i = 0; i<9; i++) {
            setItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                    .name("").build(), clickEvent -> {
                clickEvent.setCancelled(true);
            }), 0,i);
            setItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                    .name("").build(), clickEvent -> {
                clickEvent.setCancelled(true);
            }), 2,i);
        }

        for (int i = 0; i<9; i++) {
            HorseLevel horseLevel = new HorseLevel("Level " + (i+1), "An example level",
                    i * 1000, Collections.singletonList(new Reward("+" + i + " Diamond")));
            setItem(new GuiItem(new ItemBuilder(Material.RED_STAINED_GLASS)
                    .name(ChatColor.RED + "" + ChatColor.BOLD + horseLevel.getLevelName())
                    .addLore("&8&m                      ")
                    .addLore("&cRequirements: ")
                    .addLore("&8- &7" + horseLevel.getXpRequirements() + " xp")
                    .addLore("&8&m                      ")
                    .addLore("&cRewards: ")
                    .addLore("&8- &7" + horseLevel.getRewards().get(0).getName())
                    .addLore("&8&m                      ").build(),
                    clickEvent -> {
                clickEvent.setCancelled(true);
                    }), 1, i);
        }
    }

}
