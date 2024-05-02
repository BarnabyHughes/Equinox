package me.barnaby.horsecore;

import lombok.Getter;
import me.barnaby.horsecore.commands.CommandHandler;
import me.barnaby.horsecore.config.ConfigManager;
import me.barnaby.horsecore.horse.HorseManager;
import me.barnaby.horsecore.horse.breed.BreedManager;
import me.barnaby.horsecore.listeners.EntitySpawnListener;
import me.barnaby.horsecore.listeners.InventoryClickListener;
import me.barnaby.horsecore.listeners.PlayerInteractEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class HorseCore extends JavaPlugin {

    @Getter
    private final HorseManager horseManager = new HorseManager(this);

    @Getter
    private final ConfigManager configManager = new ConfigManager(this);

    @Getter
    private final BreedManager breedManager = new BreedManager(this);

    @Override
    public void onEnable() {
        sendEnableMessage(Bukkit.getLogger());

        registerCommands();
        registerListeners();

        configManager.loadConfigs();
        breedManager.init();
    }

    private void sendEnableMessage(Logger logger) {
        logger.info(ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "------------------------------------------");
        logger.info("");
        logger.info(ChatColor.GREEN + "" + ChatColor.BOLD + "Horse Core");
        logger.info(ChatColor.DARK_GREEN + "Developed by Barnaby");
        logger.info("");
        logger.info(ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + "------------------------------------------");
    }



    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new EntitySpawnListener(this), this);
        pm.registerEvents(new PlayerInteractEntityListener(this), this);
    }

    private void registerCommands() {
        getCommand("eq").setExecutor(new CommandHandler(this));

    }
    /*
    <:arrow1:1190774923816341514> [ **To Be Done** ]
Grooming
Adding gaits to lunging
Horse Drinking
Horses Grazing
Different Horse Feeds/Hay/Treats
Soaking Hay
Horse Leveling
Player Leveling
Player Info
Horse Illness & Injuries
Horse Vaccines
Horse Breeding
Horse In-Heat
Horse Trusting
Horse lease/loan ( Money + time )
Horse private or public
Horse poop + Pee
Doing things with horses will give horse or player xp ( undecided )
Horse gaits
horse weights
horse aging
stallions can be gelded
Tags : Horses-live-forever( Limited per rank )
Clubs/Associations
Zombie + Skeleton + Mule + Donkey in the plugin
Horse ID
Jobs
Tokens: Free Plots, Free Horse,
Vet, Farrier, Chiro, Dentist,
Pregnancy
Weaning off Mum ( Foal )
Mum can miscarridge
Mum can refuse foal ( must be raised by person or maybe another horse )
Fertility
Black Market: Fertilitly Booster, Miracle Cure Illness/Injury, Rideable cure, Vision/Hearing cure, Age up or down, Perfect Weight, Discipline reset, Temp in heat, Instant pregnancy, immortal
Cross Tie
Horse Registration
Equine Profile Discord Bot
Achievments + Challenge's
Quests
Warm up: Horses must be lunged, walked and warmed up or can cause problems!
Set horses home, pasture etc )
Horse tp
Advertise in-game: jobs, horses, plots etc like discord
Weather bot or plugin
Twin foals
Training under saddle
Leaving saddle on can cause saddle sore
having saddle for specific breeds/sizes ( tack wont work or can cause problems if wrong size )
making horses unrideable if they have an illness or injury
retiring horses
Cap Leveling up horses jump and speed? If we choose to add that
Staminia ( Staminia goes up as you level up your horse )
Creative Control ( Players can ask for creative via a command staff  can accept this, and also works via discord )
Block Control ( Can control what players get via creative menu )
Lineage
Horses cannot take any damage or be killed unless via a command
Registration system to discord
     */
}