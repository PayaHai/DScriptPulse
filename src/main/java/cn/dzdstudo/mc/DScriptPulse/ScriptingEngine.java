package cn.dzdstudo.mc.DScriptPulse;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Command;
import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Listen;
import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Minecraft;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class ScriptingEngine extends JavaPlugin {
    static Plugin plugin = Bukkit.getPluginManager().getPlugin("DScriptPulse");
    static Logger logger = plugin.getLogger();

    public static void load(String path, YamlConfiguration pluginInfo) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException, IOException {
        Path scriptPath = Paths.get(System.getProperty("user.dir") + "/" + path);

        String pluginName = pluginInfo.getString("name");
        String pluginMain = pluginInfo.getString("main");
        String pluginVersion = pluginInfo.getString("version");

        logger.info("正在加载脚本插件" + pluginName + "。");

        Context context = Context.newBuilder("js")
                //.allowExperimentalOptions(true)
                //.allowHostAccess(HostAccess.ALL)
                //.allowHostClassLookup(className -> true)
                .option("js.commonjs-require", "true")
                .option("js.commonjs-require-cwd", scriptPath.toString())
                .option("engine.WarnInterpreterOnly", "false")
                .allowAllAccess(true)
                .build();

        // 注入 API
        // 日志
        context.getBindings("js").putMember("logger", new cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Logger(logger, pluginName));
        // Minecraft
        context.getBindings("js").putMember("minecraft", new Minecraft());
        // 监听事件
        context.getBindings("js").putMember("listen", new Listen());
        // 命令系统
        context.getBindings("js").putMember("command", new Command(plugin));

        // 执行主 JavaScript 文件
        try {
            // 读取脚本
            Source source = Source.newBuilder("js", new File(scriptPath.toFile() + "/" + pluginMain)).build();
            context.eval(source);
        } catch (Exception e) {
            logger.severe("脚本插件" + pluginName + "加载出错:");
            logger.severe("异常信息: " + e.getMessage());
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            StackTraceElement firstElement = stackTraceElements[0];
            logger.severe("异常发生在: " + firstElement.getClassName() + "." + firstElement.getMethodName()
                    + "() 位于 " + firstElement.getLineNumber() + " 行。");
        }

        logger.info("脚本插件" + pluginName + "加载完成。");
    }
}