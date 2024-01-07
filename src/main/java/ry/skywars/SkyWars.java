package ry.skywars;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import ry.skywars.config.Configuration;
import ry.skywars.items.ItemList;
import ry.skywars.service.ArenaServiceImpl;
import ry.skywars.service.CommandServiceImpl;
import ry.skywars.utils.HelperImpl;

public final class SkyWars extends JavaPlugin {

    private final HelperImpl helper = new HelperImpl();
    private ArenaServiceImpl arenaService = new ArenaServiceImpl();

    public static SkyWars instance;
    public static Inventory inventory ; // инвентарь всех арен
    public static Inventory inventoryCommand;
    private final CommandServiceImpl commandService = new CommandServiceImpl();
    @Override
    public void onEnable() {
        instance = this;
        helper.registerEvents(this);
        Configuration.loadConfig(this);
        if (CommandServiceImpl.commands.isEmpty())
        {
            commandService.createCommand();
        }
        if(ArenaServiceImpl.arenaList.isEmpty())
        {
            arenaService.createArena();
        }
        inventory = Bukkit.createInventory(null,9);
        inventoryCommand = Bukkit.createInventory(null,9);
        System.out.println("sssss");
    }

    @Override
    public void onDisable() {
        arenaService.deleteAllArenas();
    }
}
