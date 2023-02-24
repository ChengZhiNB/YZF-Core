package cn.ChengZhiYa.YZFCore;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

import static cn.ChengZhiYa.YZFCore.multi.IsAdmin;

public class MiraiGroupMessage implements Listener {
    @EventHandler
    public void On_Event(MiraiGroupMessageEvent event) {
        MiraiBot 机器人 = MiraiBot.getBot(3174943121L);
        String[] 发送的消息内容 = event.getMessage().split("#");
        long 发送者QQ = event.getSenderID();
        MiraiGroup 发送的群聊 = 机器人.getGroup(event.getGroupID());
        if (发送的消息内容[0].equals("服务器状态")) {
            List<String> 玩家列表 = new ArrayList<>();
            for (Player 所有在线玩家 : Bukkit.getOnlinePlayers()) {
                玩家列表.add(所有在线玩家.getName());
            }
            String 消息 = "=======服务器状态=======\n" +
                    "状态: 运行中\n" +
                    "服务器在线人数: " + Bukkit.getOnlinePlayers().size() + "\n" +
                    "服务器在线列表: \n" +
                    玩家列表 + "\n" +
                    "=======服务器状态=======";
            发送的群聊.sendMessage(消息);
            return;
        }
        if (发送的消息内容[0].equals("执行命令")) {
            if (发送的消息内容.length == 2) {
                if (IsAdmin(发送者QQ)) {
                        Bukkit.getScheduler().runTask(main.main, () -> {
                            try {
                                if (Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),发送的消息内容[1])) {
                                    发送的群聊.sendMessage("执行完成!");
                                }else {
                                    发送的群聊.sendMessage("这个命令不存在!");
                                }
                            }catch (Exception e) {
                                发送的群聊.sendMessage("发生错误,请去控制台查看详细报错内容!");
                                System.out.println("执行的命令: " + 发送的消息内容[1]);
                                System.out.println("执行者: " + Bukkit.getConsoleSender());
                                System.out.println("详细报错: ");
                                e.printStackTrace();
                            }
                        });
                }else {
                    发送的群聊.sendMessage("权限不足!");
                }
            }else {
                发送的群聊.sendMessage("格式错误! 正确格式: 执行命令#<命令>");
            }
        }
    }
}
