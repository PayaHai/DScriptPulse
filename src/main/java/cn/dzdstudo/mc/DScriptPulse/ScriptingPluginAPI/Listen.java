package cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI;

import cn.dzdstudo.mc.DScriptPulse.ScriptingPluginAPI.EventList.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Listen implements Listener {
    /**
     * 玩家登录服务器
     * @param callback 回调
     */
    public void onPreJoin(Consumer<onPreJoin> callback) {
        onPreJoinEvents.add(callback);
    }
    public static List<Consumer<onPreJoin>> onPreJoinEvents = new ArrayList<>();
    @EventHandler
    public void AsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent en) {
        onPreJoinEvents.forEach(e -> {
            e.accept(new onPreJoin(en));
        });
    }

    /**
     * 玩家进入服务器
     * @param callback 回调
     */
    public void onJoin(Consumer<onJoin> callback) {
        onJoinEvents.add(callback);
    }
    public static List<Consumer<onJoin>> onJoinEvents = new ArrayList<>();
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent en) {
        onJoinEvents.forEach(e -> {
            e.accept(new onJoin(en));
        });
    }

    /**
     * 玩家离开服务器
     * @param callback 回调
     */
    public void onQuit(Consumer<onQuit> callback) {
        onQuitEvents.add(callback);
    }
    public static List<Consumer<onQuit>> onQuitEvents = new ArrayList<>();
    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent en) {
        onQuitEvents.forEach(e -> {
            e.accept(new onQuit(en));
        });
    }

    /**
     * 玩家重生
     * @param callback 回调
     */
    public void onRespawn(Consumer<onRespawn> callback) {
        onRespawnEvents.add(callback);
    }
    public static List<Consumer<onRespawn>> onRespawnEvents = new ArrayList<>();
    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent en) {
        onRespawnEvents.forEach(e -> {
            e.accept(new onRespawn(en));
        });
    }

    /**
     * 玩家死亡
     * @param callback 回调
     */
    public void onPlayerDie(Consumer<onPlayerDie> callback) {
        onPlayerDieEvents.add(callback);
    }
    public static List<Consumer<onPlayerDie>> onPlayerDieEvents = new ArrayList<>();
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent en) {
        onPlayerDieEvents.forEach(e -> {
            e.accept(new onPlayerDie(en));
        });
    }
}
