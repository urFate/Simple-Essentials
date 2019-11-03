package ArnyFour.SimpleEssentialsKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class bcCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public bcCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!sender.hasPermission("essentials.broadcast")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
		}
		if(args.length == 0) {
			return false;
		}
		
		String msg = String.join(" ", args);
		
		Bukkit.broadcastMessage(ChatColor.GRAY+"[" + ChatColor.GOLD +"Broadcast"+ChatColor.GRAY+"] " + msg);
		return true;
	}

	
}