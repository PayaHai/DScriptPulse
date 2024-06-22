package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;

import java.util.Objects;

import static org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.ALLOWED;

public class onPreJoin {
    private final org.bukkit.event.player.AsyncPlayerPreLoginEvent en;

    /**
     * 构造
     *
     * @param en 事件
     */
    public onPreJoin(org.bukkit.event.player.AsyncPlayerPreLoginEvent en) {
        this.en = en;
    }

    /**
     * 允许玩家登录
     */
    public void getPlayer() {
        this.en.allow();
    }

    /**
     * 禁止玩家登录
     *
     * @param type 禁止类型
     * @param msg 返回消息
     */
    public void disallow(int type, String msg) {
        if(type == 0) {
            // 允许登录
            this.en.disallow(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.ALLOWED, msg);
        } else if (type == 1) {
            // 禁止登录
            this.en.disallow(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_BANNED, msg);
        } else if (type == 2) {
            // 服务器已满
            this.en.disallow(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_FULL, msg);
        } else if (type == 3) {
            // 原因不明
            this.en.disallow(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_OTHER, msg);
        } else if (type == 4) {
            // 玩家不在白名单内
            this.en.disallow(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, msg);
        }
    }

    /**
     * 获取玩家 IP 地址
     *
     * @return IP 地址
     */
    public String getAddress() {
        return this.en.getAddress().toString();
    }

    /**
     * 获取玩家名称
     *
     * @return 玩家名称
     */
    public String getName() {
        return this.en.getName();
    }

    /**
     * 获取玩家 UUID
     *
     * @return UUID
     */
    public String getUUID() {
        return this.en.getUniqueId().toString();
    }
}
