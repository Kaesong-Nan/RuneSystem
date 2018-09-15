package com.qiyue.Command;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.qiyue.Main;
import com.qiyue.Utils.playerdata;
import com.qiyue.Utils.utils;
import com.qiyue.rune.RuneSystem;
@SuppressWarnings("all")
public class RuneCommand implements CommandExecutor {

	String Prefix = "";
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String lable,String[] args) {
		   if(lable.equalsIgnoreCase("rune")){
			   Prefix = Main.instance.getConfig().getString("Prefix").replace("&", "��");
			   FileConfiguration config = Main.instance.getConfig();
				   if (args.length == 0)
				    {
				      sender.sendMessage("��b��m��l---------��8��l[ ��d��l����ϵͳ��8��l]��b��m��l---------");
				      sender.sendMessage("��6/Rune open                    ��f������b����ķ���ҳ");
				      if(sender.isOp())
				      {
				      sender.sendMessage("��6/Rune get <����> <����>       ��f������b��ȡ����  ");
				      sender.sendMessage("��6/Rune list                    ��f������b�г����з���");
				      sender.sendMessage("��6/Rune reload                  ��f������b���ز��");
				      }
				      return true;
				    
			   } 
				 if(args[0].equalsIgnoreCase("open")){
					 if(!(sender instanceof Player)){
						sender.sendMessage(Prefix+"��c������޷�ʹ�ô�����");
						return true;
					 }	
					 Player p = (Player) sender;
					 if(!playerdata.have(p.getName())){
						 playerdata.addDefault(p.getName());
					 }
					 p.closeInventory();
					 p.openInventory(RuneSystem.getInstance().getMenu(p));
					 return true;
				 }
			     if(args[0].equalsIgnoreCase("get")){
			    	 
			    	 if(sender.isOp()){
			    	 
					 if(!(sender instanceof Player)){
							sender.sendMessage(Prefix+"��c������޷�ʹ�ô�����");
							return true;
					 }	
					 
					 Player p = (Player) sender;
			    	 if(args.length != 3){
			    		 sender.sendMessage(Prefix+"��f/Rune get <����> <����> ");
			    		 return true;
			    	 }
			    	  if(config.getString("RuneItem."+args[1]) == null){
			    		  sender.sendMessage(Prefix+"��c�˷��Ĳ�������!");
				    	  return true;
			    	  }
			    	  if(!utils.isNumber(args[2])){
			    		  sender.sendMessage(Prefix+"��c��������������");
				    	  return true;
			    	  }
			    	  ItemStack item = RuneSystem.getInstance().getRune(args[1]);
			    	  item.setAmount(Integer.parseInt(args[2]));
			    	  p.getInventory().addItem(item);
			    	 
			    	  return true;
			    	 }else{
			    	  sender.sendMessage(Prefix+"��c��û��Ȩ��ʹ���������!");	 
			    	  return true; 
			    		 
			    	 }
			     }
				  if(args[0].equalsIgnoreCase("reload")){
					  if(sender.isOp()){
						  Main.instance.reloadConfig();
						  Main.data = playerdata.getDataFile();
						  sender.sendMessage(Prefix+"��a�����ļ�������.");
					  }else{
				      sender.sendMessage(Prefix+"��c��û��Ȩ��ʹ���������!");	
				      return true;
					  }
				  }
				  if(args[0].equalsIgnoreCase("list")){
					  if(sender.isOp()){
						sender.sendMessage("��a��m��l������������������������������������������������������������������������");
						if(config.getConfigurationSection("RuneItem").getKeys(false).size() == 0){
						sender.sendMessage("��c��");
						}else{
						for(String s : config.getConfigurationSection("RuneItem").getKeys(false)){
							sender.sendMessage(Prefix+"��f"+s+"  "+RuneSystem.getInstance().getRune(s).getItemMeta().getDisplayName());
						}
						}
						sender.sendMessage("��a��m��l������������������������������������������������������������������������");
						return true;
					  }else{
				      sender.sendMessage(Prefix+"��c��û��Ȩ��ʹ���������!");	
				      return true;
					  }
				  }
			   
			   
			   
			   
			   
			   
			   
			   return true;
		   }
		
		
		
		
		
		
		
		return false;
	}



}
