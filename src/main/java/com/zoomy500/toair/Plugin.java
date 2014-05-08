package com.zoomy500.toair;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("toair")) { 
			if (args.length > 4) {
	         		  sender.sendMessage("Too many arguments!");
	          		 return false;
	        		} 
	       		 if (args.length < 2) {
	           		sender.sendMessage("Not enough arguments!");
	           		return false;
	        		}
			if (args.length == 3) {
				if (sender.hasPermission("toair.setblock")) {
					Player player = (Player)sender;
					Location loc = player.getLocation();
					int X = Integer.parseInt(args[0]);
					int Y = Integer.parseInt(args[1]);
					int Z = Integer.parseInt(args[2]);
					
					int x = 0;
					int z = 0;
					
					if (X<0) {
						x = X - 1;
					} else if (X>=0) {
						x = X;
					}
					
					
					if (Z<0) {
						z = Z - 1;
					} else if (Z>=0) {
						z = Z;
					}
					
					loc.setX(x);
					loc.setY(Y);
					loc.setZ(z);
					Block blockToSet = loc.getBlock();
					blockToSet.setType(Material.AIR);
					return false;
				}
			return false;
			}
		} 
		return false; 
	}


}