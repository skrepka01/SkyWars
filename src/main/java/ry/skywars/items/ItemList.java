package ry.skywars.items;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ry.skywars.model.Arena;
import ry.skywars.service.ArenaServiceImpl;
import ry.skywars.service.CommandServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemList {

    private static List<String> lore = new ArrayList<>();
    private final static ArenaServiceImpl arenaService = new ArenaServiceImpl();

    public static ItemStack arena1()
    {
        ItemStack itemStack = new ItemStack(Material.WOOL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Арена 1");
        lore.add("Название арены: " + ArenaServiceImpl.arenaList.get(0).getName());
        lore.add("Общее количество команд: " + (int) CommandServiceImpl.commands.stream().filter(com -> com.getId() == 0).count());
        lore.add("Количество игроков на арене: " + ArenaServiceImpl.arena1.size());
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        lore.clear();
        return itemStack;
    }

    public static ItemStack arena2()
    {
        ItemStack itemStack = new ItemStack(Material.WOOL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Арена 1");
        lore.add("Название арены: " + ArenaServiceImpl.arenaList.get(0).getName());
        lore.add("Общее количество команд: " + (int) CommandServiceImpl.commands.stream().filter(com -> com.getId() == 0).count());
        lore.add("Количество игроков на арене: " + ArenaServiceImpl.arena1.size());
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        lore.clear();
        return itemStack;
    }

    public static ItemStack selector()
    {
        return standardSet(Material.EMERALD,"Выбор арены");
    }

    public static ItemStack selectorCommand()
    {
        return standardSet(Material.EMERALD, "Выбор команды");
    }

    public static ItemStack command1()
    {

        return standardSet(Material.IRON_INGOT,"Железные люди");
    }

    public static ItemStack command2()
    {
        return standardSet(Material.DIAMOND,"Алмазные крохи");
    }

    private static ItemStack standardSet(Material material,String name)
    {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
