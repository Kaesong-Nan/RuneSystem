package com.qiyue.Utils;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import com.qiyue.Main;

public class config {

	
	public static void create(){
		JavaPlugin instance = Main.instance;
		if (!instance.getDataFolder().exists()) {
			instance.getDataFolder().mkdir();
			instance.reloadConfig();
			   }
		    File file = Main.cfg;
			if (!file.exists())instance.saveDefaultConfig();
			instance.reloadConfig();
	}
	
	

}
