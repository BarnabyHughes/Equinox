package me.barnaby.horsecore.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;
import java.util.Map;

public class Gui implements InventoryHolder {
    private final Inventory inventory;
    private final Map<Integer, GuiItem> guiItems = new HashMap<>();

    /**
     * Creates the custom GUI
     *
     * @param size for size of inventory
     * @param name for name at top of inventory
     */
    public Gui(int size, String name) {
        inventory = Bukkit.createInventory(this, size, ChatColor.translateAlternateColorCodes('&', name));
    }

    /**
     *
     * @param guiItem for the item to add
     * @param rowsFromTop rows from top
     * @param columnsFromLeft columns from left
     */

    public void setItem(GuiItem guiItem, int rowsFromTop, int columnsFromLeft) {
        int index = (rowsFromTop * 9) + columnsFromLeft;
        inventory.setItem(index, guiItem.item());
        guiItems.put(index, guiItem);
    }

    public void addItem(GuiItem guiItem) {
        int firstEmpty = inventory.firstEmpty();
        inventory.setItem(firstEmpty, guiItem.item());
        guiItems.put(firstEmpty, guiItem);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public void onClick(InventoryClickEvent event) {}
    public void onDrag(InventoryDragEvent event) {}


    @Override
    public Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @param slot to get GuiItem
     * @return item if found
     */
    public GuiItem getItemFromSlot(int slot) {
        return guiItems.get(slot);
    }
}
