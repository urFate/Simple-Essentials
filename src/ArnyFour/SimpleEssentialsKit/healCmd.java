package ArnyFour.SimpleEssentialsKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public healCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("essentials.heal")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
		}

		
		if(args.length == 0) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Command avable only for players!");
				return true;
			}
			Player p = (Player) sender;
			p.setHealth(20);
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"Healhty heal!");
		}
		if(args.length == 1) {
			String name = args[0];
			Player p = Bukkit.getPlayer(name);
			if(p == null) {
				sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "I can't find player " + name);
				return true;
			}
			p.setHealth(20);
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"Healhty heal for " + name +"!");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"Healhty heal!");
		}
		
		
		return true;
	}
	
}
