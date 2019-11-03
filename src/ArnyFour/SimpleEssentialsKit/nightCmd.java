package ArnyFour.SimpleEssentialsKit;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nightCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public nightCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//if sender not player
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command avable only for players!");
			return true;
		}
		
		//if sender don't have permission
		if(!sender.hasPermission("essentials.time")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		World world = p.getWorld();
		world.setTime(14000); //set time
		sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "World time now:" + ChatColor.GRAY + " Night" + ChatColor.GREEN + "!");
		return true;
	}

}
