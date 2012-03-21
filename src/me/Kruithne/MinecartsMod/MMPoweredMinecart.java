package me.Kruithne.MinecartsMod;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.PoweredMinecart;
import org.bukkit.util.Vector;

public class MMPoweredMinecart {

	public PoweredMinecart cart;
	boolean powered = false;
	Server server;
	
	public MMPoweredMinecart(PoweredMinecart cart, Server server)
	{
		this.cart = cart;
		this.server = server;
	}
	
	public byte trackBelow()
	{
		Block blockBelow = this.cart.getLocation().getBlock();
		
		if (blockBelow.getType() == Material.RAILS)
		{
			return blockBelow.getData();
		}
		return -1;
	}
	
	public boolean isPowered()
	{
		return this.powered;
	}
	
	public void gainSpeed(Double speed)
	{
		Vector direction = this.cart.getLocation().getDirection();
		Vector velocity  = this.cart.getVelocity();
		
		if (trackBelow() == 0)
			this.cart.setVelocity(new Vector(5.0, 0.0, 0.0));
		
		this.server.broadcastMessage("VelocityX: " + velocity.getX());
		this.server.broadcastMessage("VelocityY: " + velocity.getY());
		this.server.broadcastMessage("Velocity Length: " + velocity.length());
		this.server.broadcastMessage("DirectionX: " + direction.getX());
		this.server.broadcastMessage("DirectionY: " + direction.getY());
		this.server.broadcastMessage("Direction Length: " + direction.length());
	}
}
