package ry.skywars.service;

import org.bukkit.entity.Player;
import ry.skywars.model.Arena;

import java.util.List;

public interface ArenaService {

    List<Arena> findAllArenas();
    void createArena();
    void deleteArena(int id);
    Arena findArenaById(int id);

    void deleteAllArenas();

    List<Player> findListPlayer(int id);

    void addPlayerOnArena(Player player);

    int findPlayerOnArena();

}
