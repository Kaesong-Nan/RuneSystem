package com.qiyue.rune;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.qiyue.Main;
@SuppressWarnings("all")
public class RuneSystem {

	
	/**
	 * 获取API
	 */
	public static RuneSystem getInstance(){
		return new RuneSystem();
	}
	

	/**
	 * 获取指定页面的符文GUI
	 */
	  public Inventory getRuneGui(Player p,String Page)
	  {
		  
	    Inventory RuneGui = Bukkit.createInventory(null, 45,Main.data.getString(p.getName()+".RunePage."+Page+".disyname"));
		FileConfiguration data = Main.data;
		    for(int i = 0 ; i < 9 ; i++){
		    	RuneGui.setItem(i, getItem1());
		    	RuneGui.setItem(i+36, getItem2());
		    }
		String[] rune = Main.data.getString(p.getName()+".RunePage."+Page+".ItemStack").split(",");
		int i = 9;
		for(String node : rune){
		if(!node.equals("air"))
		RuneGui.setItem(i, getRune(node));
		i++;
		}
		    
		    
		    
		  
		  return RuneGui;
		  
	  }
	
	 /**
	  * 获取主页面
	  */
	  public Inventory getMenu(Player p)
	  {
	    Inventory RuneGui = Bukkit.createInventory(null, 45, p.getName() + "§a§l的符文页");
	    FileConfiguration data = Main.data;
	    for(int i = 0 ; i < 9 ; i++){
	    	RuneGui.setItem(i, getItem1());
	    	RuneGui.setItem(i+36, getItem2());
	    }
	    for(String node : data.getConfigurationSection(p.getName()+".RunePage").getKeys(false)){
	    	if(data.getBoolean(p.getName()+".RunePage."+node+".enable")){
	    	RuneGui.setItem(Integer.parseInt(node), getItem3(p,node));
	    	}else{
		    RuneGui.setItem(Integer.parseInt(node), getItem4(p,node));	
	    	}
	    }
	    
	    
	    
	    return RuneGui;
	  }

        /**
         * 获取指定符文页的所有属性
         */
	  
	    public List<String> getRuneAttribute(Player p,int node){
	    	
	    	String[] rune = Main.data.getString(p.getName()+".RunePage."+node+".ItemStack").split(",");
	    	
	  	    double hp1 = 0.0;
		    double hp2 = 0.0;
		    double hp3 = 0.0;
		    int hp4 = 0;
		    double hp5 = 0.0;
		    int hp6 = 0;
		    double hp7 = 0.0;
		    double hp8 = 0.0;
		    double hp9 = 0.0;
		    double hp10 = 0.0;
		    double hp11 = 0.0;
		    double hp12 = 0.0;
		    double hp13 = 0.0;
	   
	    	for(String n : rune){
	    		if(!n.equals("air")){
	    		List<String> list = Main.instance.getConfig().getStringList("RuneItem."+n+".Attribute");
	    		for(String Att : list){
	    			if(Att.split(":")[0].equals("hp1")){
	    				hp1 = hp1 + Double.parseDouble(Att.split(":")[1]);
	    			}
	    			if(Att.split(":")[0].equals("hp2")){
	    				hp2 = hp2 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp3")){
	    				hp3 = hp3 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp4")){
	    				hp4 = hp4 + Integer.parseInt(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp5")){
	    				hp5 = hp5 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp6")){
	    				hp6 = hp6 + Integer.parseInt(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp7")){
	    				hp7 = hp7 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp8")){
	    				hp8 = hp8 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp9")){
	    				hp9 = hp9 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp10")){
	    				hp10 = hp10 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp11")){
	    				hp11 = hp11 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp12")){
	    				hp12 = hp12 + Double.parseDouble(Att.split(":")[1]);
	    			}
	      			if(Att.split(":")[0].equals("hp13")){
	    				hp13 = hp13 + Double.parseDouble(Att.split(":")[1]);
	    			}
	    		}
	    			
	    		
	    			
	    		}
	    	}
	    	
	    
	    	
	    List<String> list = new ArrayList<>();
	    list.add("hp1:"+hp1+"");
	    list.add("hp2:"+gets(hp2)+"");
	    list.add("hp3:"+gets(hp3)+"");
	    list.add("hp4:"+hp4+"");
	    list.add("hp5:"+gets(hp5)+"");
	    list.add("hp6:"+hp6+"");
	    list.add("hp7:"+gets(hp7)+"");
	    list.add("hp8:"+gets(hp8)+"");
	    list.add("hp9:"+gets(hp9)+"");
	    list.add("hp10:"+gets(hp10)+"");
	    list.add("hp11:"+gets(hp11)+"");
	    list.add("hp12:"+gets(hp12)+"");
	    list.add("hp13:"+gets(hp13)+"");
	    
	    
	    return list;
	    }
	  
	  
	    /**
	     * 这个不需要管,用来获取装饰物品的
	     */
	    
		public ItemStack getItem4(Player p,String page){
			 FileConfiguration config = Main.instance.getConfig();
			 ItemStack item = get(config.getString("Gui.ID4"));
			 ItemMeta im = item.getItemMeta();
			 im.setDisplayName(Main.data.getString(p.getName()+".RunePage."+page+".disyname"));
			 List<String> lore = config.getStringList("Gui.ID4Lore");
			 for(int i = 0 ; i < lore.size() ; i++){
				 lore.set(i, lore.get(i).replace("&", "§").replace("{money}", Main.instance.getConfig().getString("PayMoney")));
			 }
			 im.setLore(lore);
			 item.setItemMeta(im);
			 return item;
		 }
		
		
		
	public double gets(double d){
		if(d > 100){
			return 100;
		}
		    return d;
	}
		
	
	 /**
     * 这个不需要管,用来获取装饰物品的
     */
	public ItemStack getItem3(Player p,String page){
		 FileConfiguration config = Main.instance.getConfig();
		 ItemStack item = get(config.getString("Gui.ID3"));
		 ItemMeta im = item.getItemMeta();
		 im.setDisplayName(Main.data.getString(p.getName()+".RunePage."+page+".disyname"));
		 List<String> lore = config.getStringList("Gui.ID3Lore");
		 List<String> AttLore = this.getRuneAttribute(p, Integer.parseInt(page));
		 List<String> AttLores = new ArrayList<>();
		 List<String> lores = new ArrayList<>();
		 for(int i = 0 ; i < lore.size(); i++){
			if(lore.get(i).equals("{Rune_Attribute}")){
			   boolean b = false;
			  for(String node : AttLore){
			  if(Main.instance.getConfig().getBoolean("Vau.enable")){
				  
				  if(!node.split(":")[1].equals("0") && !node.split(":")[1].equals("0.0"))
				  {
					 lores.add(Main.instance.getConfig().getString("Vau.lore."+node.split(":")[0]).replace("&", "§").replace("{b}",node.split(":")[1]));	 
					 b = true;
				  }
				 }else{
					lores.add(Main.instance.getConfig().getString("Vau.lore."+node.split(":")[0]).replace("&", "§").replace("{b}",node.split(":")[1]));
					b = true;
				 }
			  }
			
			  if(!b){
				  lores.add(Main.instance.getConfig().getString("NoAttribute").replace("&","§"));
			  }
			  
			 continue;
			}
		 lores.add(lore.get(i).replace("&", "§").replace("{level}", this.getlevel(p,page)+""));
		 }
		 im.setLore(lores);
		 item.setItemMeta(im);
		 return item;
	}
	
	 /**
     * 这个不需要管
     */
	public ItemStack get(String s){
		 if(s.contains(":")){
			 return new ItemStack(Integer.parseInt(s.split(":")[0]),1,Short.valueOf(s.split(":")[1]));
		 }else{
			 return new ItemStack(Integer.parseInt(s),1);
		 }
	 }
	
	 /**
     * 获取玩家正在使用的符文页名称
     */
	public String getUseRune(Player p){
		
		for(String node : Main.data.getConfigurationSection(p.getName()+".RunePage").getKeys(false)){
			
			if(Main.data.getBoolean(p.getName() + ".RunePage."+node+".use")){
				return node;
			}
			
			
		}
		
		return null;
	}
	
	 /**
     * 获取玩家的指定符文页的等级
     */
	public int getlevel(Player p,String node){
	
	String[] rune = Main.data.getString(p.getName()+".RunePage."+node+".ItemStack").split(",");
	
	int level = 0;
	
	for(String n : rune){
		if(!n.equals("air")){
		level = level + Main.instance.getConfig().getInt("RuneItem."+n+".Level");
		}
	}

	return level;
	}
	
	 /**
     * 这个不需要管,用来获取装饰物品的
     */
	 public ItemStack getItem1(){
		 FileConfiguration config = Main.instance.getConfig();
		 ItemStack item = get(config.getString("Gui.ID1"));
		 ItemMeta im = item.getItemMeta();
		 im.setDisplayName(" ");
		 item.setItemMeta(im);
		 return item;
	 }
	 /**
	     * 这个不需要管,用来获取装饰物品的
	     */
	 public ItemStack getItem2(){
		 FileConfiguration config = Main.instance.getConfig();
		 ItemStack item = get(config.getString("Gui.ID2"));
		 ItemMeta im = item.getItemMeta();
		 im.setDisplayName(" ");
		 item.setItemMeta(im);
		 return item;
	 }
	
	 
	 /**
	     * 获取符文物品
	     */
	 public ItemStack getRune(String node){
		 FileConfiguration config = Main.instance.getConfig();
		 ItemStack item = get(config.getString("RuneItem."+node+".Id"));
		 ItemMeta im = item.getItemMeta();
		 im.setDisplayName(config.getString("RuneLogo") + config.getString("RuneItem."+node+".Name").replace("&","§"));
		 List<String> lore = config.getStringList("RuneItem."+node+".Lore");
		 for(int i = 0 ; i < lore.size() ; i++){
			 lore.set(i, lore.get(i).replace("&", "§"));
		 }
		 im.setLore(lore);
		 item.setItemMeta(im);
		 return item;
	 }
	 
	 
	 
	 
	
	
	

}
