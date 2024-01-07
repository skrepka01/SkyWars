package ry.skywars.service;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import ry.skywars.model.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandServiceImpl implements CommandService{

    public static List<Commands> commands = new ArrayList<>();

    @Override
    public List<Commands> findAllCommands() {
        return commands;
    }

    @Override
    public void createCommand() {
        commands.add(new Commands(0,0,"Кит", Material.WOOL));
        commands.add(new Commands(0,0,"Не кит", Material.WOOL));
        commands.add(new Commands(0,0,"Супер-стар", Material.WOOL));
        commands.add(new Commands(0,0,"Не супер-стар", Material.WOOL));
    }

    @Override
    public void deleteCommand(int id) {
        commands.remove(id);
    }

    @Override
    public Commands findCommandById(int id) {
        return commands.get(id);
    }

    @Override
    public List<Commands> findCommandArenaById(int id) {
        return commands.stream()
                .filter(command -> command.getId() == id)
                .collect(Collectors.toList());
    }
}
