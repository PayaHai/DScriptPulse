package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;

/**
 * 世界对象
 */
public class World {
    private final org.bukkit.World world;

    /**
     * 构造
     *
     * @param name 世界名称
     */
    public World(String name) {
        this.world = Bukkit.getWorld(name);
    }

    /**
     * 获取世界名称
     *
     * @return 世界名称
     */
    public String getName() {
        return this.world.getName();
    }

    /**
     * 获取种子
     *
     * @return 种子
     */
    public long getSeed() {
        return this.world.getSeed();
    }

    /**
     * 获取最大高度
     *
     * @return 最大高度
     */
    public int getMaxHeight() {
        return this.world.getMaxHeight();
    }

    /**
     * 获取海平面
     *
     * @return 海平面
     */
    public int getSeaLevel() {
        return this.world.getSeaLevel();
    }
}
