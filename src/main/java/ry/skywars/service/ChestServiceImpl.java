package ry.skywars.service;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ChestServiceImpl implements ChestService{

    //todo: создать список ,который отвечает за предметы

    @Override
    public void addItemInChest() {
        // todo : добовление предмета из private метода в сундук
    }

    @Override
    public void setPositionChest() {
        //todo : установка позиции спавна сундука
    }

    @Override
    public void spawnChest() {
        // todo : указать position спавна сундука
    }

    private List<?> addItemList()
    {
        //todo : заполнение списка,который должен быть применён в addItemChest
        return new ArrayList<>();
    }

    //todo : прописать спавн сундуков в SkyWars.yml
}
