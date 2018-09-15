package com.qiyue.Listener;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import com.qiyue.Main;
import com.qiyue.Command.RuneCommand;
import com.qiyue.Utils.playerdata;
import com.qiyue.rune.RuneSystem;
@SuppressWarnings("all")
public class PlayerRuneMain implements Listener {

    HashMap<String, String> OpenMap = new HashMap();
	  
	@EventHandler
	public void PlayerClickRuneMenu(InventoryClickEvent e){
		
		if(!(e.getWhoClicked() instanceof Player)) { return; }	
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals(p.getName() + "��a��l�ķ���ҳ")){
			
		String Prefix;
		Prefix = Main.instance.getConfig().getString("Prefix").replace("&", "��");
			
		if(e.getSlot() < 0 ){ return; }
				
		if(e.getRawSlot() > 44){ return; }
			
	    if(e.getSlot() > 8 && e.getSlot() < 35 && e.getInventory().getItem(e.getSlot()).getItemMeta().getDisplayName().contains("����ҳ")){
	    
	    	
	    if(e.isShiftClick()){
	    	
	    	 if(Main.data.getBoolean(p.getName()+".RunePage."+e.getSlot()+".enable"))
	 	    {
		 	  if(Main.data.getBoolean(p.getName()+".RunePage."+e.getSlot()+".use")){
		 			e.setCancelled(true);
		 			p.updateInventory();
		 			p.closeInventory();  	
		 			p.sendMessage(Prefix+"��c�÷���ҳ����ʹ����!");
		 			return; 
		 	  }else{
					e.setCancelled(true);
		 			p.updateInventory();
		 			p.closeInventory();  	
		 	        for (String s : Main.data.getConfigurationSection(p.getName() + ".RunePage").getKeys(false))
		 	        {
		 	          if (!Main.data.getBoolean(p.getName() + ".RunePage." + s + ".use"))
		 	          continue;
		 	          Main.data.set(p.getName() + ".RunePage." + s + ".use",false);
		 	        }
		 			Main.data.set(p.getName()+".RunePage."+e.getSlot()+".use", true);
		 			playerdata.save();
		 			p.sendMessage(Prefix+"��a��ʹ�ø÷���ҳ!");
		 			return; 
		 	  }
	    		 
	    		 
	    		 
	 	    }else{
	 			e.setCancelled(true);
	 			p.updateInventory();
	 			p.closeInventory();  	
	 			p.sendMessage(Prefix+"��c�÷���ҳ��û�н���");
	 			return;
	 	    }
	    	
	    	
	    }
	    	
	    	
	    	
	    if(e.isLeftClick()){
	    	
	    if(Main.data.getBoolean(p.getName()+".RunePage."+e.getSlot()+".enable"))
	    {
		e.setCancelled(true);
		p.updateInventory();
		p.closeInventory();  	
		p.openInventory(RuneSystem.getInstance().getRuneGui(p, e.getSlot()+""));
		this.OpenMap.put(p.getName(), e.getSlot()+"");
		return;
	    }
	    
	    else{
	       if (!Main.economy.has(p.getName(), Double.parseDouble(Main.instance.getConfig().getString("PayMoney"))))
	       {
	    	e.setCancelled(true);
	    	p.updateInventory();
	    	p.closeInventory();  	
	        p.sendMessage(Prefix+"��c��û���㹻�Ľ�Ǯ�������˷���ҳ!");
	        return;
	       }
	       int n = 0;
	       int i = 0;
	          for (String s : Main.data.getConfigurationSection(p.getName() + ".RunePage").getKeys(false))
	          {
	            if (!Main.data.getBoolean(p.getName() + ".RunePage." + s + ".enable"))
	              continue;
	            n++;
	          }

	          for (String s : Main.instance.getConfig().getConfigurationSection("RanePage.authority").getKeys(false))
	          {
	            if (!p.hasPermission("rune.por." + s))
	              continue;
	            i += Main.instance.getConfig().getInt("RanePage.authority." + s);
	          }

	          if (i > 18)
	          {
	            i = 18;
	          }
	          if (i == 0)
	          {
	            i = Main.instance.getConfig().getInt("RanePage.Normal");
	          }
	          if (n == i)
	          {
	            p.closeInventory();
	            p.sendMessage(Prefix + "��c��û��Ȩ�޽�������ķ���ҳ!");
	            return;
	          }   
	       
	       
	       
		e.setCancelled(true);
		p.updateInventory();
		p.closeInventory();  	
		Main.data.set(p.getName()+".RunePage."+e.getSlot()+".enable", true);
		playerdata.save();
	    Main.economy.withdrawPlayer(p.getName(), Double.parseDouble(Main.instance.getConfig().getString("PayMoney")));
		p.sendMessage(Prefix+"��a�ѻ��ѽ�ҽ�������ҳ");
		return;
	    }
	    
	    }
	    }
			
			
			
			
			
		e.setCancelled(true);
		p.updateInventory();
		p.closeInventory();
			
		}
		
		
		
	}
	
	
	@EventHandler
	public void PlayerClickRuneGui(InventoryClickEvent e){

	if(!(e.getWhoClicked() instanceof Player)) { return; }	
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getSlot() < 0 ){ return; }
		
		if(!this.OpenMap.containsKey(p.getName())){ 
			return; 
		}
		
		if(! Main.data.getString(p.getName()+".RunePage."+this.OpenMap.get(p.getName())+".disyname").equals(e.getInventory().getTitle())){
			return;
		}
		
		
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR){
			return;
		}
		
		for(String node : Main.instance.getConfig().getConfigurationSection("RuneItem").getKeys(false)){
			if(e.getCurrentItem().isSimilar(RuneSystem.getInstance().getRune(node))){
			  return;
			}
		}
		
		e.setCancelled(true);
		p.updateInventory();
		
		
		
	
		
	}
	
	
	@EventHandler
	public void PlayerCloseRuneGui(InventoryCloseEvent e){
		
	Player p = (Player) e.getPlayer();
		
	if(this.OpenMap.containsKey(p.getName()) && Main.data.getString(p.getName()+".RunePage."+this.OpenMap.get(p.getName())+".disyname").equals(e.getInventory().getTitle())){
		
		ItemStack[] items = e.getInventory().getContents();
		
		String runes = "";
		
		for(int i = 9 ; i < 36 ; i++){
			
		ItemStack item = e.getInventory().getItem(i);
				
		if(item != null && item.getType() != Material.AIR && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().contains(Main.instance.getConfig().getString("RuneLogo")))
		  {
		     for(String node : Main.instance.getConfig().getConfigurationSection("RuneItem").getKeys(false))
		     {
		    	if(RuneSystem.getInstance().getRune(node).isSimilar(item)){
		    	 runes = runes + node + ",";
		    	}  
		      }
		    		
		}else{
	    	 runes = runes + "air" + ",";	
		}
		}
		
		runes = runes.substring(0,runes.length() - 1);
		Main.data.set(p.getName()+".RunePage."+ OpenMap.get(p.getName()) + ".ItemStack", runes); 
		playerdata.save();
		this.OpenMap.remove(p.getName());
		
	}
		
		
		
		
		
		
	}
	
	
	
	
}
