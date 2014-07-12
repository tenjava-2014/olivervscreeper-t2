package com.tenjava.entries.olivervscreeper.t2.powerups;

import com.tenjava.entries.olivervscreeper.t2.TenJava;
import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import org.bukkit.Bukkit;
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
public class FlyPowerup implements Listener{

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(!(e.getEntity().getType().equals(EntityType.PIG))) return;
        if(!(e.getDamager() instanceof Player)) return;
        if(!isHoldingTracker((Player) e.getDamager()));
        if(!(EnergyTracker.getEnergy((Player) e.getDamager()) >= 200)) return;

        final Player PLAYER = (Player) e.getDamager();

        EnergyTracker.usePoints(PLAYER,200);
        e.setCancelled(true);

        PLAYER.setAllowFlight(true);
        PLAYER.setFlying(true);
        playPowerupSound(PLAYER);

        Bukkit.getScheduler().scheduleSyncDelayedTask(TenJava.plugin,
                new Runnable() {
                    @Override
                    public void run() {
                        PLAYER.setFlying(false);
                        PLAYER.setAllowFlight(false);
                    }
                },200);

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
