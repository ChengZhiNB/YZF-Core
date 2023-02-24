package cn.ChengZhiYa.YZFCore;

import litebans.api.Entry;
import litebans.api.Events;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.UUID;

import static cn.ChengZhiYa.YZFCore.multi.*;

public final class main extends JavaPlugin {

    public static main main;

    public static Events.Listener 监听器;
    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        监听器 = new Events.Listener() {
            @Override
            public void entryAdded(Entry entry) {
                if (entry.getType().equals("ban")) {
                    MiraiBot 机器人 = MiraiBot.getBot(3174943121L);
                    MiraiGroup 群1 = 机器人.getGroup(801329619L);
                    MiraiGroup 群2 = 机器人.getGroup(152848071L);
                    String 玩家ID = Bukkit.getOfflinePlayer(UUID.fromString(Objects.requireNonNull(entry.getUuid()))).getName();
                    String 消息 = "========封禁系统========\n" +
                            玩家ID + "被封禁了!\n" +
                            "封禁理由: " + entry.getReason() + "\n" +
                            "========封禁系统========";
                    群1.sendMessage(消息);
                    群2.sendMessage(消息);
                }
            }

            @Override
            public void entryRemoved(Entry entry) {
                if (entry.getType().equals("ban")) {
                    MiraiBot 机器人 = MiraiBot.getBot(3174943121L);
                    MiraiGroup 群1 = 机器人.getGroup(801329619L);
                    MiraiGroup 群2 = 机器人.getGroup(152848071L);
                    String 玩家ID = Bukkit.getOfflinePlayer(UUID.fromString(Objects.requireNonNull(entry.getUuid()))).getName();
                    String 消息 = "========封禁系统========\n" +
                            玩家ID + "被解封了!\n" +
                            "========封禁系统========";
                    群1.sendMessage(消息);
                    群2.sendMessage(消息);
                }
            }
        };
        ColorLog("&7---------&6夜之粉服务器核心&7---------");
        ColorLog("&6作者: ChengZhiYa QQ:292200693");
        ColorLog("&e非常感谢 夜之粉所有人员!");
        Bukkit.getPluginManager().registerEvents(new PlayerChat(),this);
        Bukkit.getPluginManager().registerEvents(new MiraiGroupMessage(),this);
        Events.get().register(监听器);
        Objects.requireNonNull(getCommand("YZFReload")).setExecutor(new Relaod());
        ColorLog("&a插件启动!");
        ColorLog("&7---------&6夜之粉服务器核心&7---------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        main = null;
        ColorLog("&7---------&6夜之粉服务器核心&7---------");
        ColorLog("&6作者: ChengZhiYa QQ:292200693");
        ColorLog("&e非常感谢 夜之粉所有人员!");
        Events.get().unregister(监听器);
        ColorLog("&a插件已关闭!");
        ColorLog("&7---------&6夜之粉服务器核心&7---------");
    }
}
