package com.tenjava.entries.olivervscreeper.t2.handlers;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class EnergyTracker {

    public static HashMap<String,Integer> energyLevels = new HashMap<String, Integer>();

    public static void addEnergy(Player p, int energy){
        saveNewEnergy(p,energy); //Award player energy
        playNotificationSound(p); //Alert player with sound
    }

    public static void saveNewEnergy(Player p, int energy){
        if(energyLevels.containsKey(p.getName())){
            Integer newEnergy = energyLevels.get(p.getName()) + energy;
            energyLevels.remove(p.getName());
            energyLevels.put(p.getName(),newEnergy);
        }else{
            energyLevels.put(p.getName(),energy);
        }
    }

    public static void playNotificationSound(Player p){
        p.playSound(p.getLocation(), Sound.CAT_MEOW,1,1);
    }

    public static int getEnergy(Player p){
        if(!energyLevels.containsKey(p.getName())) return 0;
        return energyLevels.get(p.getName());
    }

    public static void usePoints(Player p, int energy){
        Integer newEnergy = energyLevels.get(p.getName()) - energy;
        energyLevels.remove(p.getName());
        energyLevels.put(p.getName(),newEnergy);
        ChatUtils.sendMSG(p,"You just used " + energy + " energy!");
    }

}
