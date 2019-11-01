package ArnyFour.SimpleEssentialsKit;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class dayCmd implements CommandExecutor{

	private Essentials plugin;

	public dayCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//if sender not player
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command avable only for players!");
			return true;
		}
		
		//if player don't have permission
		if(!sender.hasPermission("essentials.time")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		World world = p.getWorld();
		world.setTime(0); //set time 
		sender.sendMessage(ChatColor.GREEN + "World time now:"+ ChatColor.GOLD +" Day"+ChatColor.GREEN+"!");
		return true;
	}

}
