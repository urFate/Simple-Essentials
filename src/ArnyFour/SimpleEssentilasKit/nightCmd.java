package ArnyFour.SimpleEssentilasKit;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class nightCmd implements CommandExecutor{

	private Essentilas plugin;

	public nightCmd(Essentilas plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command avable only for players!");
			return true;
		}
		
		if(!sender.hasPermission("essentilas.time")) {
			sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentilas"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		World world = p.getWorld();
		world.setTime(14000);
		sender.sendMessage(ChatColor.GREEN + "World time now:" + ChatColor.GRAY + " Night" + ChatColor.GREEN + "!");
		return true;
	}

}
