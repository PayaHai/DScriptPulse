package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList.onCommand;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Command {
    private final Plugin plugins;

    /**
     * 构造
     */
    public Command(Plugin plugin) {
        this.plugins = plugin;
    }

    /**
     * 注册命令
     */
    public void registerCommand(String cmd, String description, Consumer<onCommand> callback) {
        LifecycleEventManager<Plugin> manager = this.plugins.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register(cmd, description, new FunCommand(callback));
        });
    }
}


class FunCommand implements BasicCommand {
    private final Consumer<onCommand> callback;

    /**
     * 构造
     *
     * @param callback 回调
     */
    public FunCommand(Consumer<onCommand> callback) {
        this.callback = callback;
    }

    @Override
    public void execute(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        this.callback.accept(new onCommand(stack, args));
    }
}