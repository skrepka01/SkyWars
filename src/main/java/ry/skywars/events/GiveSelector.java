package ry.skywars.events;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ry.skywars.items.ItemList;

public class GiveSelector implements Listener {

    @EventHandler
    public void giveSelector(PlayerJoinEvent event)
    {

        Player player = event.getPlayer();
        val getInventory = player.getInventory();
        getInventory.addItem(ItemList.selectorCommand());
    }
}
