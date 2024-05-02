package me.barnaby.horsecore.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Horse;

public class ParticleUtil {
    public static void outlineHorse(Horse horse) {
        Location loc = horse.getLocation();
        for (double t = 0; t < Math.PI * 2; t += Math.PI / 16) {
            double x = Math.cos(t);
            double z = Math.sin(t);
            loc.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc.getX() + x, loc.getY(), loc.getZ() + z, 1);
        }

    }
}
