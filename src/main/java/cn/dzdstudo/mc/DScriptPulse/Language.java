package cn.dzdstudo.mc.DScriptPulse;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.logging.Logger;

public class Language {
    // 插件对象
    static Plugin plugin = Bukkit.getPluginManager().getPlugin("DScriptPulse");

    // 日志对象
    static Logger logger = plugin.getLogger();

    // 语言文件
    public static YamlConfiguration language;

    /**
     * 加载语言文件
     *
     * @param lang 语言
     */
    public static void load(String lang) {
        try {
            // 判断文件是否存在
            if(!new File(plugin.getDataFolder(), "lang/" + lang + ".yml").exists()) {
                logger.info("找不到 lang/" + lang + ".yml 文件，正在创建默认语言文件[lang/" + lang + ".yml]。");
                plugin.saveResource("lang/zh_CN.yml", false);
                lang = "zh_cn";
            }

            language = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "lang/" + lang + ".yml"));
        }
        catch (Exception e) {
            logger.warning("语言文件加载失败:" + e);
            return;
        }

        logger.info("语言文件[lang/" + lang + ".yml]加载成功");
    }

    /**
     * 翻译
     *
     * @param key 键
     * @param args 参数
     * @return 翻译结果
     */
    public static String translate(String key, Object... args) {
        // 语言文件未加载
        if(language == null) {
            logger.warning("语言文件未加载，无法翻译" + key);
            return key;
        }

        // 获取键值
        String value = language.getString(key);
        if(value == null) {
            return key;
        }

        // 替换参数
        for(int i = 0; i < args.length; i++) {
            value = value.replace("{" + i + "}", args[i].toString());
        }

        return value;
    }
}