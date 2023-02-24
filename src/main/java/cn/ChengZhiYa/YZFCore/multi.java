package cn.ChengZhiYa.YZFCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.lang.*;

public class multi {
    public static void ClearHashMap() {
        Location_HashMap.clear();
    }

    public static void ColorLog(String Message) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(ChatColor(Message));
    }

    public static String ChatColor(String Message) {
        return ChatColor.translateAlternateColorCodes('&',Message);
    }

    public static Boolean IsAdmin(Long QQ号) {
        return QQ号 == 292200693L || QQ号 == 779664169L || QQ号 == 2975161182L || QQ号 == 3321464686L;
    }
}
