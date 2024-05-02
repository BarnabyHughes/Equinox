package me.barnaby.horsecore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ItemBuilder {
    private ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder data(byte data) {
        item.setDurability(data);
        return this;
    }

    public ItemBuilder type(Material material) {
        item.setType(material);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends ItemMeta> ItemBuilder meta(Consumer<T> metaConsumer) {
        ItemMeta meta = item.getItemMeta();
        try {
            metaConsumer.accept((T) meta);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder withMeta(ItemMeta meta) {
        if(!Bukkit.getItemFactory().isApplicable(meta, item.getType()))
            throw new IllegalArgumentException("Tried to set invalid ItemMeta for " + item.getType().name());

        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder unbreakable(boolean unbreakable) {
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        return withMeta(meta);
    }

    public ItemBuilder name(String name) {
        return meta(meta -> meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name)));
    }

    public ItemBuilder lore(String... lore) {
        return meta(meta -> meta.setLore(Arrays.asList(lore)));
    }

    public ItemBuilder lore(List<String> lore) {
        return meta(meta -> meta.setLore(lore));
    }

    public ItemBuilder addLore(String lore) {
        return meta(meta -> {
            List<String> lores = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
            lores.add(ChatColor.translateAlternateColorCodes('&', lore));
            meta.setLore(lores);
        });
    }

    public ItemBuilder addAttribute(Attribute attribute, int value) {
        return meta(meta -> {
            meta.addAttributeModifier(attribute,
                    new AttributeModifier(attribute.getTranslationKey(), value, AttributeModifier.Operation.ADD_NUMBER));
        });
    }

    public ItemBuilder damage(short damage) {
        item.setDurability(damage);
        return this;
    }

    /*public <T> ItemBuilder NBT(String key, T value) {
        item = NbtUtil.set(item, key, value);
        return this;
    }

    public ItemBuilder NBT(Set<Pair<String, Object>> nbtData) {
        for(Pair<String, Object> tag : nbtData)
            item = NbtUtil.set(item, tag.getKey(), tag.getValue());
        return this;
    }

    @SafeVarargs
    public final <T> ItemBuilder NBT(Pair<String, T>... nbtData) {
        item = NbtUtil.setNbt(item, nbtData);
        return this;
    }

     */

    public ItemBuilder flags(ItemFlag... flags) {
        return meta(meta -> meta.addItemFlags(flags));
    }

    public ItemBuilder unsafeEnchant(Enchantment enchant, int level) {
        item.addUnsafeEnchantment(enchant, level);
        return this;
    }

    public ItemBuilder potionEffect(PotionEffect effect) {
        if (item.getType() == Material.POTION) {

            PotionMeta meta = (PotionMeta) item.getItemMeta();
            meta.addCustomEffect(effect, true);
            meta.setMainEffect(PotionEffectType.FAST_DIGGING);
            item.setItemMeta(meta);
        }
        return this;
    }

    public ItemStack build() {
        return item;
    }
}
