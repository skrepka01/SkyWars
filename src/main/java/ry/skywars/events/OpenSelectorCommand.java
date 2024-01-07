package ry.skywars.events;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ry.skywars.SkyWars;
import ry.skywars.items.ItemList;

import java.util.List;

public class OpenSelectorCommand implements Listener {


    @EventHandler
    public void openSelector(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        val rightClickAir = event.getAction() == Action.RIGHT_CLICK_AIR;
        val rightClickBlock = event.getAction() ==Action.RIGHT_CLICK_BLOCK;
        val itemMetaInHand = player.getInventory().getItemInMainHand().getItemMeta();
        if (rightClickAir || rightClickBlock
                && itemMetaInHand.equals(ItemList.selectorCommand().getItemMeta()))
        {
            player.openInventory(SkyWars.inventoryCommand);
        }
    }
}
