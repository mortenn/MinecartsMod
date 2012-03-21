package me.Kruithne.MinecartsMod;

import me.Kruithne.RMPF.RMPFConfiguration;
import me.Kruithne.RMPF.RMPFOutput;
import me.Kruithne.RMPF.RMPFTimedEventHandler;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartsMod extends JavaPlugin {
	
	private RMPFOutput output;
	private RMPFConfiguration config;
	private MinecartPowerGrid powerGrid;
	
	public void onEnable()
	{
		Server server = this.getServer();
		this.output = new RMPFOutput(server, this.getLogger());
		this.config = new RMPFConfiguration(Constants.configurationFile, this.output, getResource(Constants.defaultConfigurationFile));
		new RMPFTimedEventHandler(server, this);
		this.powerGrid = new MinecartPowerGrid(new RMPFTimedEventHandler(server, this), server);
		
		PluginManager pluginManager = server.getPluginManager();
		
		pluginManager.registerEvents(new VehicleListener(this.config, server, this.powerGrid), this);
		pluginManager.registerEvents(new PlayerListener(this.powerGrid), this);
	}
	
	public void onDisable()
	{
		
	}
	
}
