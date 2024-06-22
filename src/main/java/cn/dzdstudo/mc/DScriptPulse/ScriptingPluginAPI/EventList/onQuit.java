package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;

import java.util.Objects;

public class onQuit {
    private final org.bukkit.event.player.PlayerQuitEvent en;

    /**
     * 构造
     *
     * @param en 事件
     */
    public onQuit(org.bukkit.event.player.PlayerQuitEvent en) {
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
     * 获取要发送给所有在线玩家的退出消息
     *
     * @return 消息内容
     */
    public String getQuitMessage() {
        return Objects.requireNonNull(en.getQuitMessage());
    }

    /**
     * 设置要发送给所有在线玩家的退出消息
     *
     * @param msg 消息内容
     */
    public void setQuitMessage(String msg) {
        en.setQuitMessage(msg);
    }
}
