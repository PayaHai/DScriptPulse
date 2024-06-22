package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;

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
     * 获取 UUID
     *
     * @return UUID
     */
    public String getUUID() {
        return this.entity.getUniqueId().toString();
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
}
