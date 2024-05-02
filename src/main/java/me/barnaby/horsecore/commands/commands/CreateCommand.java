package me.barnaby.horsecore.commands.commands;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.commands.Command;
import me.barnaby.horsecore.commands.CommandExecutor;
import me.barnaby.horsecore.gui.Guis.BreedSelectorGui;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(commandName = "create", usage = "/eq create", permissions = "")
public class CreateCommand extends CommandExecutor {
    @Override
    public void executeAsPlayer(Player player, String[] args, HorseCore horseCore) {
        new BreedSelectorGui(horseCore).open(player);
    }

    @Override
    public void executeAsConsole(CommandSender console, String[] args, HorseCore horseCore) {}
}
