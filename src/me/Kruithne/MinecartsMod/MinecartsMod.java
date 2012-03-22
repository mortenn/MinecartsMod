package me.Kruithne.MinecartsMod;

import java.io.InputStream;

import me.Kruithne.RMPF.IConfigurationDefaults;
import me.Kruithne.RMPF.IConfigurationFile;
import me.Kruithne.RMPF.RMPF;

public class MinecartsMod extends RMPF implements IConfigurationFile, IConfigurationDefaults 
{
	@Override
	protected void PluginSetup()
	{
		this.container.addComponent(MinecartPowerGrid.class);
		this.container.addComponent(PlayerListener.class);
		this.container.addComponent(VehicleListener.class);
	}
	
	@Override
	public InputStream getDefaultConfiguration() 
	{
		return getResource(Constants.defaultConfigurationFile);
	}

	@Override
	public String getConfigurationPath() 
	{
		return Constants.configurationFile;
	}
}
