package com.tenjava.entries.olivervscreeper.t2;

import com.tenjava.entries.olivervscreeper.t2.handlers.CurseHandler;
import com.tenjava.entries.olivervscreeper.t2.handlers.PlayerListener;
import com.tenjava.entries.olivervscreeper.t2.powerups.FlyPowerup;
import com.tenjava.entries.olivervscreeper.t2.powerups.InstaKillPowerup;
import com.tenjava.entries.olivervscreeper.t2.powerups.JumpPowerup;
import com.tenjava.entries.olivervscreeper.t2.powerups.ShootPowerup;
import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import com.tenjava.entries.olivervscreeper.t2.utils.ConfigLoader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    public static Plugin plugin;

    public void onEnable(){
        this.getLogger().info("Ore-a Enabled! Performing setup..."); //Begin
        init();
    }

    public void init(){

        //Basic setup
        plugin = this; //Save plugin for other classes.
        Bukkit.getPluginManager()
                .registerEvents(new PlayerListener(),this); //Register listener
        registerPowerups();

        //Load config
        ConfigLoader.loadConfig(getConfig());

        addStickRecipe(); //Add recipe for energy checker.

        CurseHandler.loadCurses(); //Load curses

        //Finished, alert players if reload
        ChatUtils.broadcastMSG("Plugin Reloaded.");
    }

    public void addStickRecipe(){
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta im = stick.getItemMeta();
        im.addEnchant(Enchantment.LUCK,1,false);
        im.setDisplayName(ChatColor.GREEN + "Energy Detector");
        stick.setItemMeta(im); //Add enchantment and display name.

        ShapelessRecipe Sr = new ShapelessRecipe(stick); //Recipe with result
        Sr.addIngredient(Material.STICK); //Add ingredients
        Sr.addIngredient(Material.APPLE);
        Bukkit.addRecipe(Sr); //Add recipe
    }

    public void registerPowerups(){
        registerPowerup(new InstaKillPowerup());
        registerPowerup(new JumpPowerup());
        registerPowerup(new ShootPowerup());
        registerPowerup(new FlyPowerup());
    }

    public void registerPowerup(Object classObject){
        Bukkit.getPluginManager().registerEvents((Listener) classObject,this);
    }

}
