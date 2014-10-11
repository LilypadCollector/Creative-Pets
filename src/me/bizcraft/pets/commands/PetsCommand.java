package me.bizcraft.pets.commands;

import me.bizcraft.pets.Pets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PetsCommand implements CommandExecutor {
	
	private Pets plugin;

	public PetsCommand(Pets plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		plugin.createPetsInv(player);
		
		return true;
		
	}
	
}
