package ArnyFour.SimpleEssentialsKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class unbanCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public unbanCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("essentials.admin.ban")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
			return true;
		}
		if(args.length == 0) {
			return false;
		}
		
		String name = args[0];
		Bukkit.getBanList(Type.NAME).pardon(name);
		sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"Player "+ChatColor.DARK_GREEN+name+ChatColor.GREEN+" was been unbanned!");
		return true;
	}
	
}
