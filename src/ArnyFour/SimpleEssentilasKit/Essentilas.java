package ArnyFour.SimpleEssentilasKit;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Essentilas extends JavaPlugin{
	public void onEnable() {
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		//if plugin can't find config file
		if (!config.exists()) {
			getLogger().info("Cannot find config file, creating...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			Bukkit.getConsoleSender().sendMessage("[SimpleEssentilas]Config file " + ChatColor.GREEN + "created!");
		}
		
		getCommand("gm").setExecutor(new gmCmd(this));
		getCommand("day").setExecutor(new dayCmd(this));
		getCommand("night").setExecutor(new nightCmd(this));
		
		//register welcome message class
		Bukkit.getPluginManager().registerEvents(new welcomeMSG(this), this);
		
		//send log message to console about enable
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentilas] Plugin " + ChatColor.GREEN + "ENABLED!");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentilas] Plugin " + ChatColor.RED + "DISABLED!");
	}
}
