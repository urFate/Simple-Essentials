package ArnyFour.SimpleEssentialsKit;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin{
	public void onEnable() {
		File config = new File(getDataFolder() + File.separator + "config.yml");
		//if plugin can't find config file
		if (!config.exists()) {
			getLogger().info("Cannot find config file, creating...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			Bukkit.getConsoleSender().sendMessage("[SimpleEssentials]Config file " + ChatColor.GREEN + "created!");
		}
		
		
		
		//getting commands
		getCommand("gamemode").setExecutor(new gmCmd(this));
		getCommand("day").setExecutor(new dayCmd(this));
		getCommand("night").setExecutor(new nightCmd(this));
		getCommand("bc").setExecutor(new bcCmd(this));
		getCommand("kick").setExecutor(new kickCmd(this));
		getCommand("fly").setExecutor(new flyCmd(this));
		getCommand("heal").setExecutor(new healCmd(this));
		getCommand("ban").setExecutor(new banCmd(this));
		getCommand("unban").setExecutor(new unbanCmd(this));
		
		//register events
		Bukkit.getPluginManager().registerEvents(new welcomeMsg(this), this);
		
		//send log message on enable
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentials] Plugin " + ChatColor.GREEN + "ENABLED!");
	}
	
	public void onDisable() {
		//send log message on disable
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentials] Plugin " + ChatColor.RED + "DISABLED!");
	}
}
