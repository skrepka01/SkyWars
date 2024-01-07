package ry.skywars.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface Helper {

    void registerEvents(Plugin plugin);

    void teleport(Player player,double pos1,double pos2,double pos3);

    void sendActionBar(Player player, String msg);

    void runScheduler(Plugin plugin,Player player);
}
