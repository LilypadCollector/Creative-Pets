package me.bizcraft.pets;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.bizcraft.pets.commands.PetsCommand;
import me.bizcraft.pets.listeners.InventoryListener;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.dsh105.echopet.api.EchoPetAPI;

public class Pets extends JavaPlugin implements CommandExecutor {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public static Chat chat = null;
	public static Pets plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		this.getCommand("pets").setExecutor(new PetsCommand(this));
		Bukkit.getPluginManager().registerEvents(new InventoryListener(this), this);
		setupChat();	
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	
	private boolean setupEconomy() {
	        if (getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	}
	
	private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
	
	public static EchoPetAPI getEchoPetAPI() {
	    return EchoPetAPI.getAPI();
	}
	
	public static void createPetsInv(Player player) {
		
		double balance = econ.getBalance(player.getName());
		
		ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
		
		Inventory inv = Bukkit.createInventory(null, 45, "Pets");
		ItemStack chicken = new ItemStack(Material.MONSTER_EGG, 1, (byte)93);
		List<String> chickenLore = new ArrayList<String>();
		ItemStack cow = new ItemStack(Material.MONSTER_EGG, 1, (byte)92);
		List<String> cowLore = new ArrayList<String>();
		ItemStack horse = new ItemStack(Material.MONSTER_EGG, 1, (byte)100);
		List<String> horseLore = new ArrayList<String>();
		ItemStack ocelot = new ItemStack(Material.MONSTER_EGG, 1, (byte)98);
		List<String> ocelotLore = new ArrayList<String>();
		ItemStack pig = new ItemStack(Material.MONSTER_EGG, 1, (byte)90);
		List<String> pigLore = new ArrayList<String>();
		ItemStack sheep = new ItemStack(Material.MONSTER_EGG, 1, (byte)91);
		List<String> sheepLore = new ArrayList<String>();
		ItemStack bat = new ItemStack(Material.MONSTER_EGG, 1, (byte)65);
		List<String> batLore = new ArrayList<String>();
		ItemStack mooshroom = new ItemStack(Material.MONSTER_EGG, 1, (byte)96);
		List<String> mooshroomLore = new ArrayList<String>();
		ItemStack squid = new ItemStack(Material.MONSTER_EGG, 1, (byte)94);
		List<String> squidLore = new ArrayList<String>();
		ItemStack villager = new ItemStack(Material.MONSTER_EGG, 1, (byte)120);
		List<String> villagerLore = new ArrayList<String>();
		ItemStack caveSpider = new ItemStack(Material.MONSTER_EGG, 1, (byte)59);
		List<String> caveSpiderLore = new ArrayList<String>();
		ItemStack enderman = new ItemStack(Material.MONSTER_EGG, 1, (byte)58);
		List<String> endermanLore = new ArrayList<String>();
		ItemStack wolf = new ItemStack(Material.MONSTER_EGG, 1, (byte)95);
		List<String> wolfLore = new ArrayList<String>();
		ItemStack zombiePigman = new ItemStack(Material.MONSTER_EGG, 1, (byte)57);
		List<String> zombiePigmanLore = new ArrayList<String>();
		ItemStack blaze = new ItemStack(Material.MONSTER_EGG, 1, (byte)61);
		List<String> blazeLore = new ArrayList<String>();
		ItemStack creeper = new ItemStack(Material.MONSTER_EGG, 1, (byte)50);
		List<String> creeperLore = new ArrayList<String>();
		ItemStack magma = new ItemStack(Material.MONSTER_EGG, 1, (byte)62);
		List<String> magmaLore = new ArrayList<String>();
		ItemStack silverfish = new ItemStack(Material.MONSTER_EGG, 1, (byte)60);
		List<String> silverfishLore = new ArrayList<String>();
		ItemStack skeleton = new ItemStack(Material.MONSTER_EGG, 1, (byte)51);
		List<String> skeletonLore = new ArrayList<String>();
		ItemStack slime = new ItemStack(Material.MONSTER_EGG, 1, (byte)55);
		List<String> slimeLore = new ArrayList<String>();
		ItemStack witch = new ItemStack(Material.MONSTER_EGG, 1, (byte)66);
		List<String> witchLore = new ArrayList<String>();
		ItemStack zombie = new ItemStack(Material.MONSTER_EGG, 1, (byte)54);
		List<String> zombieLore = new ArrayList<String>();
		
		if (player.hasPermission("bizcraft.pet.chicken")) {
			chickenLore.add(ChatColor.GREEN + "Purchased");
			chickenLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = chicken.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Chicken pet");
			meta.setLore(chickenLore);
			chicken.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Chicken.Price") && !player.hasPermission("bizcraft.pet.chicken")) {
			chickenLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Chicken.Price"));
			chickenLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = chicken.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Chicken pet");
			meta.setLore(chickenLore);
			chicken.setItemMeta(meta);
		} else {
			chickenLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Chicken.Price"));
			chickenLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = chicken.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Chicken pet");
			meta.setLore(chickenLore);
			chicken.setItemMeta(meta);
		}
		if (player.hasPermission("bizcraft.pet.cow")) {
			cowLore.add(ChatColor.GREEN + "Purchased");
			cowLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = cow.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cow pet");
			meta.setLore(cowLore);
			cow.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Cow.Price") && !player.hasPermission("bizcraft.pet.cow")) {
			cowLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Cow.Price"));
			cowLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = cow.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cow pet");
			meta.setLore(cowLore);
			cow.setItemMeta(meta);
		} else {
			cowLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Cow.Price"));
			cowLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = cow.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cow pet");
			meta.setLore(cowLore);
			cow.setItemMeta(meta);
		}
		if (player.hasPermission("bizcraft.pet.horse")) {
			horseLore.add(ChatColor.GREEN + "Purchased");
			horseLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = horse.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Horse pet");
			meta.setLore(horseLore);
			horse.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Horse.Price") && !player.hasPermission("bizcraft.pet.horse")) {
			horseLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Horse.Price"));
			horseLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = horse.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Horse pet");
			meta.setLore(horseLore);
			horse.setItemMeta(meta);
		} else {
			horseLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Horse.Price"));
			horseLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = horse.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Horse pet");
			meta.setLore(horseLore);
			horse.setItemMeta(meta);
		}
		if (player.hasPermission("bizcraft.pet.ocelot")) {
			ocelotLore.add(ChatColor.GREEN + "Purchased");
			ocelotLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = ocelot.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Ocelot pet");
			meta.setLore(ocelotLore);
			ocelot.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Ocelot.Price") && !player.hasPermission("bizcraft.pet.ocelot")) {
			ocelotLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Ocelot.Price"));
			ocelotLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = ocelot.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Ocelot pet");
			meta.setLore(ocelotLore);
			ocelot.setItemMeta(meta);
		} else {
			ocelotLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Ocelot.Price"));
			ocelotLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = ocelot.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Ocelot pet");
			meta.setLore(ocelotLore);
			ocelot.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.pig")) {
			pigLore.add(ChatColor.GREEN + "Purchased");
			pigLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = pig.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Pig pet");
			meta.setLore(pigLore);
			pig.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Pig.Price") && !player.hasPermission("bizcraft.pet.pig")) {
			pigLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Pig.Price"));
			pigLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = pig.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Pig pet");
			meta.setLore(pigLore);
			pig.setItemMeta(meta);
		} else {
			pigLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Pig.Price"));
			pigLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = pig.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Pig pet");
			meta.setLore(pigLore);
			pig.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.sheep")) {
			sheepLore.add(ChatColor.GREEN + "Purchased");
			sheepLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = sheep.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Sheep pet");
			meta.setLore(sheepLore);
			sheep.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Sheep.Price") && !player.hasPermission("bizcraft.pet.sheep")) {
			sheepLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Sheep.Price"));
			sheepLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = sheep.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Sheep pet");
			meta.setLore(sheepLore);
			sheep.setItemMeta(meta);
		} else {
			sheepLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Sheep.Price"));
			sheepLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = sheep.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Sheep pet");
			meta.setLore(sheepLore);
			sheep.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.bat")) {
			batLore.add(ChatColor.GREEN + "Purchased");
			batLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = bat.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Bat pet");
			meta.setLore(batLore);
			bat.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Bat.Price") && !player.hasPermission("bizcraft.pet.bat")) {
			batLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Bat.Price"));
			batLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = bat.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Bat pet");
			meta.setLore(batLore);
			bat.setItemMeta(meta);
		} else {
			batLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Bat.Price"));
			batLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = bat.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Bat pet");
			meta.setLore(batLore);
			bat.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.mooshroom")) {
			mooshroomLore.add(ChatColor.GREEN + "Purchased");
			mooshroomLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = mooshroom.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Mooshroom pet");
			meta.setLore(mooshroomLore);
			mooshroom.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Mooshroom.Price") && !player.hasPermission("bizcraft.pet.mooshroom")) {
			mooshroomLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Mooshroom.Price"));
			mooshroomLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = mooshroom.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Mooshroom pet");
			meta.setLore(mooshroomLore);
			mooshroom.setItemMeta(meta);
		} else {
			mooshroomLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Mooshroom.Price"));
			mooshroomLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = mooshroom.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Mooshroom pet");
			meta.setLore(mooshroomLore);
			mooshroom.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.squid")) {
			squidLore.add(ChatColor.GREEN + "Purchased");
			squidLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = squid.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Squid pet");
			meta.setLore(squidLore);
			squid.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Squid.Price") && !player.hasPermission("bizcraft.pet.squid")) {
			squidLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Squid.Price"));
			squidLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = squid.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Squid pet");
			meta.setLore(squidLore);
			squid.setItemMeta(meta);
		} else {
			squidLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Squid.Price"));
			squidLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = squid.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Squid pet");
			meta.setLore(squidLore);
			squid.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.villager")) {
			villagerLore.add(ChatColor.GREEN + "Purchased");
			villagerLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = villager.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Villager pet");
			meta.setLore(villagerLore);
			villager.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Villager.Price") && !player.hasPermission("bizcraft.pet.villager")) {
			villagerLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Villager.Price"));
			villagerLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = villager.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Villager pet");
			meta.setLore(villagerLore);
			villager.setItemMeta(meta);
		} else {
			villagerLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Villager.Price"));
			villagerLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = villager.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Villager pet");
			meta.setLore(villagerLore);
			villager.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.caveSpider")) {
			caveSpiderLore.add(ChatColor.GREEN + "Purchased");
			caveSpiderLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = caveSpider.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cave spider pet");
			meta.setLore(caveSpiderLore);
			caveSpider.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Cavespider.Price") && !player.hasPermission("bizcraft.pet.caveSpider")) {
			caveSpiderLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Cavespider.Price"));
			caveSpiderLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = caveSpider.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cave spider pet");
			meta.setLore(caveSpiderLore);
			caveSpider.setItemMeta(meta);
		} else {
			caveSpiderLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Cavespider.Price"));
			caveSpiderLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = caveSpider.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Cave spider pet");
			meta.setLore(caveSpiderLore);
			caveSpider.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.enderman")) {
			endermanLore.add(ChatColor.GREEN + "Purchased");
			endermanLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = enderman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Enderman pet");
			meta.setLore(endermanLore);
			enderman.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Enderman.Price") && !player.hasPermission("bizcraft.pet.enderman")) {
			endermanLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Enderman.Price"));
			endermanLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = enderman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Enderman pet");
			meta.setLore(endermanLore);
			enderman.setItemMeta(meta);
		} else {
			endermanLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Enderman.Price"));
			endermanLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = enderman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Enderman pet");
			meta.setLore(endermanLore);
			enderman.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.wolf")) {
			wolfLore.add(ChatColor.GREEN + "Purchased");
			wolfLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = wolf.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Wolf pet");
			meta.setLore(wolfLore);
			wolf.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Wolf.Price") && !player.hasPermission("bizcraft.pet.wolf")) {
			wolfLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Wolf.Price"));
			wolfLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = wolf.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Wolf pet");
			meta.setLore(wolfLore);
			wolf.setItemMeta(meta);
		} else {
			wolfLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Wolf.Price"));
			wolfLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = wolf.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Wolf pet");
			meta.setLore(wolfLore);
			wolf.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.zombiePigman")) {
			zombiePigmanLore.add(ChatColor.GREEN + "Purchased");
			zombiePigmanLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = zombiePigman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pigman pet");
			meta.setLore(zombiePigmanLore);
			zombiePigman.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("ZombiePigman.Price") && !player.hasPermission("bizcraft.pet.zombiePigman")) {
			zombiePigmanLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("ZombiePigman.Price"));
			zombiePigmanLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = zombiePigman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pigman pet");
			meta.setLore(zombiePigmanLore);
			zombiePigman.setItemMeta(meta);
		} else {
			zombiePigmanLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("ZombiePigman.Price"));
			zombiePigmanLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = zombiePigman.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pigman pet");
			meta.setLore(zombiePigmanLore);
			zombiePigman.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.blaze")) {
			blazeLore.add(ChatColor.GREEN + "Purchased");
			blazeLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = blaze.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Blaze pet");
			meta.setLore(blazeLore);
			blaze.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Blaze.Price") && !player.hasPermission("bizcraft.pet.blaze")) {
			blazeLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Blaze.Price"));
			blazeLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = blaze.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Blaze pet");
			meta.setLore(blazeLore);
			blaze.setItemMeta(meta);
		} else {
			blazeLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Blaze.Price"));
			blazeLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = blaze.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Blaze pet");
			meta.setLore(blazeLore);
			blaze.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.creeper")) {
			creeperLore.add(ChatColor.GREEN + "Purchased");
			creeperLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = creeper.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Creeper pet");
			meta.setLore(creeperLore);
			creeper.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Creeper.Price") && !player.hasPermission("bizcraft.pet.creeper")) {
			creeperLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Creeper.Price"));
			creeperLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = creeper.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Creeper pet");
			meta.setLore(creeperLore);
			creeper.setItemMeta(meta);
		} else {
			creeperLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Creeper.Price"));
			creeperLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = creeper.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Creeper pet");
			meta.setLore(creeperLore);
			creeper.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.magma")) {
			magmaLore.add(ChatColor.GREEN + "Purchased");
			magmaLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = magma.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Magma Cube pet");
			meta.setLore(magmaLore);
			magma.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("MagmaCube.Price") && !player.hasPermission("bizcraft.pet.magma")) {
			magmaLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("MagmaCube.Price"));
			magmaLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = magma.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Magma Cube pet");
			meta.setLore(magmaLore);
			magma.setItemMeta(meta);
		} else {
			magmaLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("MagmaCube.Price"));
			magmaLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = magma.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Magma Cube pet");
			meta.setLore(magmaLore);
			magma.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.silverfish")) {
			silverfishLore.add(ChatColor.GREEN + "Purchased");
			silverfishLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = silverfish.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Silverfish pet");
			meta.setLore(silverfishLore);
			silverfish.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Silverfish.Price") && !player.hasPermission("bizcraft.pet.silverfish")) {
			silverfishLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Silverfish.Price"));
			silverfishLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = silverfish.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Silverfish pet");
			meta.setLore(silverfishLore);
			silverfish.setItemMeta(meta);
		} else {
			silverfishLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Silverfish.Price"));
			silverfishLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = silverfish.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Silverfish pet");
			meta.setLore(silverfishLore);
			silverfish.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.skeleton")) {
			skeletonLore.add(ChatColor.GREEN + "Purchased");
			skeletonLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = skeleton.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Skeleton pet");
			meta.setLore(skeletonLore);
			skeleton.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Skeleton.Price") && !player.hasPermission("bizcraft.pet.skeleton")) {
			skeletonLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Skeleton.Price"));
			skeletonLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = skeleton.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Skeleton pet");
			meta.setLore(skeletonLore);
			skeleton.setItemMeta(meta);
		} else {
			skeletonLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Skeleton.Price"));
			skeletonLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = skeleton.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Skeleton pet");
			meta.setLore(skeletonLore);
			skeleton.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.slime")) {
			slimeLore.add(ChatColor.GREEN + "Purchased");
			slimeLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = slime.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Slime pet");
			meta.setLore(slimeLore);
			slime.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Slime.Price") && !player.hasPermission("bizcraft.pet.slime")) {
			slimeLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Slime.Price"));
			slimeLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = slime.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Slime pet");
			meta.setLore(slimeLore);
			slime.setItemMeta(meta);
		} else {
			slimeLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Slime.Price"));
			slimeLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = slime.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Slime pet");
			meta.setLore(slimeLore);
			slime.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.witch")) {
			witchLore.add(ChatColor.GREEN + "Purchased");
			witchLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = witch.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Witch pet");
			meta.setLore(witchLore);
			witch.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Witch.Price") && !player.hasPermission("bizcraft.pet.witch")) {
			witchLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Witch.Price"));
			witchLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = witch.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Witch pet");
			meta.setLore(witchLore);
			witch.setItemMeta(meta);
		} else {
			witchLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Witch.Price"));
			witchLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = witch.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Witch pet");
			meta.setLore(witchLore);
			witch.setItemMeta(meta);
		}
        if (player.hasPermission("bizcraft.pet.zombie")) {
			zombieLore.add(ChatColor.GREEN + "Purchased");
			zombieLore.add(ChatColor.YELLOW + "Click to activate!");
			ItemMeta meta = zombie.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pet");
			meta.setLore(zombieLore);
			zombie.setItemMeta(meta);
		} else if (balance >= plugin.getConfig().getDouble("Zombie.Price") && !player.hasPermission("bizcraft.pet.zombie")) {
			zombieLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Zombie.Price"));
			zombieLore.add(ChatColor.GREEN + "Click to purchase!");
			ItemMeta meta = zombie.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pet");
			meta.setLore(zombieLore);
			zombie.setItemMeta(meta);
		} else {
			zombieLore.add(ChatColor.GRAY + "Price: " + ChatColor.YELLOW + "$" + plugin.getConfig().getDouble("Zombie.Price"));
			zombieLore.add(ChatColor.RED + "Not enough money!");
			ItemMeta meta = zombie.getItemMeta();
			meta.setDisplayName(ChatColor.GRAY + "Zombie pet");
			meta.setLore(zombieLore);
			zombie.setItemMeta(meta);
		}
        inv.setItem(0, border);
        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(3, border);
        inv.setItem(4, border);
        inv.setItem(5, border);
        inv.setItem(6, border);
        inv.setItem(7, border);
        inv.setItem(8, border);
        inv.setItem(9, border);
		inv.setItem(10, chicken);
		inv.setItem(11, cow);
		inv.setItem(12, horse);
		inv.setItem(13, ocelot);
		inv.setItem(14, pig);
		inv.setItem(15, sheep);
		inv.setItem(16, bat);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(19, mooshroom);
		inv.setItem(20, squid);
		inv.setItem(21, villager);
		inv.setItem(22, enderman);
		inv.setItem(23, wolf);
		inv.setItem(24, zombiePigman);
		inv.setItem(25, blaze);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(28, creeper);
		inv.setItem(29, magma);
		inv.setItem(30, silverfish);
		inv.setItem(31, skeleton);
		inv.setItem(32, slime);
		inv.setItem(33, witch);
		inv.setItem(34, zombie);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
		player.openInventory(inv);
		return;
		
	}

}
