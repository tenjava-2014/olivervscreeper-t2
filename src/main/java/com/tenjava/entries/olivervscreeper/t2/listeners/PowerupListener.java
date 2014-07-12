package com.tenjava.entries.olivervscreeper.t2.listeners;

import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class PowerupListener implements Listener{

    public boolean isHoldingTracker(Player p){
        if(p.getItemInHand() == null) return false;
        if(!p.getItemInHand().getType().equals(Material.STICK)) return false;
        if(!p.getItemInHand().getItemMeta().hasEnchants()) return false;
        return true;
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e){
        if(!e.isSneaking()) return;
        if(!isHoldingTracker(e.getPlayer())) return;
        if(!(EnergyTracker.getEnergy(e.getPlayer()) >= 25)) return;

        EnergyTracker.usePoints(e.getPlayer(),25);
        e.getPlayer().setVelocity(e.getPlayer().getVelocity().setY(4));
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) return;
        if(!(e.getDamager() instanceof Player)) return;
        if(!isHoldingTracker((Player) e.getDamager()));
        if(!(EnergyTracker.getEnergy((Player) e.getDamager()) >= 80)) return;

        EnergyTracker.usePoints((Player) e.getDamager(),80);
        e.getEntity().setFallDistance(500F);
    }

}
