package ry.skywars.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import ry.skywars.SkyWars;
import ry.skywars.config.Configuration;
import ry.skywars.items.ItemList;
import ry.skywars.service.ArenaServiceImpl;
import ry.skywars.utils.HelperImpl;

import static org.bukkit.event.EventPriority.*;
import static ry.skywars.SkyWars.inventory;

public class SelectArenas implements Listener {

    private final HelperImpl helper = new HelperImpl();
    private ArenaServiceImpl arenaService = new ArenaServiceImpl();

    @EventHandler(priority = LOWEST)
    public void selectArenas(InventoryInteractEvent event)
    {
        if (event.getWhoClicked() instanceof Player)
        {
            event.setResult(Event.Result.DENY);
        }
    }

    @EventHandler(priority = NORMAL)
    public void selectArena(InventoryClickEvent event)
    {
        Player player = (Player) event.getView().getPlayer();
        if (event.getClickedInventory().equals(inventory))
        {
            selectSlot(event.getSlot(),player);
            helper.runScheduler(SkyWars.instance,player);
        }
    }

    @EventHandler(priority = HIGHEST)
    public void canselInteraction(InventoryClickEvent event)
    {
        if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()
                && event.getClickedInventory() == inventory)
        {
         event.setCancelled(true);
        }
    }

    @EventHandler
    public void openInventory(InventoryOpenEvent event)
    {
        if (event.getInventory().equals(inventory))
        {
            setItemSArenas();
        }
    }

    @EventHandler
    public void closeInventory(InventoryCloseEvent event)
    {
        if (event.getInventory().equals(inventory))
        {
            setItemCloseInv();
        }

    }

    private void selectSlot(int slot,Player player)
    {
        switch (slot) {
            case 0:{
                helper.teleport(player, Configuration.get().getDouble("World.Arena1.posX"),
                        Configuration.get().getDouble("World.Arena1.posY"), Configuration.get().getDouble("World.Arena1.posZ"));
                arenaService.addPlayerOnArena(player);
                System.out.println(ArenaServiceImpl.arena1.size());
                break;
            }
            case 1:{
                helper.teleport(player, Configuration.get().getDouble("World.Arena2.posX"),
                        Configuration.get().getDouble("World.Arena2.posY"), Configuration.get().getDouble("World.Arena2.posZ"));
                arenaService.addPlayerOnArena(player);
                System.out.println(ArenaServiceImpl.arena1.size());
                break;
            }
        }
        helper.sendActionBar(player,"Вы были телепортированы на арену " + slot);
        player.getInventory().addItem(ItemList.selectorCommand());
    }
    private void setItemSArenas()
    {

        inventory.setItem(0, ItemList.arena1());
        inventory.setItem(1, ItemList.arena2());
    }

    private void setItemCloseInv()
    {
        inventory.setItem(0 , new ItemStack(Material.AIR));
        inventory.setItem(1 , new ItemStack(Material.AIR));
    }

}
