package me.Kruithne.MinecartsMod;

import org.bukkit.entity.Entity;
import org.bukkit.entity.PoweredMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerListener implements Listener {
	
	MinecartPowerGrid powerGrid;
	
	public PlayerListener(MinecartPowerGrid powerGrid)
	{
		this.powerGrid = powerGrid;
	}

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
	{
		Entity theEntity = event.getRightClicked();
		if (theEntity != null)
		{
			if (theEntity instanceof PoweredMinecart)
			{
				this.powerGrid.addFuel((PoweredMinecart) theEntity, 50);
			}
		}
	}
	
}
