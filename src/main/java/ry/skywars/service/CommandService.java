package ry.skywars.service;

import ry.skywars.model.Arena;
import ry.skywars.model.Commands;

import java.util.List;

public interface CommandService {

    List<Commands> findAllCommands();
    void createCommand();
    void deleteCommand(int id);
    Commands findCommandById(int id);

    List<Commands> findCommandArenaById(int id); // поиск команды по id арены
}
