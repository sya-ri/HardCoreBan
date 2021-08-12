package dev.s7a.HardCoreBan;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

/**
 * プラグインのメインクラス
 */
@SuppressWarnings("unused")
public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(this, this);
    }

    @EventHandler
    public void on(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Server server = Bukkit.getServer();
        BanList banList = server.getBanList(BanList.Type.NAME);
        String playerName = player.getName();
        String deathMessage = event.getDeathMessage();
        banList.addBan(playerName, deathMessage, null, null);
        player.kickPlayer(deathMessage);
    }
}
