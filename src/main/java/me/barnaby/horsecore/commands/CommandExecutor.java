package me.barnaby.horsecore.commands;

import me.barnaby.horsecore.HorseCore;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class CommandExecutor {

    public abstract void executeAsPlayer(Player player, String[] args, HorseCore horseCore);

    public abstract void executeAsConsole(CommandSender console, String[] args, HorseCore horseCore);
}
