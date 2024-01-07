package ry.skywars.events;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ry.skywars.SkyWars;
import ry.skywars.items.ItemList;

public class OpenSelectorArena implements Listener {

    @EventHandler
    public void openSelector(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        val rightClickAir = event.getAction() == Action.RIGHT_CLICK_AIR;
        val rightClickBlock = event.getAction() == Action.RIGHT_CLICK_BLOCK;
        val itemInHand = player.getInventory().getItemInMainHand();
        if (rightClickAir || rightClickBlock && itemInHand.equals(ItemList.selector()))
        {
            player.openInventory(SkyWars.inventory);
        }
    }
}
