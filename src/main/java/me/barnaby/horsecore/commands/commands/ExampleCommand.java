package me.barnaby.horsecore.commands.commands;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.commands.Command;
import me.barnaby.horsecore.commands.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(commandName = "test", usage = "/example", permissions = "not.implemented.yet")
public class ExampleCommand extends CommandExecutor {

    @Override
    public void executeAsPlayer(Player player, String[] args, HorseCore horseCore) {
        player.sendMessage("Example");
    }

    @Override
    public void executeAsConsole(CommandSender console, String[] args, HorseCore horseCore) {}

}
