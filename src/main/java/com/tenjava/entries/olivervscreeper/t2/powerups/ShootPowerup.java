package com.tenjava.entries.olivervscreeper.t2.powerups;

import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class ShootPowerup implements Listener{

    @EventHandler
    public void onDamage(PlayerInteractEvent e){
        if(!isHoldingTracker(e.getPlayer())) return;
        if(!e.getAction().equals(Action.LEFT_CLICK_AIR)) return;
        if(!(EnergyTracker.getEnergy(e.getPlayer()) >= 5)) return;
        e.getPlayer().shootArrow();
        EnergyTracker.usePoints(e.getPlayer(), 5);
    }

    public boolean isHoldingTracker(Player p){
        if(p.getItemInHand() == null) return false;
        if(!p.getItemInHand().getType().equals(Material.STICK)) return false;
        if(!p.getItemInHand().getItemMeta().hasEnchants()) return false;
        return true;
    }

}
