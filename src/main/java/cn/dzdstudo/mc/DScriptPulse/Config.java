package cn.dzdstudo.mc.DScriptPulse;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.logging.Logger;

public class Config {
    // 插件对象
    static Plugin plugin = Bukkit.getPluginManager().getPlugin("DScriptPulse");

    // 日志对象
    static Logger logger = plugin.getLogger();

    // 语言文件
    public static YamlConfiguration config;

    /**
     * 加载配置文件
     */
    public static void load() {
        try {
            // 判断文件是否存在
            if(!new File(plugin.getDataFolder(), "Config.yml").exists()) {
                logger.info("找不到配置文件, 正在创建。");
                plugin.saveResource("Config.yml", false);
            }

            config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "Config.yml"));
        }
        catch (Exception e) {
            logger.warning("配置文件加载失败:" + e);
            return;
        }

        logger.info("配置文件加载成功。");
    }
}