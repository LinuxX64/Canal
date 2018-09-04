package br.com.linux.api;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem {

	public static ItemStack item(Inventory inv, Player p, Material item, int quantidade, int data, String nome,
			String description, int slot) {

		ItemStack icone = new ItemStack(item, quantidade, (short) data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(description);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		inv.setItem(slot, icone);
		return icone;

	}

	public static ItemStack item2(Inventory inv, Player p, Material item, int quantidade, int data, String nome,
			String description) {

		ItemStack icone = new ItemStack(item, quantidade, (short) data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		if (lore != null) {
			lore.add(description);
		}
		iconem.setLore(lore);
		icone.setItemMeta(iconem);
		return icone;

	}

	public static ItemStack itemenchant(Inventory inv, Player p, Material item, int quantidade, int data, String nome,
			String description, int slot, Enchantment enchant, int levelenchant) {

		ItemStack icone = new ItemStack(item, quantidade, (short) data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(description);

		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		inv.setItem(slot, icone);
		icone.addEnchantment(enchant, levelenchant);
		return icone;
	}

	public static void bau(Inventory inv, Material item, int quantidade, int data, String nome, String description,
			int slot) {

		ItemStack icone = new ItemStack(item, quantidade, (short) data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		if (lore != null) {
			lore.add(description);
		}
		iconem.setLore(lore);
		icone.setItemMeta(iconem);

		inv.setItem(slot, icone);

	}

}
