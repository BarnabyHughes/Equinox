package me.barnaby.horsecore.commands;

import me.barnaby.horsecore.HorseCore;
import me.barnaby.horsecore.commands.commands.CreateCommand;
import me.barnaby.horsecore.commands.commands.ExampleCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements org.bukkit.command.CommandExecutor {

    private final HorseCore horseCore;
    public CommandHandler(HorseCore horseCore) {
        this.horseCore = horseCore;

        registerCommand(new ExampleCommand());
        registerCommand(new CreateCommand());

    }
    private final Map<String, CommandExecutor> commands = new HashMap<>();


    /**
     * Registers a command
     * @param command The command class
     */
    public void registerCommand(CommandExecutor command) {
        Class<? extends CommandExecutor> clazz = command.getClass();
        if (clazz.isAnnotationPresent(Command.class)) {
            Command annotation = clazz.getAnnotation(Command.class);
            String commandName = annotation.commandName();
            commands.put(commandName, command);
            Bukkit.getLogger().info("Loaded command: " + commandName);
        } else {
            Bukkit.getLogger().warning(clazz.getName() + " has not got the ElvernCommand annotation! Skipping.. (developer issue)");
            // Handle error: Class doesn't have ElvernCommand annotation
        }
    }


    /**
     * Handles the command
     */
    public void handleCommand(CommandSender sender, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("eq")) {
            if (args.length > 0) {
                CommandExecutor executor = commands.get(args[0]);
                if (executor != null) {
                    if (sender instanceof Player) {
                        executor.executeAsPlayer((Player) sender, Arrays.copyOfRange(args, 1, args.length), horseCore);
                    } else {
                        executor.executeAsConsole( sender, Arrays.copyOfRange(args, 1, args.length), horseCore);
                        // Handle error: Only players can execute commands
                    }
                } else {
                    sender.sendMessage("Unknown Subcommand: " + args[0]);
                    // Handle error: Unknown subcommand
                }
            } else {
                // Handle error: Missing subcommand
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        handleCommand(commandSender, s, strings);
        return false;
    }
}
