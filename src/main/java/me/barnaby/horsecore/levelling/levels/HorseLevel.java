package me.barnaby.horsecore.levelling.levels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.barnaby.horsecore.levelling.Reward;
import org.bukkit.entity.Horse;

import java.util.List;

@AllArgsConstructor
@Getter
public class HorseLevel {

    private String levelName;
    private String description;
    private int xpRequirements;
    private List<Reward> rewards;


}
