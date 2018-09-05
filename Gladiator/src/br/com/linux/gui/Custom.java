package br.com.linux.gui;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.linux.Glad;

public class Custom implements Listener {

	public static int espada = 0;
	public static int wither = 0;
	public static int glass = 0;
	public static int recraft = 0;
	public static boolean ferramenta = true;

	public static HashMap<String, String> desafiar = new HashMap<>();
	public static ArrayList<String> dawn = new ArrayList<>();
	public static Inventory inv;

	private static ItemStack setInv(Inventory inv, Material item, int quantidade, int data, String nome,
			String description, int set) {

		ItemStack icone = new ItemStack(item, quantidade, (byte) data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(description);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		inv.setItem(set, icone);
		return icone;

	}

	@SuppressWarnings("deprecation")
	public static void OpenInv(Player p) {

		inv = Bukkit.createInventory(null, 36, "§eGladiator CUSTOMIZADO");

		setInv(inv, Material.DIAMOND_SWORD, 1, 0, "§6Espada", "", 9);

		ItemStack icone = new ItemStack(351, 1, (short) 8);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName("§6Configurar espada");
		icone.setItemMeta(iconem);
		p.setItemInHand(icone);

		inv.setItem(18, icone);

		p.updateInventory();
		setInv(inv, Material.SKULL_ITEM, 1, 1, "§cEfeito do wither", "0 minutos.", 4);
		setInv(inv, Material.GLASS, 1, 0, "§cBloco da arena", "§7VIDRO:", 13);
		setInv(inv, Material.STONE_PICKAXE, 1, 0, "§cFerramentas", "§aSim", 15);
		setInv(inv, Material.STAINED_GLASS_PANE, 1, 4, "§eEnviar", "§7Envie para o jogador.", 26);
		setInv(inv, Material.INK_SACK, 1, 3, "§cRecraft", "§7COCOA BEANS", 22);

		p.openInventory(inv);

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	private void eventItem1(InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();

		if (item.getType() == Material.STAINED_GLASS_PANE) {
			if (item.getItemMeta().getDisplayName().equals("§eEnviar")) {
				for (Player online : Bukkit.getOnlinePlayers()) {
					if (desafiar.containsKey(online.getName())) {
						Glad.SpawnRandomBattle(p, online, wither, espada, glass, recraft, ferramenta);
						desafiar.remove(p.getName());
						desafiar.remove(online.getName());
					}
				}

				p.closeInventory();
			}
		}
	}

	@EventHandler
	private void eventItem(InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		ItemStack item = e.getCurrentItem();

		if ((e.getInventory().getName() == "§eGladiator CUSTOMIZADO")) {
			if (item.getType() == Material.SKULL_ITEM) {
				if (wither == 0) {
					wither++;
					item.getItemMeta().setDisplayName("§70 minutos de wither");
					e.setCancelled(true);
				} else {
					if (wither == 1) {
						wither = 3;
						setInv(inv, Material.SKULL_ITEM, 1, 1, "§cEfeito Wither", "1 minuto", 4);
						e.setCancelled(true);
					} else {
						if (wither == 3) {
							wither = 5;
							setInv(inv, Material.SKULL_ITEM, 1, 1, "§cEfeito Wither", "3 minutos", 4);
							e.setCancelled(true);
						} else {
							if (wither >= 5) {
								wither = 0;
								setInv(inv, Material.SKULL_ITEM, 1, 1, "§cEfeito Wither", "5 minutos", 4);
								e.setCancelled(true);
							}
						}

						if (e.getCurrentItem().getType() == null) {
							return;
						}
					}
				}
			}

			if (e.getCurrentItem().getType() == Material.matchMaterial("§6Configurar espada")) {
				if (espada == 0) {
					espada++;
					e.getInventory().clear();
					setInv(e.getInventory(), Material.WOOD_SWORD, 1, 0, "§6Espada", null, 18);
					e.setCancelled(true);
				} else {
					if (espada == 1) {
						espada++;
						item.addEnchantment(Enchantment.DAMAGE_ALL, 2);
						e.setCancelled(true);
					} else {
						if (espada == 2) {
							espada++;
							item.addEnchantment(Enchantment.DAMAGE_ALL, 3);
							e.setCancelled(true);
						} else {
							if (espada >= 3) {
								espada = 0;
								item.removeEnchantment(Enchantment.DAMAGE_ALL);
								e.setCancelled(true);
							}
						}
					}
				}
			}

			if (item.getType() == Material.GLASS) {
				setInv(inv, Material.BEDROCK, 1, 0, "§aBloco Da Arena?", "§7BEDROCK:", 13);
				e.setCancelled(true);
				glass++;
			}
			if (item.getType() == Material.BEDROCK) {
				setInv(inv, Material.LEAVES, 1, 0, "§aBloco Da Arena?", "§7FOLHA:", 13);
				e.setCancelled(true);
				glass++;
			}
			if (item.getType() == Material.LEAVES) {
				setInv(inv, Material.GLASS, 1, 0, "§aBloco Da Arena?", "§7VIDRO:", 13);
				e.setCancelled(true);
				glass = 0;
			}

			if (item.getType() == Material.STONE_PICKAXE) {
				e.setCancelled(true);
				setInv(inv, Material.WOOD_PICKAXE, 1, 0, "§aFerramentas?", "§cNAO:", 15);
				ferramenta = false;
			}

			if (item.getType() == Material.WOOD_PICKAXE) {
				e.setCancelled(true);
				setInv(inv, Material.STONE_PICKAXE, 1, 0, "§aFerramentas", "§aSIM:", 15);
				ferramenta = false;
			}

			if (item.getType() == Material.INK_SACK) {
				recraft++;
				setInv(inv, Material.RED_MUSHROOM, 1, 0, "§aRecraft", "§7Cogumelos", 22);
				e.setCancelled(true);
			}
			if (item.getType() == Material.RED_MUSHROOM) {
				recraft = 0;
				setInv(inv, Material.INK_SACK, 1, 3, "§cRecraft", "§7Cocoa Beans", 22);
				e.setCancelled(true);
			}
			if (item.getType() == null) {
				return;

			}

		}
	}

	@EventHandler
	public void customclike(PlayerInteractEntityEvent e) {

		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}

		Player p = e.getPlayer();
		Player c = (Player) e.getRightClicked();
		ItemStack item = c.getItemInHand();
		if (item.getType() == null) {
			p.sendMessage("O item é nulo");
			return;
		}
		if (item.getType() == Material.MELON) {
			if (!p.getUniqueId().toString().equalsIgnoreCase("a")) {
				p.sendMessage("§cEm Manutenção!");
				return;
			}
			if (desafiar.containsKey(e.getPlayer().getName())) {
				Glad.SpawnRandomBattle(p, e.getPlayer(), wither, espada, glass, recraft, ferramenta);
				e.setCancelled(true);
				return;
			}
			desafiar.put(c.getName(), e.getPlayer().getName());
			OpenInv(p);
		}

	}
}
