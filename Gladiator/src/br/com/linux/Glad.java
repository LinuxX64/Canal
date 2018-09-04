package br.com.linux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.linux.api.CreateItem;
public class Glad implements Listener {

	public static boolean generateGlass = true;
	public static HashMap<String, String> emluta = new HashMap<String, String>();
	public static HashMap<Player, Location> localizacao = new HashMap<Player, Location>();
	public static HashMap<Location, Block> bloco = new HashMap<Location, Block>();
	public static HashMap<Integer, String[]> players = new HashMap<Integer, String[]>();
	private static int k = 0;

	public static int nextID = 0;

	public static Object spawnArena(Player play1, Player play2, Location l, Material mat) {
		double x = l.getX();
		double y = l.getY();
		double z = l.getZ();
		Location loc = new Location(play1.getWorld(), x, y + 120, z);
		Location loc2 = new Location(play1.getWorld(), x, y + 120, z + 8);
		Location loc3 = new Location(play1.getWorld(), x - 8, y + 120, z - 8);
		Integer currentID = Integer.valueOf(nextID);
		nextID += 1;
		ArrayList<String> list = new ArrayList<String>();
		loc.getWorld().refreshChunk(loc.getChunk().getX(), loc.getChunk().getZ());
		players.put(currentID, (String[]) list.toArray(new String[1]));
		if (generateGlass) {
			List<Location> cuboid = new ArrayList<Location>();
			cuboid.clear();
			int bZ;
			for (int bX = -10; bX <= 10; bX++) {
				for (bZ = -10; bZ <= 10; bZ++) {
					for (int bY = -1; bY <= 10; bY++) {
						Block b = loc.clone().add(bX, bY, bZ).getBlock();
						if (!b.isEmpty()) {
							if (k <= 0) {
								k++;
							}
							Random rs = new Random();
							x = rs.nextInt(5000);
							y = rs.nextInt(120);
							z = rs.nextInt(1000);
							Location lk = new Location(Bukkit.getWorld("world"), x, y, z);
							return spawnArena(play1, play2, lk, mat);
						}
						if (bY == 10) {
							cuboid.add(loc.clone().add(bX, bY, bZ));
						} else if (bY == -1) {
							cuboid.add(loc.clone().add(bX, bY, bZ));
						} else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
							cuboid.add(loc.clone().add(bX, bY, bZ));
						}
					}
				}
			}
			for (Location loc1 : cuboid) {
				loc1.getBlock().setType(mat);
				bloco.put(loc1, loc1.getBlock());
			}
			loc2.setYaw(135.0F);
			play1.teleport(new Location(play1.getWorld(), loc2.getX() + 8, loc2.getY() + 1, loc2.getZ() + 1));
			loc3.setYaw(-45.0F);
			play2.teleport(new Location(play2.getWorld(), loc3.getX() + 1.20, loc3.getY() + 1, loc.getZ() + -8.5));

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {

					//asScoreAPI.setScore1(play1);
					//asScoreAPI.setScore2(play2);       

				}
			}, 40L);
		

			emluta.put(play1.getName(), play2.getName());
			emluta.put(play2.getName(), play1.getName());

			new BukkitRunnable() {

				@Override
				public void run() {

					//GladiatorClear.LimparArena(play1);
					//GladiatorClear.LimparArena(play2);

				}

			}.runTaskTimer(Main.getPlugin(), 120L, 300 * 20L);
		}

		List<Location> cuboid2 = new ArrayList<Location>();
		int bZ2;
		for (int bX = -10; bX <= 10; bX++) {
			for (bZ2 = -10; bZ2 <= 10; bZ2++) {
				for (int bY = -1; bY <= 10; bY++) {
				}
				for (Location loc1 : cuboid2) {
					loc1.getBlock().setType(Material.AIR);
				}
			}

		}
		localizacao.put(play1, loc);
		localizacao.put(play2, loc);

		return null;

	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlyaerInteract(final PlayerInteractEvent e) {
		if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.GLASS)
				&& (e.getPlayer().getGameMode() != GameMode.CREATIVE)
				&& (emluta.containsKey(e.getPlayer().getName()))) {
			e.setCancelled(true);
			e.getClickedBlock().setType(Material.BEDROCK);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					if (Glad.emluta.containsKey(e.getPlayer().getName())) {
						e.getClickedBlock().setType(Material.GLASS);
					}
				}
			}, 100L);
		}
	}

	public static void removeArena(Player p) {
		Location loc = (Location) localizacao.get(p);
		loc.setY(loc.getY() - 1);
		//new Schematic("delete", loc);
		//PlayerEvent.damage.remove(p);

	}

	public static void cancelBatalha(Player play1, String motivo) {

		String p2 = emluta.get(play1.getName());
		Player play2 = Bukkit.getPlayer(p2);
		play1.teleport(Bukkit.getWorld("world").getSpawnLocation());
		play2.teleport(Bukkit.getWorld("world").getSpawnLocation());

		removeArena(play1);
		emluta.remove(play1.getName());
		emluta.remove(play2.getName());

		play1.getInventory().clear();
		play2.getInventory().clear();
		play1.getInventory().setArmorContents(null);
		play2.getInventory().setArmorContents(null);
		Main.getitemDefault(play1);
		Main.getitemDefault(play2);

	}

	public static String getPlayerLuta(Player p) {
		String p2 = emluta.get(p.getName());
		Player play2 = Bukkit.getPlayer(p2);
		if (play2 == null) {
			return "Ninguém";
		}
		return play2.getName();
		
	}

	public static void SpawnRandomBattle(Player p, Player p2, int wither, int espada, int glass, int recraft,
			boolean ferramenta) {
		@SuppressWarnings("deprecation")
		ItemStack icone = new ItemStack(351, 64, (short) 3);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName("§fRecraft");
		ArrayList<String> lore = new ArrayList<>();

		lore.add(null);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);
		p.getInventory().clear();
		p2.getInventory().clear();
		if (espada == 0) {
			CreateItem.item(p.getInventory(), p, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 0);
			CreateItem.item(p2.getInventory(), p2, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 0);
		}
		if (espada == 1) {
			CreateItem.itemenchant(p.getInventory(), p, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 0,
					Enchantment.DAMAGE_ALL, 1);
			CreateItem.itemenchant(p2.getInventory(), p2, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 1,
					Enchantment.DAMAGE_ALL, 1);
		}
		if (espada == 3) {
			CreateItem.itemenchant(p.getInventory(), p, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 0,
					Enchantment.DAMAGE_ALL, 1);
			CreateItem.itemenchant(p2.getInventory(), p2, Material.DIAMOND_SWORD, 1, 0, "§cESPADA", null, 1,
					Enchantment.DAMAGE_ALL, 1);
		}

		if (ferramenta == true) {
			CreateItem.item(p.getInventory(), p, Material.STONE_PICKAXE, 1, 0, "§cPicareta", null, 26);
			CreateItem.item(p2.getInventory(), p2, Material.STONE_PICKAXE, 1, 0, "§cPicareta", null, 26);
			CreateItem.item(p2.getInventory(), p2, Material.STONE_AXE, 1, 0, "§cMachado", null, 17);
			CreateItem.item(p.getInventory(), p, Material.STONE_AXE, 1, 0, "§cMachado", null, 17);
		}

		if (glass == 0) {
			Glad.spawnArena(p, p2, new Location(Bukkit.getWorld("world"), 1000, 190, 1000), Material.GLASS);
		}
		if (glass == 1) {
			Glad.spawnArena(p, p2, new Location(Bukkit.getWorld("world"), 1000, 190, 1000), Material.BEDROCK);
		}
		if (glass == 2) {
			Glad.spawnArena(p, p2, new Location(Bukkit.getWorld("world"), 1000, 190, 1000), Material.LEAVES);
		}

		if (wither == 1) {
			while (Glad.emluta.containsKey(p.getName()) && emluta.containsKey(p2.getName())) {
				addPotionEffect(p, 20 * 1 * 60);
			}
		}

		if (wither == 3) {
			while (Glad.emluta.containsKey(p.getName()) && emluta.containsKey(p2.getName())) {
				addPotionEffect(p, 20 * 1 * 60);
			}
		}

		if (wither == 5) {
			while (Glad.emluta.containsKey(p.getName()) && emluta.containsKey(p2.getName())) {
				addPotionEffect(p, 20 * 1 * 60);
			}
		}

		if (recraft == 0) {
			p.getInventory().setItem(14, icone);
			p.getInventory().setItem(15, icone);
			p.getInventory().setItem(16, icone);
			p.getInventory().setItem(23, icone);
			p.getInventory().setItem(24, icone);
			p2.getInventory().setItem(14, icone);
			p2.getInventory().setItem(15, icone);
			p2.getInventory().setItem(16, icone);
			p2.getInventory().setItem(23, icone);
			p2.getInventory().setItem(24, icone);
		}

		if (recraft == 1) {
			CreateItem.item(p.getInventory(), p, Material.RED_MUSHROOM, 64, 0, "§cRecraft", null, 14);
			CreateItem.item(p.getInventory(), p, Material.RED_MUSHROOM, 64, 0, "§cRecraft", null, 15);
			CreateItem.item(p.getInventory(), p, Material.BROWN_MUSHROOM, 64, 0, "§cRecraft", null, 16);
			CreateItem.item(p.getInventory(), p, Material.BROWN_MUSHROOM, 64, 0, "§cRecraft", null, 23);
			p.getInventory().setItem(24, icone);
			CreateItem.item(p2.getInventory(), p2, Material.RED_MUSHROOM, 64, 0, "§cRecraft", null, 14);
			CreateItem.item(p2.getInventory(), p2, Material.RED_MUSHROOM, 64, 0, "§cRecraft", null, 15);
			CreateItem.item(p2.getInventory(), p2, Material.BROWN_MUSHROOM, 64, 0, "§cRecraft", null, 16);
			CreateItem.item(p2.getInventory(), p2, Material.BROWN_MUSHROOM, 64, 0, "§cRecraft", null, 23);
			p2.getInventory().setItem(24, icone);
		}
		emluta.put(p.getName(), p2.getName());
		emluta.put(p2.getName(), p.getName());

		item(p);
		item(p2);

		for (int i = 0; i < 34; i++) {

			ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
			ItemMeta sopam = sopa.getItemMeta();
			sopam.setDisplayName("§fRecraft");
			ArrayList<String> sopal = new ArrayList<>();

			sopal.add(null);
			sopam.setLore(sopal);
			sopa.setItemMeta(sopam);
			p.getInventory().addItem(sopa);
			p2.getInventory().addItem(sopa);

		}

	}

	private static void addPotionEffect(Player p, int timer) {

		new BukkitRunnable() {

			@Override
			public void run() {

				p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 9999, 1), true);

			}
		}.runTaskLater(Main.plugin, timer);

	}

	private static void item(Player p) {
		CreateItem.item(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null, 18);
		CreateItem.item(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null, 19);
		CreateItem.item(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null, 20);
		CreateItem.item(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null, 21);
		CreateItem.item(p.getInventory(), p, Material.BOWL, 64, 0, "§fRecraft", null, 22);
		CreateItem.item(p.getInventory(), p, Material.WOOD, 64, 0, "§cMadeira", null, 8);
		CreateItem.item(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null, 9);
		CreateItem.item(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null, 10);
		CreateItem.item(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null, 11);
		CreateItem.item(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null, 12);
		CreateItem.item(p.getInventory(), p, Material.BOWL, 64, 0, "§fRecraft", null, 13);
		CreateItem.item(p.getInventory(), p, Material.COBBLE_WALL, 64, 0, "§6Castelo", null, 1);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 2);
		CreateItem.item(p.getInventory(), p, Material.WATER_BUCKET, 1, 0, "§bAgua", null, 3);
		CreateItem.item(p.getInventory(), p, Material.STONE_AXE, 1, 0, "§cMachado", null, 17);
		CreateItem.item(p.getInventory(), p, Material.IRON_HELMET, 1, 0, "§fArmadura", null, 18);
		CreateItem.item(p.getInventory(), p, Material.IRON_CHESTPLATE, 1, 0, "§fArmadura", null, 19);
		CreateItem.item(p.getInventory(), p, Material.IRON_LEGGINGS, 1, 0, "§fArmadura", null, 20);
		CreateItem.item(p.getInventory(), p, Material.IRON_BOOTS, 1, 0, "§fArmadura", null, 21);
		CreateItem.item(p.getInventory(), p, Material.BOWL, 64, 0, "§fRecraft", null, 22);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 27);
		CreateItem.item(p.getInventory(), p, Material.LAVA_BUCKET, 1, 0, "§cLava", null, 28);
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

}
