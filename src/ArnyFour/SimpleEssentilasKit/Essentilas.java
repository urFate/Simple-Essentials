package ArnyFour.SimpleEssentilasKit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Essentilas extends JavaPlugin{
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentilas] Plugin " + ChatColor.GREEN + "ENABLED!");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[SimpleEssentilas] Plugin " + ChatColor.RED + "DISABLED!");
	}
}
