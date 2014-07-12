package com.tenjava.entries.olivervscreeper.t2.powerups;

import com.tenjava.entries.olivervscreeper.t2.handlers.CurseHandler;
import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class InstaKillPowerup implements Listener{

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity().getType().equals(EntityType.PIG)) return;
        if(e.getEntity() instanceof Player) return;
        if(!(e.getDamager() instanceof Player)) return;
        if(!isHoldingTracker((Player) e.getDamager())) return;
        if(!(EnergyTracker.getEnergy((Player) e.getDamager()) >= 80)) return;

        EnergyTracker.usePoints((Player) e.getDamager(),80);
        e.getEntity().setFallDistance(500F);
        playPowerupSound((Player) e.getDamager());
        CurseHandler.attemptCurse((Player) e.getDamager());
    }

    public boolean isHoldingTracker(Player p){
        if(p.getItemInHand() == null) return false;
        if(!p.getItemInHand().getType().equals(Material.STICK)) return false;
        if(!p.getItemInHand().getItemMeta().hasEnchants()) return false;
        return true;
    }

    public void playPowerupSound(Player p){
        p.playSound(p.getLocation(), Sound.WITHER_SHOOT,2F,2F);
    }

}
