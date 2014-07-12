package com.tenjava.entries.olivervscreeper.t2.curses;

import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public abstract class Curse {

    public abstract int getChance();

    public abstract void performCurse(Player toCurse);

}
