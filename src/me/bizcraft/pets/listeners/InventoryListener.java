package me.bizcraft.pets.listeners;

import me.bizcraft.pets.Pets;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.dsh105.echopet.compat.api.entity.PetType;

public class InventoryListener implements Listener {

	Pets plugin;

	public InventoryListener(Pets instance) {
		plugin = instance;
	}
	
	RegisteredServiceProvider<Permission>permissionProvider = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	Permission permission = permissionProvider.getProvider();

	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent event) {

		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();

		ChatColor color = ChatColor.WHITE;
		String name = player.getName();
		String line = plugin.chat.getPlayerSuffix(player);
		line = line.replaceAll("&0", ChatColor.BLACK + "");
		line = line.replaceAll("&1", ChatColor.DARK_BLUE + "");
		line = line.replaceAll("&2", ChatColor.DARK_GREEN + "");
		line = line.replaceAll("&3", ChatColor.DARK_AQUA + "");
		line = line.replaceAll("&4", ChatColor.DARK_RED + "");
		line = line.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		line = line.replaceAll("&6", ChatColor.GOLD + "");
		line = line.replaceAll("&7", ChatColor.GRAY + "");
		line = line.replaceAll("&8", ChatColor.DARK_GRAY + "");
		line = line.replaceAll("&9", ChatColor.BLUE + "");
		line = line.replaceAll("&a", ChatColor.GREEN + "");
		line = line.replaceAll("&b", ChatColor.AQUA + "");
		line = line.replaceAll("&c", ChatColor.RED + "");
		line = line.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		line = line.replaceAll("&e", ChatColor.YELLOW + "");
		line = line.replaceAll("&f", ChatColor.WHITE + "");
		line = line.replaceAll("&g", ChatColor.MAGIC + "");
		line = line.replaceAll("&l", ChatColor.BOLD + "");
		byte chicken = 93;
		byte cow = 92;
		byte horse = 100;
		byte ocelot = 98;
		byte pig = 90;
		byte sheep = 91;
		byte bat = 65;
		byte mooshroom = 96;
		byte squid = 94;
		byte villager = 120;
		byte enderman = 58;
		byte wolf = 95;
		byte zombiePigman = 57;
		byte blaze = 61;
		byte creeper = 50;
		byte magma = 62;
		byte silverfish = 60;
		byte skeleton = 51;
		byte slime = 55;
		byte witch = 66;
		byte zombie = 54;

		double balance = plugin.econ.getBalance(player.getName());

		if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			event.setCancelled(true);
			return;
		}
		if (clicked.getType() == Material.MONSTER_EGG) {
			if (clicked.getData().getData() == chicken) {
				if (player.hasPermission("bizcraft.pet.chicken")) {
					plugin.getEchoPetAPI().givePet(player, PetType.CHICKEN,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Chicken");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Chicken.Price")
						&& !player.hasPermission("bizcraft.pet.chicken")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Chicken.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.CHICKEN,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Chicken");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a chicken pet!");
					permission.playerAdd(player, "bizcraft.pet.chicken");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == cow) {
				if (player.hasPermission("bizcraft.pet.cow")) {
					plugin.getEchoPetAPI().givePet(player, PetType.COW, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Cow");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble("Cow.Price")
						&& !player.hasPermission("bizcraft.pet.cow")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Cow.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.COW, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Cow");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a cow pet!");
					permission.playerAdd(player, "bizcraft.pet.cow");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == horse) {
				if (player.hasPermission("bizcraft.pet.horse")) {
					plugin.getEchoPetAPI().givePet(player, PetType.HORSE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Horse");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Horse.Price")
						&& !player.hasPermission("bizcraft.pet.horse")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Horse.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.HORSE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Horse");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a horse pet!");
					permission.playerAdd(player, "bizcraft.pet.horse");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == ocelot) {
				if (player.hasPermission("bizcraft.pet.ocelot")) {
					plugin.getEchoPetAPI()
							.givePet(player, PetType.OCELOT, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Ocelot");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Ocelot.Price")
						&& !player.hasPermission("bizcraft.pet.ocelot")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Ocelot.Price"));
					plugin.getEchoPetAPI()
							.givePet(player, PetType.OCELOT, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Ocelot");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a ocelot pet!");
					permission.playerAdd(player, "bizcraft.pet.ocelot");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == pig) {
				if (player.hasPermission("bizcraft.pet.pig")) {
					plugin.getEchoPetAPI().givePet(player, PetType.PIG, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Pig");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble("Pig.Price")
						&& !player.hasPermission("bizcraft.pet.pig")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Pig.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.PIG, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Pig");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a pig pet!");
					permission.playerAdd(player, "bizcraft.pet.pig");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == sheep) {
				if (player.hasPermission("bizcraft.pet.sheep")) {
					plugin.getEchoPetAPI().givePet(player, PetType.SHEEP, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Sheep");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Sheep.Price")
						&& !player.hasPermission("bizcraft.pet.sheep")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Sheep.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.SHEEP, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Sheep");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a sheep pet!");
					permission.playerAdd(player, "bizcraft.pet.sheep");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == bat) {
				if (player.hasPermission("bizcraft.pet.bat")) {
					plugin.getEchoPetAPI().givePet(player, PetType.BAT, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Bat");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble("Bat.Price")
						&& !player.hasPermission("bizcraft.pet.bat")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Bat.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.BAT, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Bat");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a bat pet!");
					permission.playerAdd(player, "bizcraft.pet.bat");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == mooshroom) {
				if (player.hasPermission("bizcraft.pet.mooshroom")) {
					plugin.getEchoPetAPI().givePet(player, PetType.MUSHROOMCOW,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName() + "'s Mooshroon");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Mooshroon.Price")
						&& !player.hasPermission("bizcraft.pet.mooshroom")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Mooshroon.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.MUSHROOMCOW,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName() + "'s Mooshroon");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a mooshroom pet!");
					permission.playerAdd(player, "bizcraft.pet.mooshroom");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == squid) {
				if (player.hasPermission("bizcraft.pet.squid")) {
					plugin.getEchoPetAPI().givePet(player, PetType.SQUID, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Squid");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Squid.Price")
						&& !player.hasPermission("bizcraft.pet.squid")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Squid.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.SQUID, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Squid");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a squid pet!");
					permission.playerAdd(player, "bizcraft.pet.squid");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == villager) {
				if (player.hasPermission("bizcraft.pet.villager")) {
					plugin.getEchoPetAPI().givePet(player, PetType.VILLAGER,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Villager");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Villager.Price")
						&& !player.hasPermission("bizcraft.pet.villager")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Villager.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.VILLAGER,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Villager");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a villager pet!");
					permission.playerAdd(player, "bizcraft.pet.villager");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == enderman) {
				if (player.hasPermission("bizcraft.pet.enderman")) {
					plugin.getEchoPetAPI().givePet(player, PetType.ENDERMAN,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Enderman");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Enderman.Price")
						&& !player.hasPermission("bizcraft.pet.enderman")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Enderman.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.ENDERMAN,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Enderman");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a enderman pet!");
					permission.playerAdd(player, "bizcraft.pet.enderman");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == wolf) {
				if (player.hasPermission("bizcraft.pet.wolf")) {
					plugin.getEchoPetAPI().givePet(player, PetType.WOLF, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Wolf");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig()
						.getDouble("Wolf.Price")
						&& !player.hasPermission("bizcraft.pet.wolf")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Wolf.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.WOLF, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Wolf");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a wolf pet!");
					permission.playerAdd(player, "bizcraft.pet.wolf");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == zombiePigman) {
				if (player.hasPermission("bizcraft.pet.zombiePigman")) {
					plugin.getEchoPetAPI().givePet(player, PetType.PIGZOMBIE,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName()
											+ "'s Zombie Pigman");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"ZombiePigman.Price")
						&& !player.hasPermission("bizcraft.pet.zombiePigman")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("ZombiePigman.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.PIGZOMBIE,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName()
											+ "'s Zombie Pigman");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a zombiePigman pet!");
					permission.playerAdd(player, "bizcraft.pet.zombiePigman");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == blaze) {
				if (player.hasPermission("bizcraft.pet.blaze")) {
					plugin.getEchoPetAPI().givePet(player, PetType.BLAZE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Blaze");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Blaze.Price")
						&& !player.hasPermission("bizcraft.pet.blaze")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Blaze.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.BLAZE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Blaze");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a blaze pet!");
					permission.playerAdd(player, "bizcraft.pet.blaze");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == creeper) {
				if (player.hasPermission("bizcraft.pet.creeper")) {
					plugin.getEchoPetAPI().givePet(player, PetType.CREEPER,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Creeper");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Creeper.Price")
						&& !player.hasPermission("bizcraft.pet.creeper")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Creeper.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.CREEPER,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Creeper");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a creeper pet!");
					permission.playerAdd(player, "bizcraft.pet.creeper");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == magma) {
				if (player.hasPermission("bizcraft.pet.magma")) {
					plugin.getEchoPetAPI().givePet(player, PetType.MAGMACUBE,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Magma");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Magma.Price")
						&& !player.hasPermission("bizcraft.pet.magma")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Magma.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.MAGMACUBE,
							true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Magma");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a magma pet!");
					permission.playerAdd(player, "bizcraft.pet.magma");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == silverfish) {
				if (player.hasPermission("bizcraft.pet.silverfish")) {
					plugin.getEchoPetAPI().givePet(player, PetType.SILVERFISH,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName() + "'s Silverfish");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Silverfish.Price")
						&& !player.hasPermission("bizcraft.pet.silverfish")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Silverfish.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.SILVERFISH,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(
									line + player.getName() + "'s Silverfish");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a silverfish pet!");
					permission.playerAdd(player, "bizcraft.pet.silverfish");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == skeleton) {
				if (player.hasPermission("bizcraft.pet.skeleton")) {
					plugin.getEchoPetAPI().givePet(player, PetType.SKELETON,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Skeleton");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Skeleton.Price")
						&& !player.hasPermission("bizcraft.pet.skeleton")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Skeleton.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.SKELETON,
							true);
					plugin.getEchoPetAPI()
							.getPet(player)
							.setPetName(line + player.getName() + "'s Skeleton");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a skeleton pet!");
					permission.playerAdd(player, "bizcraft.pet.skeleton");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == slime) {
				if (player.hasPermission("bizcraft.pet.slime")) {
					plugin.getEchoPetAPI().givePet(player, PetType.SLIME, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Slime");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Slime.Price")
						&& !player.hasPermission("bizcraft.pet.slime")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Slime.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.SLIME, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Slime");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a slime pet!");
					permission.playerAdd(player, "bizcraft.pet.slime");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == witch) {
				if (player.hasPermission("bizcraft.pet.witch")) {
					plugin.getEchoPetAPI().givePet(player, PetType.WITCH, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Witch");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Witch.Price")
						&& !player.hasPermission("bizcraft.pet.witch")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Witch.Price"));
					plugin.getEchoPetAPI().givePet(player, PetType.WITCH, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Witch");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a witch pet!");
					permission.playerAdd(player, "bizcraft.pet.witch");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}
			if (clicked.getData().getData() == zombie) {
				if (player.hasPermission("bizcraft.pet.zombie")) {
					plugin.getEchoPetAPI()
							.givePet(player, PetType.ZOMBIE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Zombie");
					event.setCancelled(true);
					return;
				} else if (balance >= plugin.getConfig().getDouble(
						"Zombie.Price")
						&& !player.hasPermission("bizcraft.pet.zombie")) {
					plugin.econ.withdrawPlayer(player.getName(), plugin
							.getConfig().getDouble("Zombie.Price"));
					plugin.getEchoPetAPI()
							.givePet(player, PetType.ZOMBIE, true);
					plugin.getEchoPetAPI().getPet(player)
							.setPetName(line + player.getName() + "'s Zombie");
					player.sendMessage(ChatColor.GREEN
							+ "You have purchased a zombie pet!");
					permission.playerAdd(player, "bizcraft.pet.zombie");
					event.setCancelled(true);
					return;
				} else {
					player.sendMessage(ChatColor.RED + "Not enough money!");
					event.setCancelled(true);
					return;
				}
			}

		}

	}
}
