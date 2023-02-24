package cn.ChengZhiYa.YZFCore;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static cn.ChengZhiYa.YZFCore.multi.ChatColor;

public class PlayerChat implements Listener {
    @EventHandler
    public void On_Event(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (event.getMessage().equals("!c")) {
            Bukkit.getScheduler().runTask(main.main, () -> {
                String PlayerName = player.getName();
                if (Location_HashMap.get(PlayerName) == null) {
                    player.sendMessage(ChatColor("&a已切换至旁观模式"));
                    Location_HashMap.set(PlayerName, player.getLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                } else {
                    player.sendMessage(ChatColor("&a已切换至生存模式"));
                    player.teleport(Location_HashMap.get(PlayerName));
                    Location_HashMap.remove(PlayerName);
                    player.setGameMode(GameMode.SURVIVAL);
                }
            });
        }
    }
}
