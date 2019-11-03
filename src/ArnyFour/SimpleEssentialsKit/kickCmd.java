package ArnyFour.SimpleEssentialsKit;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public kickCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("essentials.admin.kick")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
			return true;
		}
		if(args.length == 0) {
			return false;
		}
		
		String name = args[0];
		String reason = String.join(" ", (CharSequence[]) ArrayUtils.remove(args, 0));
		Player p = Bukkit.getPlayer(name);
		
		if(p == null) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "I can't find player " + name);
			return true;
		}
		String admin = sender.getName();
		p.kickPlayer("You are kicked by "+ ChatColor.GOLD + admin + ChatColor.WHITE +"\nReason: "+ ChatColor.RED + reason);
		sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN +"Player "+ChatColor.DARK_GREEN+name+ChatColor.GREEN+" was been kicked!");
		
		return true;
	}

}
