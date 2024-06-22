package cn.dzdstudo.mc.DScriptPulse;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Listen;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public final class DScriptPulse extends JavaPlugin {
    // 日志对象
    Logger logger = getLogger();

    @Override
    public void onEnable() {
        logger.info("DScriptPulse 开始加载...");

        // 监听事件
        Bukkit.getPluginManager().registerEvents(new Listen(), this);

        // 获取文件列表
        List<File> files = FileUtils.listFiles("plugins/");

        // 筛选出.sar文件
        Stream<File> scriptsPlugins = files.stream().filter(file -> file.getName().endsWith(".sar"));

        // 解压并获取 plugin.yml 内容
        //FileUtils.clearDirectory(getDataFolder() + "/scriptsRuntime");
        FileUtils.newFolder(getDataFolder() + "/scriptsRuntime/openhab-conf");
        Stream<YamlConfiguration> plugins = scriptsPlugins.map(file -> {
            String pluginName = file.getName().replace(".sar", "");
            String pluginPath = "plugins/" + file.getName();

            // 解压
            //FileUtils.unzip(pluginPath, getDataFolder() + "/scriptsRuntime/" + pluginName);

            File pluginYml = new File(getDataFolder() + "/scriptsRuntime/" + pluginName + "/plugin.yml");

            // 读取 plugin.yml
            if(pluginYml.exists()) {
                // 加载 plugin.yml
                YamlConfiguration pluginInfo = YamlConfiguration.loadConfiguration(pluginYml);
                return pluginInfo;
            }
            else {
                // 插件文件损坏
                logger.warning("插件 " + pluginName + " 的 plugin.yml 文件不存在。");
                FileUtils.deleteFile(getDataFolder() + "/scriptsRuntime/" + pluginName);
                return null;
            }
        });

        // 加载插件
        plugins.forEach(pluginInfo -> {
            if(pluginInfo != null) {
                String pluginName = pluginInfo.getString("name");
                String pluginMain = pluginInfo.getString("main");
                String pluginVersion = pluginInfo.getString("version");
                String pluginAuthor = pluginInfo.getString("author");

                logger.info("插件 " + pluginName + " 开始加载...");

                try {
                    ScriptingEngine.load(getDataFolder() + "/scriptsRuntime/" + pluginName, pluginInfo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void onDisable() {
    }
}
