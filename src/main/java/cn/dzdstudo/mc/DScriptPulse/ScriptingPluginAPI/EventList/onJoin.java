package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;

import java.util.Objects;

public class onJoin {
    private final org.bukkit.event.player.PlayerJoinEvent en;

    /**
     * 构造
     *
     * @param en 事件
     */
    public onJoin(org.bukkit.event.player.PlayerJoinEvent en) {
        this.en = en;
    }

    /**
     * 获取玩家
     *
     * @return 玩家对象
     */
    public Player getPlayer() {
        return new Player(en.getPlayer());
    }

    /**
     * 获取玩家加入消息
     * 获取要发送给在线玩家的消息
     *
     * @return 消息内容
     */
    public String getJoinMessage() {
        return Objects.requireNonNull(en.joinMessage()).toString();
    }
}
