package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class onPlayerDie {
    private final PlayerDeathEvent en;

    /**
     * 构造
     *
     * @param en 事件
     */
    public onPlayerDie(PlayerDeathEvent en) {
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
     * 获取将向服务器上的每个人显示的死亡消息
     *
     * @return 消息内容
     */
    public String getDeathMessage() {
        return en.getDeathMessage();
    }

    /**
     * 返回此事件中涉及的实体
     *
     * @return 实体
     */
    public Player getEntity() {
        return new Player(en.getEntity());
    }

    /**
     * 是否保留背包
     *
     * @return 是否保留背包
     */
    public boolean getKeepInventory() {
        return en.getKeepInventory();
    }

    /**
     * 获取玩家是否应在重生时保留所有经验值
     *
     * @return 是否保留经验值
     */
    public boolean getKeepLevel() {
        return en.getKeepLevel();
    }

    /**
     * 获取玩家在重生时应该拥有多少经验值
     *
     * @return 玩家重生时的经验值
     */
    public int getNewExp() {
        return en.getNewExp();
    }

    /**
     * 获取玩家重生时应达到的等级
     *
     * @return 玩家重生时的等级
     */
    public int getNewLevel() {
        return en.getNewLevel();
    }

    /**
     * 获取玩家重生时应拥有的总经验值
     *
     * @return 玩家重生时的总经验值
     */
    public int getNewTotalExp() {
        return en.getNewTotalExp();
    }

    /**
     * 设置将向服务器上的每个人显示的死亡消息
     *
     * @param deathMessage 死亡消息内容
     */
    public void setDeathMessage(String deathMessage) {
        en.setDeathMessage(deathMessage);
    }

    /**
     * 设置玩家是否在死亡时保留库存
     *
     * @param keepInventory 是否保留
     */
    public void setKeepInventory(boolean keepInventory) {
        en.setKeepInventory(keepInventory);
    }

    /**
     * 设置玩家是否应该在重生时保留所有经验值
     *
     * @param keepLevel 是否保留经验值
     */
    public void setKeepLevel(boolean keepLevel) {
        en.setKeepLevel(keepLevel);
    }

    /**
     * 设置玩家在重生时应该拥有多少经验值
     *
     * @param exp 经验值
     */
    public void setNewExp(int exp) {
        en.setNewExp(exp);
    }

    /**
     * 设置玩家重生时应达到的等级。
     * @param level 等级
     */
    public void setNewLevel(int level) {
        en.setNewLevel(level);
    }

    /**
     * 设置玩家重生时应拥有的总经验值。
     * @param totalExp 总经验值
     */
    public void setNewTotalExp(int totalExp) {
        en.setNewTotalExp(totalExp);
    }
}
