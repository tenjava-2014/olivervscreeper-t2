package com.tenjava.entries.olivervscreeper.t2.curses;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class BlastCurse extends Curse{

    @Override
    public void performCurse(Player toCurse) {
        toCurse.getWorld().createExplosion(toCurse.getLocation(),4);
        ChatUtils.sendMSG(toCurse, "Your spell causes an explosion.");
    }

    @Override
    public int getChance() {
        return 88;
    }
}
