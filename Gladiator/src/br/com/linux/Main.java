package br.com.linux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.linux.api.CreateItem;
import br.com.linux.api.LinuxAPI;

public class Main extends JavaPlugin {

	public static Plugin plugin;
	public static ArrayList<UUID> jogadores = new ArrayList<>();
	public static ArrayList<String> admins = new ArrayList<>();
	public static ArrayList<String> Checando = new ArrayList<>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<String, Object> saveConfiguration = new HashMap();

	public static String semp = "§c§lPERMISSÃO §fVocê não possui permissão para executar este comando.";

	public static Plugin getPlugin() {
		return plugin;
	}

	@Override
	public void onEnable() {
		saveDefaultConfig();
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("                                  ");
		Bukkit.getConsoleSender().sendMessage("§fPlugin funcionando normal");
		Bukkit.getConsoleSender().sendMessage("§fQualquer tipo de bug me chama na dm: §e@vsfLinux");
		Bukkit.getConsoleSender().sendMessage("                                  ");

		eventos();
		Sopas();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onDisable() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.kickPlayer("§6§lHastyMC" + "\n" + "\n" + "§cOcorreu um erro no servidor, Desculpe-nos.");

		}
	}

	@SuppressWarnings("deprecation")
	public void Sopas() {
		ItemStack icone = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName("§fSopa");
		ArrayList<String> lore = new ArrayList<>();

		lore.add(null);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		ShapelessRecipe cactu = new ShapelessRecipe(icone);
		LinuxAPI.I(Material.MUSHROOM_SOUP, "§aSopa de Cactus", 0, 1);
		cactu.addIngredient(1, Material.CACTUS);
		cactu.addIngredient(1, Material.BOWL);
		getServer().addRecipe(cactu);

		ShapelessRecipe cacau = new ShapelessRecipe(icone);
		LinuxAPI.I(Material.MUSHROOM_SOUP, "§bSopa de Cacau", 0, 1);
		cacau.addIngredient(1, Material.INK_SACK, 3);
		cacau.addIngredient(1, Material.BOWL);
		getServer().addRecipe(cacau);
	}

	public static void startGlad(Player player1, Player player2) {
		inventory(player1);
		inventory(player2);
		Glad.emluta.put(player1.getName(), player2.getName());
		Glad.emluta.put(player2.getName(), player1.getName());
		Glad.spawnArena(player1, player2, new Location(player1.getWorld(), 0, 0, 0), Material.GLASS);
	}

	private static void inventory(Player p) {
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		p.closeInventory();
		p.setGameMode(GameMode.SURVIVAL);

		@SuppressWarnings("deprecation")
		ItemStack icone = new ItemStack(351, 64, (short) 3);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName("§fRecraft");
		ArrayList<String> lore = new ArrayList<>();

		lore.add(null);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		ItemStack a = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName("§bEspada");
		am.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		a.setItemMeta(am);

		p.getInventory().setItem(0, a);
		CreateItem.item(p.getInventory(), p, Material.COBBLE_WALL, 64, 0, "§6Castelo", null, 1);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 2);
		CreateItem.item(p.getInventory(), p, Material.WATER_BUCKET, 1, 0, "§bAgua", null, 3);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 4);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 5);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 6);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 7);
		CreateItem.item(p.getInventory(), p, Material.WOOD, 64, 0, "§cMadeira", null, 8);
		CreateItem.item(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null, 9);
		CreateItem.item(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null, 10);
		CreateItem.item(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null, 11);
		CreateItem.item(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null, 12);
		CreateItem.item(p.getInventory(), p, Material.BOWL, 64, 0, "§fRecraft", null, 13);
		p.getInventory().setItem(14, icone);
		p.getInventory().setItem(15, icone);
		p.getInventory().setItem(16, icone);
		CreateItem.item(p.getInventory(), p, Material.STONE_AXE, 1, 0, "§cMachado", null, 17);
		CreateItem.item(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null, 18);
		CreateItem.item(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null, 19);
		CreateItem.item(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null, 20);
		CreateItem.item(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null, 21);
		CreateItem.item(p.getInventory(), p, Material.BOWL, 64, 0, "§fRecraft", null, 22);
		p.getInventory().setItem(23, icone);
		p.getInventory().setItem(24, icone);
		CreateItem.item(p.getInventory(), p, Material.STONE_PICKAXE, 1, 0, "§cPicareta", null, 26);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 27);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 28);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 29);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 30);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 31);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 32);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 33);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 34);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 35);
		CreateItem.item(p.getInventory(), p, Material.MUSHROOM_SOUP, 1, 0, "§fSopa", null, 36);

		ItemStack h = CreateItem.item2(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null);
		ItemStack c = CreateItem.item2(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null);
		ItemStack l = CreateItem.item2(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null);
		ItemStack b = CreateItem.item2(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null);

		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(c);
		p.getInventory().setLeggings(l);
		p.getInventory().setBoots(b);
		p.updateInventory();
	}

	void eventos() {
		PluginManager m = Bukkit.getPluginManager();

		m.registerEvents(new Glad(), this);

	}

	public static void getitemDefault(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);

		ItemStack b = new ItemStack(Material.IRON_FENCE);
		ItemMeta bm = b.getItemMeta();
		bm.setDisplayName("§aDesafiar Gladiator §8(Clique)");
		b.setItemMeta(bm);

		@SuppressWarnings("deprecation")
		ItemStack icone = new ItemStack(351, 1, (short) 8);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName("§aPartida rápida §8(Clique)");
		icone.setItemMeta(iconem);

		ItemStack a21 = new ItemStack(Material.CHEST);
		ItemMeta a2m1 = a21.getItemMeta();
		a2m1.setDisplayName("§aGladiator Customizado §8(Clique)");
		a21.setItemMeta(a2m1);

		player.getInventory().setItem(4, icone);
		player.getInventory().setItem(6, a21);
		player.getInventory().setItem(2, b);

	}
}
