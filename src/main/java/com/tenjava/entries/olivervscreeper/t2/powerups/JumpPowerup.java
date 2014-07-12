package com.tenjava.entries.olivervscreeper.t2.powerups;

import com.tenjava.entries.olivervscreeper.t2.handlers.EnergyTracker;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class JumpPowerup implements Listener{

    List<Player> launched = new ArrayList<Player>();

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
        launched.add(e.getPlayer());
        playPowerupSound(e.getPlayer());
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(launched.contains(p)) launched.remove(p); e.setCancelled(true);
    }

    public void playPowerupSound(Player p){
        p.playSound(p.getLocation(), Sound.WITHER_SHOOT,2F,2F);
    }

}
