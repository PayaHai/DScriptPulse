package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * 位置对象
 */
public class Pos {
    private final Location loction;

    /**
     * 构造
     *
     * @param loction 位置对象
     */
    public Pos(Location loction) {
        this.loction = loction;
    }

    /**
     * 获取 X 坐标
     *
     * @return X 坐标
     */
    public double getX() {
        return this.loction.getX();
    }

    /**
     * 获取 Y 坐标
     *
     * @return Y 坐标
     */
    public double getY() {
        return this.loction.getY();
    }

    /**
     * 获取 Z 坐标
     *
     * @return Z 坐标
     */
    public double getZ() {
        return this.loction.getZ();
    }

    /**
     * 获取世界
     *
     * @return 世界对象
     */
    public World getWorld() {
        return new World(this.loction.getWorld().getName());
    }
}
