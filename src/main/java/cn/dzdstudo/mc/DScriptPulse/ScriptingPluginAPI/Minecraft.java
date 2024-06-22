package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;

public class Minecraft {
    /**
     * 获取玩家对象
     * @param player 玩家名称/Uuid
     */
    public static cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player getPlayer(String player) {
        return new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player(org.bukkit.Bukkit.getPlayer(player));
    }

    /**
     * 获取世界列表
     *
     * @return 世界列表
     */
    public static List<cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World> getWeather() {
        List<World> worlds = Bukkit.getServer().getWorlds();
        List<cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World> worldList = new java.util.ArrayList<>();
        for(World world : worlds) {
            worldList.add(new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.World(world.getName()));
        }

        return worldList;
    }
}
