package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

/**
 * 玩家对象
 */
public class Player {
    private final org.bukkit.entity.Player player;

    /**
     * 构造
     *
     * @param player 玩家
     */
    public Player(org.bukkit.entity.Player player) {
        this.player = player;
    }

    /**
     * 获取玩家名称
     *
     * @return 玩家名称
     */
    public String getName() {
        return this.player.getName();
    }

    /**
     * 获取玩家UUID
     *
     * @return UUID
     */
    public UUID getUUID() {
        return this.player.getUniqueId();
    }

    /**
     * 获取玩家坐标
     *
     * @return 位置对象
     */
    public Pos getPos() {
        return new Pos(this.player.getLocation());
    }

    /**
     * 获取玩家世界
     *
     * @return 世界对象
     */
    public World getWorld() {
        return new World(this.player.getWorld().getName());
    }

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    public void sendMessage(String msg) {
        this.player.sendMessage(msg);
    }

    /**
     * 传送玩家到指定地点
     *
     * @param pos 位置对象
     * @return 是否成功
     */
    public boolean teleport(Pos pos) {
        return this.player.teleport(new Location(Bukkit.getWorld(pos.getWorld().getName()), pos.getX(), pos.getY(), pos.getZ()));
    }

    /**
     * 获取玩家延迟
     *
     * @return 延迟(ms)
     */
    public int getPing() {
        return this.player.getPing();
    }

    /**
     * 获取玩家等级
     *
     * @return 等级
     */
    public int getLevel() {
        this.player.getLocation();
        return this.player.getLevel();
    }

    /**
     * 设置玩家等级
     *
     * @param level 等级
     */
    public void setLevel(int level) {
        this.player.setLevel(level);
    }

    /**
     * 获取经验值
     * 使玩家当前经验值达到下一个级别。这是一个百分比值。0 表示“没有进度”，1 表示“下一级”。
     *
     * @return 经验
     */
    public float getExp() {
        return this.player.getExp();
    }

    /**
     * 设置经验值
     * 使玩家当前经验值达到下一个级别。这是一个百分比值。0 表示“没有进度”，1 表示“下一级”。
     *
     * @param exp 经验
     */
    public void setExp(float exp) {
        this.player.setExp(exp);
    }

    /**
     * 获取飞行速度
     *
     * @return 飞行速度
     */
    public float getFlySpeed() {
        return this.player.getFlySpeed();
    }

    /**
     * 设置飞行速度
     *
     * @param speed 飞行速度
     */
    public void getFlySpeed(float speed) {
        this.player.setFlySpeed(speed);
    }

    /**
     * 获取冷却时间
     *
     * @return 当前冷却时间持续的刻度数
     */
    public float getCooldownPeriod() {
        return this.player.getCooldownPeriod();
    }

    /**
     * 获取玩家时间
     *
     * @return 玩家的当前时间
     */
    public float getPlayerTime() {
        return this.player.getPlayerTime();
    }

    /**
     * 获取玩家时间
     * 在玩家的客户端上设置当前时间。当相对值为真时，玩家的时间将与指定的偏移量的世界时间保持同步。使用非相对时间时，玩家的时间将固定在指定的时间参数。由呼叫者继续更新玩家的时间。要将玩家时间恢复正常，请使用 resetPlayerTime（）。
     *
     * @param time 当前玩家的感知时间或玩家的时间与服务器时间的偏移量。
     * @param relative 如果为 true，则玩家时间相对于其世界时间保持不变。
     */
    public void setPlayerTime(int time, boolean relative) {
        this.player.setPlayerTime(time, relative);
    }
}
