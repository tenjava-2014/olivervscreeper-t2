package com.tenjava.entries.olivervscreeper.t2.handlers;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import com.tenjava.entries.olivervscreeper.t2.utils.ConfigLoader;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class PlayerListener implements Listener{

    //Events for plugin mechanics

    @EventHandler //Event to award energy.
    public void onBreak(BlockBreakEvent e){
        //Return if block is not specified in configuration.
        if(!ConfigLoader.IDValue.containsKey(e.getBlock().getTypeId())) return;

        EnergyTracker.addEnergy(e.getPlayer(),
                ConfigLoader.IDValue.get(e.getBlock().getTypeId()));
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){

        Player p = e.getPlayer();

        //Check to see if item is enchanted stick.
        if(p.getItemInHand() == null) return;
        if(!p.getItemInHand().getType()
                .equals(Material.STICK)) return;
        if(!p.getItemInHand().getItemMeta().hasEnchants()) return;
        if(!e.getAction().equals(Action.RIGHT_CLICK_AIR) && !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        //Send player message with energy.
        ChatUtils.sendMSG(p, "Your Energy Level: " +
                EnergyTracker.getEnergy(e.getPlayer()));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){ 
        ChatUtils.sendMSG(e.getPlayer(),"Hey! Please see README.md for the mechanics and crafting recipes.");
    }

}
