package me.barnaby.horsecore.listeners;

import me.barnaby.horsecore.gui.Gui;
import me.barnaby.horsecore.gui.GuiItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;

        /*if(event.getSlotType() == InventoryType.SlotType.ARMOR
                || event.getSlotType() == InventoryType.SlotType.CRAFTING
                || event.getSlotType() == InventoryType.SlotType.RESULT
        ) {
            event.setCancelled(true);
            return;
        }

         */

        if (event.getClickedInventory() == null) {
            return;
        }

        if(event.getInventory().getHolder() instanceof Gui gui) {
            if(event.getClickedInventory().getType() == InventoryType.PLAYER) {
                if(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || event.getClick().isShiftClick()) {
                    event.setCancelled(true);
                }
                return;
            }

           gui.onClick(event);

            GuiItem clickedItem = gui.getItemFromSlot(event.getSlot());
            if(clickedItem == null)
                return;
            clickedItem.onClick(event);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        if(event.getInventory().getHolder() instanceof Gui) {
            ((Gui) event.getInventory().getHolder()).onDrag(event);
        }
    }
}
