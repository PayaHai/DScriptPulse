package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * 日志输出类
 */
public class Logger {
    // 日志对象
    private final java.util.logging.Logger logger;

    // 日志头
    private final String title;

    /**
     * 构造
     * @param logger 日志对象
     * @param title 日志头
     */
    public Logger(java.util.logging.Logger logger, String title) {
        this.logger = logger;
        this.title = title;
    }

    /**
     * 输出信息
     * @param msg 文本
     */
    public void info(String msg) {
        this.logger.info("[" + title + "] " + msg);
    }

    /**
     * 输出警告
     * @param msg 文本
     */
    public void warn(String msg) {
        this.logger.warning("[" + title + "] " + msg);
    }

    /**
     * 输出严重错误
     * @param msg 文本
     */
    public void error(String msg) {
        this.logger.severe("[" + title + "] " + msg);
    }
}
