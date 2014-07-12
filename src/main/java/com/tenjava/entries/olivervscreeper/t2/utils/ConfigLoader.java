package com.tenjava.entries.olivervscreeper.t2.utils;

import com.tenjava.entries.olivervscreeper.t2.TenJava;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class ConfigLoader {

    public static HashMap<Integer,Integer> IDValue = new HashMap<Integer, Integer>();
    public static boolean decreaseLimited;

    public static void loadConfig(final FileConfiguration CONFIGFILE){

        TenJava.plugin.saveDefaultConfig(); //Save config from jar template.

        //Load block values.
        for(String blocks : CONFIGFILE.getStringList("energyValues")){
            try {
                String[] value = blocks.split(":");
                IDValue.put(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            }catch(Exception ex){
                TenJava.plugin.getLogger().info("Could not load block '" + blocks + "'. - Skipping...");
                continue;
            }
        }

        decreaseLimited = CONFIGFILE.getBoolean("decreaseLimit");
        TenJava.plugin.getLogger().info("Preventing energy below 0: " + decreaseLimited);

    }

}
