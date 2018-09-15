package com.qiyue.Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;




import com.attribute.Listener.NewEvent;
import com.qiyue.Main;
import com.qiyue.rune.RuneSystem;

@SuppressWarnings("all")
public class PlayerDamger implements Listener {

	@EventHandler
	public void Attribute(NewEvent e){
		
		
		
	if(e.getDamger() instanceof Player){
		Player p = (Player) e.getDamger();
		List<String> lore = RuneSystem.getInstance().getRuneAttribute(p,Integer.parseInt(RuneSystem.getInstance().getUseRune(p)));
		List<String> lores = new ArrayList<>();
		
		for(String node : lore){
		 
			  if(!node.split(":")[1].equals("0") && !node.split(":")[1].equals("0.0"))
			  {
				 lores.add(node);	 
			  
			  }
	    }
 
       for(String node : lores){
     	  if(node.split(":")[0].equals("hp2"))
   	   {
   		   e.set2(e.get2() + Double.parseDouble(node.split(":")[1]));
   	   }
     	   if(node.split(":")[0].equals("hp7"))
   	   {
   		   e.set7(e.get7() +Double.parseDouble(node.split(":")[1]));
   	   }
     	   if(node.split(":")[0].equals("hp13"))
   	   {
   		   e.set13(e.get13() + Double.parseDouble(node.split(":")[1]));
   	   }
       }
	}
		
		
		
	if(e.getKillDamger() instanceof Player){
		Player p = (Player) e.getKillDamger();
		List<String> lore = RuneSystem.getInstance().getRuneAttribute(p,Integer.parseInt(RuneSystem.getInstance().getUseRune(p)));
		List<String> lores = new ArrayList<>();
		for(String node : lore){
		 
			  if(!node.split(":")[1].equals("0") && !node.split(":")[1].equals("0.0"))
			  {
				 lores.add(node);	 
			  }
			  
	    }
 
       for(String node : lores){
    	   if(node.split(":")[0].equals("hp1"))
    	   {
    		   e.set1(e.get1() + Double.parseDouble(node.split(":")[1]));
    	   }
 
      	   if(node.split(":")[0].equals("hp3"))
    	   {
    		   e.set3(e.get3() + Double.parseDouble(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp4"))
    	   {
    		   e.set4(e.get4() + Integer.parseInt(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp5"))
    	   {
    		   e.set5(e.get5() + Double.parseDouble(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp6"))
    	   {
    		   e.set6(e.get6() + Integer.parseInt(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp7"))
    	   {
    		   e.set7(e.get7() + Double.parseDouble(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp8"))
    	   {
    		   e.set8(e.get8() + Double.parseDouble(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp9"))
    	   {
    		   e.set9(e.get9() + Double.parseDouble(node.split(":")[1]));
    	   }
      	   if(node.split(":")[0].equals("hp10"))
    	   {
      		  e.set10(e.get10() + Double.parseDouble(node.split(":")[1]));
    	   }  	   
    	   if(node.split(":")[0].equals("hp11"))
    	   {
      		  e.set11(e.get11() + Double.parseDouble(node.split(":")[1]));
    	   }  	   
    	   if(node.split(":")[0].equals("hp12"))
    	   {
      		  e.set12(e.get12() + Double.parseDouble(node.split(":")[1]));
    	   }  	   
   
      	   
      	   
      	   
      	   
      	   
      	   
      	   
      	   
      	   
      	   
       }
		
		
		
	}
	
		
		
	}

}
