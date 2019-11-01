package ArnyFour.SimpleEssentilasKit;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class welcomeMSG implements Listener{
	@SuppressWarnings("unused")
	private Essentilas plugin;
	
	public welcomeMSG(Essentilas plugin) {
		this.plugin = plugin;
	}
	
	//create joinMsg method
	@EventHandler
	public void joinMsg(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String s;
		s  = plugin.getConfig().getString("messages.welcome");
		s = s.replace("&", "\u00a7");
		//sending message
		p.sendMessage(s);
				
	}
}
