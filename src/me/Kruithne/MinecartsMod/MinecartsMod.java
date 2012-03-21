package me.Kruithne.MinecartsMod;

import me.Kruithne.RMPF.RMPFConfiguration;
import me.Kruithne.RMPF.RMPFOutput;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartsMod extends JavaPlugin {
	
	private RMPFOutput output;
	private RMPFConfiguration config;

	public void onEnable()
	{
		this.output = new RMPFOutput(this.getServer(), this.getLogger());
		this.config = new RMPFConfiguration(Constants.configurationFile, this.output, getResource(Constants.defaultConfigurationFile));
		
		PluginManager pluginManager = this.getServer().getPluginManager();
		
		pluginManager.registerEvents(new VehicleListener(this.config, this.getServer()), this);
		pluginManager.registerEvents(new PlayerListener(), this);
	}
	
	public void onDisable()
	{
		
	}
	
}
