package com.tenjava.entries.olivervscreeper.t2.curses;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class BatCurse extends Curse{

    @Override
    public void performCurse(Player toCurse) {
        ChatUtils.sendMSG(toCurse, "Hogwarts orders you are sent away.");
        Entity e = toCurse.getWorld().spawnEntity(toCurse.getLocation(), EntityType.BAT);
        e.setPassenger(toCurse);
    }

    @Override
    public int getChance() {return 24;}
}
