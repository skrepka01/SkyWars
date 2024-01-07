package ry.skywars.model;

import org.bukkit.entity.Player;

import java.util.List;

public class Arena {

    private long id;
    private String name;
    private List<Commands> commands;
    private List<Player> players;

    // todo : тут не дописал переменную boolean isStart = false;

    public Arena(){}

    public Arena(long id, String name,List<Commands> commands){
        this.id = id;
        this.name = name;
        this.commands = commands;
    }

    public Arena(long id, String name, List<Commands> commands, List<Player> players) {
        this.id = id;
        this.name = name;
        this.commands = commands;
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commands> getCommands() {
        return commands;
    }

    public void setCommands(List<Commands> commands) {
        this.commands = commands;
    }
}
