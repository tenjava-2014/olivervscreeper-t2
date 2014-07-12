package com.tenjava.entries.olivervscreeper.t2;

import com.tenjava.entries.olivervscreeper.t2.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    public static Plugin plugin;

    public void onEnable(){
        this.getLogger().info("Ore-a Enabled! Performing setup..."); //Begin
        init();
    }

    public void init(){
        plugin = this; //Save plugin for other classes.
        Bukkit.getPluginManager()
                .registerEvents(new PlayerListener(),this); //Register listener
    }

}
