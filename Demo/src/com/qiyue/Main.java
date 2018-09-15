package com.qiyue;

import java.io.File;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.qiyue.Command.RuneCommand;
import com.qiyue.Listener.PlayerDamger;
import com.qiyue.Listener.PlayerFirstJoin;
import com.qiyue.Listener.PlayerRuneMain;
import com.qiyue.Utils.config;
import com.qiyue.Utils.playerdata;
@SuppressWarnings("all")

public class Main extends JavaPlugin{

	public static JavaPlugin instance;
	public static File cfg;
	public static File player;
	public static FileConfiguration data;
	public static Economy economy = null;

	public void onEnable(){
		
	instance = this;
	
	cfg = new File(instance.getDataFolder(), "config.yml");
	
	player = new File(instance.getDataFolder(), "playerdata.yml");
	
	config.create();
	
	playerdata.create();

	data = playerdata.getDataFile();
	
	getCommand("rune").setExecutor(new RuneCommand());
	
	getServer().getPluginManager().registerEvents(new PlayerFirstJoin(), this);
	
	getServer().getPluginManager().registerEvents(new PlayerRuneMain(), this);
	
	getServer().getPluginManager().registerEvents(new PlayerDamger(), this);
	
	
    RegisteredServiceProvider economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if ((economyProvider != null) && 
      ((this.economy = (Economy)economyProvider.getProvider()) == null));
	
	Bukkit.getConsoleSender().sendMessage("[RuneSystem]——————————————————————");
	
	if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI") ) {	
		
	Bukkit.getConsoleSender().sendMessage("[RuneSystem] §cPlaceholderAPI插件未加载. 变量失效!");
	
    }else{	
    	
    new Placeholder(this).hook();
    
    Bukkit.getConsoleSender().sendMessage("[RuneSystem] §aPlaceholderAPI 变量已加载");	
    
    }
	
	Bukkit.getConsoleSender().sendMessage("[RuneSystem]——————————————————————");
	
	
	
	}
	
	
}
