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

        public void onEnable(){
        	PluginManager pm = getServer().getPluginManager();
        	pm.registerEvents(new CastleChat(), this);               
        }
        
        @EventHandler
        public void onChat(AsyncPlayerChatEvent event){
        	Player player = event.getPlayer();
        	event.setFormat(ChatColor.GREEN + "%s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%s");
        }
        
        /*public void onPlayerJoin(PlayerJoinEvent event){
        	Player player = event.getPlayer();
        	event.setJoinMessage(ChatColor.LIGHT_PURPLE + "Welcome to ");
        }*/
        
}