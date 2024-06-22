package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;

import java.util.UUID;

public class Entity {
    private final org.bukkit.entity.Entity entity;

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
     * @return 是否成功
     */
    public boolean addPassenger(Entity entity) {
        return this.entity.addPassenger(Bukkit.getServer().getEntity(UUID.fromString(entity.getUUID())));
    }

    /**
     * 添加记分板标签
     *
     * @param tag 标签
     * @return 是否成功
     */
    public boolean addScoreboardTag(String tag) {
        return this.entity.addScoreboardTag(tag);
    }
}
