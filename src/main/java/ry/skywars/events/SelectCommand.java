package ry.skywars.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import ry.skywars.items.ItemList;

import static ry.skywars.SkyWars.inventoryCommand;

public class SelectCommand implements Listener {

    @EventHandler
    public void openInventory(InventoryOpenEvent event)
    {
        if (event.getInventory().equals(inventoryCommand))
        {
            setItemSCommand();
        }
    }

    @EventHandler
    public void closeInventory(InventoryCloseEvent event)
    {
        if (event.getInventory().equals(inventoryCommand))
        {
            setItemCloseInv();
        }
    }

    private void setItemSCommand()
    {
        inventoryCommand.setItem(0, ItemList.command1());
        inventoryCommand.setItem(1, ItemList.command2());
    }
    private void setItemCloseInv()
    {
        inventoryCommand.setItem(0,new ItemStack(Material.AIR));
        inventoryCommand.setItem(1,new ItemStack(Material.AIR));
    }
}
