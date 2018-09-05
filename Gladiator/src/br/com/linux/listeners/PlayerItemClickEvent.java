package br.com.linux.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.linux.Main;

public class PlayerItemClickEvent implements Listener {

	public static HashMap<Player, String> desafiar = new HashMap<>();
	public static ArrayList<String> dawn = new ArrayList<>();
	public static ArrayList<String> dawn1 = new ArrayList<>();

	public static HashMap<Player, String> desafiar1 = new HashMap<>();
	public static ArrayList<String> clicado = new ArrayList<>();
	public static ArrayList<String> clicado2 = new ArrayList<>();
	public static ArrayList<String> ranked = new ArrayList<>();

	public static UUID toFight;
	public static UUID toFight1;
	public static UUID toFight2;

	@EventHandler
	public void cliqueGlad1(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		Player clike = (Player) e.getRightClicked();
		ItemStack item = p.getItemInHand();

		if (item.getType() == Material.IRON_FENCE) {
			if (item.getItemMeta().getDisplayName().equals("§aDesafiar Gladiator §8(Clique)")) {
				if (dawn.contains(clike.getName())) {
					p.sendMessage("§cAguarde para poder desafiar novamente!");
					return;
				}
				if (desafiar.containsKey(clike)) {
					Main.startGlad(clike, p);
					desafiar.remove(p);
					desafiar.remove(clike);
					return;
				}
				p.sendMessage("§aVocê convidou §7" + clike.getName() + " §apara um 1v1 normal!");
				clike.sendMessage("§aVocê recebeu um desafio de §7" + p.getName() + " §apara um 1v1 normal!");
				desafiar.put(p, clike.getName());
				dawn.add(clike.getName());
			}

			Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
				public void run() {
					desafiar.remove(p);
					dawn.remove(clike.getName());
				}
			}, 8 * 20);
		}

	}

	@EventHandler
	public void cliqueGlad11(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		ItemStack item = p.getItemInHand();

		if (item.getType() == Material.CHEST) {
			if (item.getItemMeta().getDisplayName().equals("§aGladiator Customizado §8(Clique)")) {
				p.sendMessage("§c§lERRO §fEste modo de gladiator estará disponivel em breve.");
			}
		}
	}

	public static ItemStack createMenuItem(Material material, String nome, String[] habilidade) {

		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void register2(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInHand();
		if (item.getType() == Material.getMaterial(262)) {
			if (item.getItemMeta().getDisplayName().equals("§aConfigurações §8(Clique)")) {
				Inventory inv = Bukkit.createInventory(p, 27, "§7Preferências");

				inv.setItem(10,
						createMenuItem(Material.BOOK, "§e§lScoreBoard",
								new String[] { "§7Desative a sua §escoreboard e tenha",
										"§7um ganho significativo em seus frames!", " ",
										"§aClique para desativar sua scoreboard." }));
				inv.setItem(12,
						createMenuItem(Material.SLIME_BALL, "§e§lLimpar gladiator",
								new String[] { "§7Limpe a arena §egladiator de tempo",
										"§7em tempo e termine mais rápido!", " ", "§aClique para aumentar o tempo." }));

				p.openInventory(inv);

			}

		}

	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void lInventorieClickEvent12(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		if ((e.getInventory().getTitle().equalsIgnoreCase("§7Preferências")) && (item != null)
				&& (item.getTypeId() != 0)) {
			e.setCancelled(true);
			if ((item.getType() == Material.SLIME_BALL) && (item.getItemMeta().getDisplayName().equals("§e§lLimpar gladiator"))) {
				p.sendMessage("§c§lERRO §fEste modo estará disponivel em breve.");
				p.closeInventory();
			}
			if (item.getType() == Material.BOOK && item.getItemMeta().getDisplayName().equals("§e§lScoreBoard")) {
				p.sendMessage("§c§lERRO §fEste modo estará disponivel em breve.");
				return;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void register(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInHand();
		if (item.getType() == Material.getMaterial(351)) {
			if (item.getItemMeta().getDisplayName().equals("§aPartida rápida §8(Clique)")) {
				ItemStack icone = new ItemStack(351, 1, (short) 10);
				ItemMeta iconem = icone.getItemMeta();
				iconem.setDisplayName("§aProcurando partidas rápidas...");
				icone.setItemMeta(iconem);
				p.updateInventory();
				p.setItemInHand(icone);
				p.sendMessage("§a§LBATALHA RÁPIDA §fVocê §a§LENTROU §fna fila do Gladiator rápido!");
				toFight1 = null;
				if (toFight == null) {
					toFight = p.getUniqueId();
					return;
				} else {
					Player playerToFight = Bukkit.getPlayer(toFight);
					Main.startGlad(p, playerToFight);
					p.sendMessage("§a§lBATALHA §FBatalha encontrada contra: §e" + playerToFight.getName());
					playerToFight.sendMessage("§a§lBATALHA §FBatalha encontrada contra: §e" + p.getName());
					toFight = null;
					toFight1 = null;

				}

			}

		}

		if (item.getType() == Material.getMaterial(351)) {
			if (item.getItemMeta().getDisplayName().equals("§aProcurando partidas rápidas...")) {
				ItemStack icone = new ItemStack(351, 1, (short) 8);
				ItemMeta iconem = icone.getItemMeta();
				iconem.setDisplayName("§aPartida rápida §8(Clique)");
				icone.setItemMeta(iconem);
				p.setItemInHand(icone);
				p.updateInventory();
				p.sendMessage("§a§lBATALHA RÁPIDA §fVocê §c§LSAIU §fna fila do Gladiator rápido!");

				toFight = null;
				toFight1 = null;

			}
		}

	}
}
