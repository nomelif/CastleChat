package me.martin.CastleChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CastleChat extends JavaPlugin implements Listener {
		
		String[] warned = new String[100];
	
        public void onEnable(){
        	PluginManager pm = getServer().getPluginManager();
        	pm.registerEvents(new CastleChat(), this);          
        }
        
        @EventHandler
        public void onChat(AsyncPlayerChatEvent event){
        	
        	String m = event.getMessage();
        	Boolean swear = false;
        	
        	if(m.indexOf("server") != -1 && m.indexOf("admin") != -1){
        		if(m.indexOf("suck") != -1){
	        		event.setCancelled(true);
	        		String ign = event.getPlayer().getName();
	        		Boolean warn = false;
	        		for (int i = 0; i < warned.length; i++){
	        			if(warned[i] == ign){
	        				event.getPlayer().setBanned(true);
	        				event.getPlayer().kickPlayer("Bye bye, we don't need you on our server.");
	        				warn = true;
	        			}
	        		}
	        		if(!warn){
		        		push(warned, ign);
		        		event.getPlayer().kickPlayer("Don't write this kind of messages or you will be banned!");
	        		}
        		}
        	}
        	
        	event.setFormat(ChatColor.GREEN + "%s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%s");
        	
        	if(m.indexOf("suck") != -1){
        		m.replace("suck", "☠");
        		swear = true;
        	}else if(m.indexOf("fuck") != -1){
        		m.replace("fuck", "☠");
        		swear = true;
        	}else if(m.indexOf("asshole") != -1){
        		m.replace("asshole", "☠");
        		swear = true;
        	}else if(m.indexOf("ashole") != -1){
        		m.replace("ashole", "☠");
        		swear = true;
        	}
        	
        	event.setMessage(m);
        	
        	if(swear){
        		event.getPlayer().sendMessage(ChatColor.YELLOW + "Dont swear!");
        	}
        }
        
        /*public void onPlayerJoin(PlayerJoinEvent event){
        	Player player = event.getPlayer();
        	event.setJoinMessage(ChatColor.LIGHT_PURPLE + "Welcome to ");
        }*/
        
        private static String[] push(String[] array, String push) {
            String[] longer = new String[array.length + 1];
            System.arraycopy(array, 0, longer, 0, array.length);
            longer[array.length] = push;
            return longer;
        }
        
}