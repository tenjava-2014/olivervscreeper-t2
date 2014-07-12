package com.tenjava.entries.olivervscreeper.t2.listeners;

import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import com.tenjava.entries.olivervscreeper.t2.utils.ConfigLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class PlayerListener implements Listener{

    @EventHandler //Event to award energy.
    public void onBreak(BlockBreakEvent e){
        //Return if block is not specified in configuration.
        if(!ConfigLoader.IDValue.containsKey(e.getBlock().getTypeId())) return;

        EnergyTracker.addEnergy(e.getPlayer(),ConfigLoader.IDValue.get(e.getBlock().getTypeId()));
    }

}
