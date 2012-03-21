package me.Kruithne.MinecartsMod;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Block clickedBlock = event.getClickedBlock();
		if (clickedBlock.getType() == Material.RAILS)
			event.getPlayer().sendMessage("Block data: " + clickedBlock.getData());
	}
	
}
