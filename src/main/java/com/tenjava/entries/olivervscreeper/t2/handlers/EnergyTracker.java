package com.tenjava.entries.olivervscreeper.t2.handlers;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class EnergyTracker {

    public static void addEnergy(Player p, int energy){
        //TODO: Award player energy, remove below statement
       ChatUtils.sendMSG(p,"If implemented, you would receive " + energy + " points for that block.");
    }

}
