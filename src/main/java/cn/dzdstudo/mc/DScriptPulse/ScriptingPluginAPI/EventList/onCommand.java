package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Entity;
import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.Player;
import io.papermc.paper.command.brigadier.CommandSourceStack;

import java.util.Objects;
import java.util.UUID;

public class onCommand {
    private final CommandSourceStack stack;
    private final String[] args;

    /**
     * 构造
     *
     * @param stack 命令源
     * @param args 参数
     */
    public onCommand(CommandSourceStack stack, String[] args) {
        this.stack = stack;
        this.args = args;
    }

    /**
     * 获取参数
     *
     * @return 参数
     */
    public String[] getArgs() {
        return this.args;
    }

    /**
     * 获取执行者名称
     *
     * @return 名称
     */
    public String getName() {
        return this.stack.getSender().getName();
    }

    /**
     * 获取执行玩家对象
     *
     * @return 玩家对象
     */
    public Player getPlayer() {
        org.bukkit.entity.Player pl = this.stack.getSender().getServer().getPlayer(this.stack.getSender().getName());

        // 是否为玩家
        if (pl == null) {
            return null;
        } else {
            return new Player(pl);
        }
    }
}
