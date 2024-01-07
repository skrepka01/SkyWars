package ry.skywars.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import ry.skywars.events.*;
import ry.skywars.service.ArenaServiceImpl;

public class HelperImpl implements Helper{
    @Override
    public void registerEvents(Plugin plugin) {
        fastReg(new GiveSelector(),plugin);
        fastReg(new OpenSelectorArena(),plugin);
        fastReg(new SelectArenas(),plugin);
        fastReg(new SelectCommand(),plugin);
    }

    @Override
    public void teleport(Player player,double pos1,double pos2,double pos3) {
        player.teleport(new Location(player.getWorld(), pos1,pos2,pos3));
    }

    @Override
    public void sendActionBar(Player player, String msg) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg));
    }

    @Override
    public void runScheduler(Plugin plugin,Player player) {
        int needPlayer = 8;
        int playerArena = needPlayer - ArenaServiceImpl.arena1.size();
        Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                sendActionBar(player,"Игра начнётся как наберётся <<" + playerArena + ">> участников");
            }
        },0, 300);
    }

    private void fastReg(Listener listener,Plugin plugin){
        Bukkit.getPluginManager().registerEvents(listener,plugin);
    }


}
