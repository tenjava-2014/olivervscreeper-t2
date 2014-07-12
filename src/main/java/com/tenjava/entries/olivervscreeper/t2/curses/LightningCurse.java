package com.tenjava.entries.olivervscreeper.t2.curses;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class LightningCurse extends Curse{

    @Override
    public void performCurse(Player toCurse) {
        ChatUtils.sendMSG(toCurse, "You were cursed with lightning!");
        toCurse.getWorld().strikeLightning(toCurse.getLocation());
    }

    @Override
    public int getChance() {return 32;}

}
