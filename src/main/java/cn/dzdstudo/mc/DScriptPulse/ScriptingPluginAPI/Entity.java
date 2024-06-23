package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.UUID;

public class Entity {
    private org.bukkit.entity.Entity entity;

    /**
     * 构造
     *
     * @param entity 实体
     */
    public Entity(org.bukkit.entity.Entity entity) {
        this.entity = entity;
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getName() {
        return this.entity.getName();
    }

    /**
     * 获取 UUID
     *
     * @return UUID
     */
    public String getUUID() {
        return this.entity.getUniqueId().toString();
    }

    /**
     * 获取自定义名称
     * 如果没有名称，则此方法 将返回 null。
     * 这个值对玩家没有影响，他们总是会使用他们的 名字。
     *
     * @return 自定义名称
     */
    public String getCustomName() {
        return this.entity.getCustomName();
    }

    /**
     * 设置自定义名称
     * 这个名字将在死亡中使用 消息，并可以作为 MOB 上的铭牌发送给客户端。
     * 将名称设置为 null 或空字符串将清除它。
     *
     * @param name 自定义名称
     */
    public void setCustomName(String name) {
        this.entity.setCustomName(name);
    }

    /**
     * 获取所在坐标
     */
    public Pos getPos() {
        return new Pos(this.entity.getLocation());
    }

    /**
     * 添加乘客
     *
     * @param entity 乘客
     * @return 是否成功
     */
    public boolean addPassenger(Entity entity) {
        return this.entity.addPassenger(Bukkit.getServer().getEntity(UUID.fromString(entity.getUUID())));
    }

    /**
     * 驱逐乘客
     *
     * @return 是否成功
     */
    public boolean eject() {
        return this.entity.eject();
    }

    /**
     * 获取实体所在的车辆
     *
     * @return 车辆
     */
    public Entity getVehicle() {
        return new Entity(this.entity.getVehicle());
    }

    /**
     * 添加标记
     *
     * @param tag 标记
     * @return 是否成功
     */
    public boolean addScoreboardTag(String tag) {
        return this.entity.addScoreboardTag(tag);
    }

    /**
     * 删除标记
     *
     * @param tag 标记
     * @return 是否成功
     */
    public boolean removeScoreboardTag(String tag) {
        return this.entity.removeScoreboardTag(tag);
    }

    /**
     * 返回此实体坠落的距离
     *
     * @return 坠落距离
     */
    public double getFallDistance() {
        return this.entity.getFallDistance();
    }

    /**
     * 获取实体的类型
     *
     * @return 实体类型
     */
    public String getType() {
        return this.entity.getType().toString();
    }

    /**
     * 获取此实体的当前速度
     *
     * @return 速度
     */
    public double getVelocity() {
        return this.entity.getVelocity().length();
    }

    /**
     * 获取实体的宽度
     *
     * @return 宽度
     */
    public double getWidth() {
        return this.entity.getWidth();
    }

    /**
     * 获取实体的高度
     */
    public double getHeight() {
        return this.entity.getHeight();
    }

    /**
     * 获取此实体所在的当前世界
     *
     * @return 世界
     */
    public World getWorld() {
        return new World(this.entity.getWorld().getName());
    }

    /**
     * 返回重力是否适用于此实体
     *
     * @return 是否有重力
     */
    public boolean hasGravity() {
        return this.entity.hasGravity();
    }

    /**
     * 返回实体已标记为要删除
     *
     * @return 是否要删除
     */
    public boolean isDead() {
        return this.entity.isDead();
    }

    /**
     * 检查车辆是否有乘客
     *
     * @return 是否有乘客
     */
    public boolean isEmpty() {
        return this.entity.isEmpty();
    }

    /**
     * 获取实体是否完全冻结
     *
     * @return 是否冻结
     */
    public boolean isFrozen() {
        return this.entity.isFrozen();
    }

    /**
     * 获取实体是否发光
     *
     * @return 是否发光
     */
    public boolean isGlowing() {
        return this.entity.isGlowing();
    }

    /**
     * 返回此实体是否在车辆内
     *
     * @return 是否在车辆内
     */
    public boolean isInsideVehicle() {
        return this.entity.isInsideVehicle();
    }

    /**
     * 获取实体是否无懈可击
     *
     * @return 是否无懈可击
     */
    public boolean isInvulnerable() {
        return this.entity.isInvulnerable();
    }

    /**
     * 获取实体是否位于水中
     *
     * @return 是否位于水中
     */
    public boolean isInWater() {
        return this.entity.isInWater();
    }

    /**
     * 检查此实体是否已在世界中生成
     *
     * @return 是否生成
     */
    public boolean isInWorld() {
        return this.entity.isInWorld();
    }

    /**
     * 实体是否被保留
     *
     * @return 是否保留
     */
    public boolean isPersistent() {
        return this.entity.isPersistent();
    }

    /**
     * 获取实体是否静默
     *
     * @return 是否静默
     */
    public boolean isSilent() {
        return this.entity.isSilent();
    }

    /**
     * 如果实体已死亡
     *
     * @return 是否死亡
     */
    public boolean isValid() {
        return this.entity.isValid();
    }

    /**
     * 获取此实体在默认情况下是否可见
     *
     * @return 是否可见
     */
    public boolean isVisibleByDefault() {
        return this.entity.isVisibleByDefault();
    }

    /**
     * 获取实体是否有视觉着火（它总是着火）
     *
     * @return 是否着火
     */
    public boolean isVisualFire() {
        return this.entity.isVisualFire();
    }

    /**
     * 标记实体的移除
     */
    public void remove() {
        this.entity.remove();
    }

    /**
     * 设置是否显示生物的名称
     *
     * @param show 是否显示
     */
    public void setCustomNameVisible(boolean show) {
        this.entity.setCustomNameVisible(show);
    }

    /**
     * 设置重力是否应用于此实体
     *
     * @param gravity 是否有重力
     */
    public void setGravity(boolean gravity) {
        this.entity.setGravity(gravity);
    }

    /**
     * 设置实体是否无懈可击
     *
     * @param flag 是否无懈可击
     */
    public void setInvulnerable(boolean flag) {
        this.entity.setInvulnerable(flag);
    }

    /**
     * 设置实体是否持久化
     *
     * @param persistent 是否持久化
     */
    public void setPersistent(boolean persistent) {
        this.entity.setPersistent(persistent);
    }

    /**
     * 设置实体旋转
     * 请注意，如果实体受到 AI 的影响，它可能会覆盖此轮换。
     *
     * @param yaw   偏航角度
     * @param pitch 俯仰角度
     */
    public void setRotation(float yaw, float pitch) {
        this.entity.setRotation(yaw, pitch);
    }

    /**
     * 设置实体是否静默
     *
     * @param flag 是否静默
     */
    public void setSilent(boolean flag) {
        this.entity.setSilent(flag);
    }

    /**
     * 设置此实体生存的刻度数量
     * 这相当于实体中的“年龄”。不能少于一个刻度。
     *
     * @param ticks 刻度
     */
    public void setTicksLived(int ticks) {
        this.entity.setTicksLived(ticks);
    }

    /**
     * 设置此实体的速度（以米/刻度为单位）
     *
     * @param velocity 速度
     */
    public void setVelocity(double velocity) {
        this.entity.setVelocity(new Vector(velocity, velocity, velocity));
    }

    /**
     * 设置此实体在默认情况下是否可见
     *
     * @param visible 是否可见
     */
    public void setVisibleByDefault(boolean visible) {
        this.entity.setVisibleByDefault(visible);
    }

    /**
     * 设置实体是否具有视觉着火状态（它总是看起来着火了）
     *
     * @param visualFire 是否着火
     */
    public void setVisualFire(boolean visualFire) {
        this.entity.setVisualFire(visualFire);
    }

    /**
     * 将此实体传送到给定位置
     *
     * @param pos 位置
     * @return 是否传送成功
     */
    public boolean teleport(Pos pos) {
        return this.entity.teleport(new Location(Bukkit.getWorld(pos.getWorld().getName()), pos.getX(), pos.getY(), pos.getZ()));
    }
}
