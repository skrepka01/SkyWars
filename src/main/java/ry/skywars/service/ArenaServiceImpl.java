package ry.skywars.service;

import org.bukkit.entity.Player;
import ry.skywars.model.Arena;
import ry.skywars.utils.HelperImpl;

import java.util.ArrayList;
import java.util.List;

public class ArenaServiceImpl implements ArenaService{

    public static List<Arena> arenaList = new ArrayList<>();
    private final CommandServiceImpl commandService = new CommandServiceImpl();

    public static List<Player> arena1 = new ArrayList<>();

    private HelperImpl helper = new HelperImpl();


    @Override
    public List<Arena> findAllArenas() {
        return arenaList;
    }

    @Override
    public void createArena() {
        arenaList.add(new Arena(0,"Кактус",commandService.findCommandArenaById(0),arena1));
    }

    @Override
    public void deleteArena(int id) {
        arenaList.remove(id);
    }

    @Override
    public Arena findArenaById(int id) {
        return arenaList.get(id);
    }

    @Override
    public void deleteAllArenas() {
        arenaList.clear();
    }



    @Override
    public List<Player> findListPlayer(int id) {
        return arenaList.get(id).getPlayers();
    }

    @Override
    public void addPlayerOnArena(Player player) {
        arena1.add(player);
        if (arena1.size() == 8)
        {
            helper.teleport(player,1000,1000,1000);
            helper.sendActionBar(player,"Игра началась");
        }
    }

    @Override
    public int findPlayerOnArena() {
      return arena1.size();
    }
}
