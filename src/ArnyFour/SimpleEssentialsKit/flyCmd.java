package ArnyFour.SimpleEssentialsKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public flyCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("essentials.fly")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
		}
		if(args.length == 0) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Command avable only for players!");
				return true;
			}
			Player p = (Player) sender;
			if(p.getAllowFlight() == true) {
		         p.setAllowFlight(false);
		         sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"You now can't fly!");
		         return true;
		    }
			p.setAllowFlight(true);
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"You now can fly!");
		}
		
		
		if(args.length == 1) {
			String name = args[0];
			Player p = Bukkit.getPlayer(name);
			if(p.getAllowFlight() == true) {
		         p.setAllowFlight(false);
		         sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"You now can't fly!");
		         return true;
		    }
			p.setAllowFlight(true);
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + name + " now can fly!");
			p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"You now can fly!");
		}
		return true;
	}
	
}
