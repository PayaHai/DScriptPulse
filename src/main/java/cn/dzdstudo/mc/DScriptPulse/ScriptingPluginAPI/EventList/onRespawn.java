package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;
import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Pos;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Objects;

public class onRespawn {
    private final org.bukkit.event.player.PlayerRespawnEvent en;

    /**
     * 构造
     *
     * @param en 事件
     */
    public onRespawn(org.bukkit.event.player.PlayerRespawnEvent en) {
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
     * 获取重生位置
     *
     * @return 重生位置
     */
    public Pos getRespawnLocation() {
        return new Pos(en.getRespawnLocation());
    }

    /**
     * 获取调用此重生事件的原因
     *
     * @return 重生原因
     */
    public String getRespawnReason() {
        PlayerRespawnEvent.RespawnReason reason = en.getRespawnReason();
        if(reason == PlayerRespawnEvent.RespawnReason.DEATH) {
            // 当玩家死亡并按下重生按钮时
            return "DEATH";
        } else if(reason == PlayerRespawnEvent.RespawnReason.END_PORTAL) {
            // 当玩家通过终端门户离开终端时
            return "END_PORTAL";
        } else if(reason == PlayerRespawnEvent.RespawnReason.PLUGIN) {
            // 当插件重生玩家时
            return "PLUGIN";
        }

        return Objects.requireNonNull(reason.name());
    }

    /**
     * 获取重生位置是否为玩家的重生锚点
     *
     * @return 是否为重生锚点
     */
    public boolean isAnchorSpawn() {
        return en.isAnchorSpawn();
    }

    /**
     * 获取重生位置是否是玩家的床
     */
    public boolean isBedSpawn() {
        return en.isBedSpawn();
    }

    /**
     * 设置新的重生位置
     */
    public void setRespawnLocation(Pos pos) {
        en.setRespawnLocation(new Location(Bukkit.getWorld(pos.getWorld().getName()), pos.getX(), pos.getY(), pos.getZ()));
    }
}
