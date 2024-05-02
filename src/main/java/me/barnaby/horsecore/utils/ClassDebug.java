package me.barnaby.horsecore.utils;

import org.bukkit.Bukkit;

public class ClassDebug {

    public static void error(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement caller = stackTraceElements[2];
        String callerClassName = caller.getClassName();
        int callerLineNumber = caller.getLineNumber();
        Bukkit.getLogger().warning("Error from " + callerClassName + ":" + callerLineNumber + " - " + message);
    }

    public static void info(String message) {
        Bukkit.getLogger().info(message);
    }

}
