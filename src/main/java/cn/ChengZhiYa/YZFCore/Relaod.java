package cn.ChengZhiYa.YZFCore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static cn.ChengZhiYa.YZFCore.multi.ChatColor;
import static cn.ChengZhiYa.YZFCore.multi.ClearHashMap;

public class Relaod implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor("&aéè½½æå!"));
        main.main.reloadConfig();
        ClearHashMap();
        return false;
    }
}
