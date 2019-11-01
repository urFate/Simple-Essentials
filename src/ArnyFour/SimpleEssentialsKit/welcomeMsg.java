package ArnyFour.SimpleEssentialsKit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class welcomeMsg implements Listener {
	@SuppressWarnings("unused")
	private Essentials plugin;

	public welcomeMsg(Essentials plugin) {
		this.plugin = plugin;
	}
	
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
