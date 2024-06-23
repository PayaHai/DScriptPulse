package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.graalvm.polyglot.HostAccess;

import java.util.List;

public class Minecraft {
    /**
     * 获取玩家对象
     * @param player 玩家名称/Uuid
     */
    @HostAccess.Export
    public cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player getPlayer(String player) {
        return new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player(org.bukkit.Bukkit.getPlayer(player));
    }

    /**
     * 获取世界列表
     *
     * @return 世界列表
     */
    public List<cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World> getWeather() {
        List<World> worlds = Bukkit.getServer().getWorlds();
        List<cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World> worldList = new java.util.ArrayList<>();
        for(World world : worlds) {
            worldList.add(new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World(world.getName()));
        }

        return worldList;
    }

    /**
     * 获取世界对象
     *
     * @param worldName 世界名称
     * @return 世界对象
     */
    public cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World getWorld(String worldName) {
        return new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World(worldName);
    }

    /**
     * 获取坐标对象
     *
     * @param world 世界对象
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     *
     * @return 坐标对象
     */
    public cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Pos getPos(cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World world, double x, double y, double z) {
        return new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Pos(new Location(Bukkit.getWorld(world.getName()), x, y, z));
    }

    /**
     * 获取普通表单对象
     *
     * @return 表单对象
     */
    public cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.SimpleForm getSimpleForm() {
        // 前置是否安装
        PluginManager pluginManager = Bukkit.getPluginManager();
        boolean isGeyserLoaded = pluginManager.isPluginEnabled("Geyser-Spigot");
        boolean isFloodgateLoaded = pluginManager.isPluginEnabled("Floodgate");
        if(isGeyserLoaded && isFloodgateLoaded) {
            return new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.SimpleForm();
        }
        return null;
    }
}
