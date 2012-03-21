package me.Kruithne.MinecartsMod;

import me.Kruithne.RMPF.RMPFConfiguration;

import org.bukkit.Server;
import org.bukkit.entity.PoweredMinecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class VehicleListener implements Listener {
	
	RMPFConfiguration config;
	Server server;

	public VehicleListener(RMPFConfiguration config, Server server)
	{
		this.config = config;
		this.server = server;
	}
	
	@EventHandler
	public void onVehicleMove(VehicleMoveEvent event)
	{
		Vehicle theVehicle = event.getVehicle();
		
		if (theVehicle instanceof PoweredMinecart)
		{			
			MMPoweredMinecart poweredMinecart = new MMPoweredMinecart((PoweredMinecart) theVehicle, this.server);
			poweredMinecart.gainSpeed(this.config.getConfigValueAsDouble("poweredMinecartSpeed"));
			
		}
	}
	
}
