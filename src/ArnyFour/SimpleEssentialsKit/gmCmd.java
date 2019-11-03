package ArnyFour.SimpleEssentialsKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmCmd implements CommandExecutor{

	@SuppressWarnings("unused")
	private Essentials plugin;

	public gmCmd(Essentials plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//if player don't have special permission 
				if(!sender.hasPermission("essentials.gamemode")) {
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "You don't have permissions to run this command!");
					return true;
				}
				
				//if command don't have args
				if(args.length == 0) {
					return false;
				}
				
				//if player want change game mode for self
				if(args.length == 1) {
					
					String mode = args[0];
					
					if(!(sender instanceof Player)) {
						sender.sendMessage(ChatColor.RED + "Command avable only for players!");
						return true;
					}
					
					if (mode.equals("1")) {
						Player p = (Player) sender;
						p.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GOLD + "Creative"+ ChatColor.GRAY + "!");
					}
					
					else if(mode.equals("0")){
						Player p = (Player) sender;
						p.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.RED + "Survival"+ ChatColor.GRAY + "!");
					}
					
					else if(mode.equals("2")) {
						Player p = (Player) sender;
						p.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GRAY + "Adventure"+ ChatColor.GRAY + "!");
					}
					
					else if(mode.equals("3")) {
						Player p = (Player) sender;
						p.setGameMode(GameMode.SPECTATOR);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GRAY + "Spectator"+ ChatColor.GRAY + "!");
					}
					
					else {
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "Unknown gamemode!");
					}
					
				    
				}
				
				//if player want change gamemode for other player
				else if(args.length == 2) {
					
					String name = args[1];
					String mode = args[0];
					Player p = Bukkit.getPlayer(name);
					
					if(p == null) {
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "I can't find player " + name);
						return true;
					}
					
					if (mode.equals("1")) {
						p.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + name +" gamemode changed to " + ChatColor.GOLD + "Creative"+ ChatColor.GRAY + "!");
						p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GOLD + "Creative"+ ChatColor.GRAY + "!");
					}
					
					else if(mode.equals("0")){
						p.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + name +" gamemode changed to " + ChatColor.RED + "Survival"+ ChatColor.GRAY + "!");
						p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.RED + "Survival"+ ChatColor.GRAY + "!");
					}
					
					else if(mode.equals("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + name +" gamemode changed to " + ChatColor.GRAY + "Adventure"+ ChatColor.GRAY + "!");
						p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GRAY + "Adventure"+ ChatColor.GRAY + "!");

					}
					
					else if(mode.equals("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + name +" gamemode changed to " + ChatColor.GRAY + "Spectator"+ ChatColor.GRAY + "!");
						p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.GREEN + "You gamemode changed to " + ChatColor.GRAY + "Spectator"+ ChatColor.GRAY + "!");

					}
					
					else {
						sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SimpleEssentials"+ ChatColor.GRAY +"] " + ChatColor.RED + "Unknown gamemode!");
					}
				    
				}
		return true;
	}

}
