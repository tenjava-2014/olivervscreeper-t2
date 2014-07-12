package com.tenjava.entries.olivervscreeper.t2.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class ChatUtils {

    public final static String PREFIX = ChatColor.GRAY + "[" + ChatColor.GREEN + "Ore-A" + ChatColor.GRAY + "] " + ChatColor.WHITE;

    public static void sendMSG(Player p, String msg){
        p.sendMessage(PREFIX + msg); //Send message with prefix
        p.playSound(p.getLocation(), Sound.ORB_PICKUP,10,10); //Play alert sound
    }

    public static void broadcastMSG(String msg){
        for(Player p : Bukkit.getOnlinePlayers()){
            sendMSG(p,msg);
        }
    }

}
