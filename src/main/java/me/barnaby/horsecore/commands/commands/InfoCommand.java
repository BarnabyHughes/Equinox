package me.barnaby.horsecore.commands.commands;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.commands.Command;
import me.barnaby.horsecore.commands.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(commandName = "info", usage = "/eq info", permissions = "")
public class InfoCommand extends CommandExecutor {
    @Override
    public void executeAsPlayer(Player player, String[] args, HorseCore horseCore) {

    }

    @Override
    public void executeAsConsole(CommandSender console, String[] args, HorseCore horseCore) {}
}
