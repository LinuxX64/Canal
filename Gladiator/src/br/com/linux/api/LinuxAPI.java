package br.com.linux.api;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;

public class LinuxAPI {

	private static int VERSION = 47;

	public static void Effect(Player p, PotionEffectType PotionEffectTy, int booster, int time) {
		p.addPotionEffect(new PotionEffect(PotionEffectTy, time * 20, booster - 1));
	}

	public static void removeGladiatorEffect(Player p) {
		p.removePotionEffect(PotionEffectType.WITHER);
	}

	public static ItemStack Skull(String nome, String owner) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM);
		skull.setDurability((short) 3);
		SkullMeta sm = (SkullMeta) skull.getItemMeta();
		sm.setOwner(owner);
		sm.setDisplayName(nome);
		skull.setItemMeta(sm);
		return skull;
	}

	public static ItemStack SkullL(String nome, String owner, String[] lore) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM);
		skull.setDurability((short) 3);
		SkullMeta sm = (SkullMeta) skull.getItemMeta();
		sm.setLore(Arrays.asList(lore));
		sm.setOwner(owner);
		sm.setDisplayName(nome);
		skull.setItemMeta(sm);
		return skull;
	}

	public static ItemStack IL(Material m, String nome, int shrt, int qnt, String[] lore) {
		ItemStack x = new ItemStack(m, qnt, (short) shrt);
		ItemMeta x2 = x.getItemMeta();
		x2.setDisplayName(nome);
		x2.setLore(Arrays.asList(lore));
		x.setItemMeta(x2);
		return x;
	}

	public static ItemStack PSN(int qnt, PotionType pt, boolean splash, boolean duration) {
		ItemStack item = new ItemStack(Material.POTION, qnt);
		Potion pot = new Potion(1);
		pot.setType(pt);
		pot.setHasExtendedDuration(duration);
		pot.setSplash(splash);
		pot.apply(item);
		return item;
	}

	public static ItemStack P(String nome, int qnt, PotionType pt, boolean splash, boolean duration) {
		ItemStack item = new ItemStack(Material.POTION, qnt);
		ItemMeta x2 = item.getItemMeta();
		item.setItemMeta(x2);
		x2.setDisplayName(nome);
		Potion pot = new Potion(1);
		pot.setType(pt);
		pot.setHasExtendedDuration(duration);
		pot.setSplash(splash);
		pot.apply(item);
		return item;
	}

	public static ItemStack PL(String nome, int qnt, PotionType pt, boolean splash, boolean duration, String[] lore) {
		ItemStack item = new ItemStack(Material.POTION, qnt);
		ItemMeta x2 = item.getItemMeta();
		x2.setLore(Arrays.asList(lore));
		x2.setDisplayName(nome);
		item.setItemMeta(x2);
		Potion pot = new Potion(1);
		pot.setType(pt);
		pot.setHasExtendedDuration(duration);
		pot.setSplash(splash);
		pot.apply(item);
		return item;
	}

	public static ItemStack PSNND(int qnt, PotionType pt, boolean splash) {
		ItemStack item = new ItemStack(Material.POTION, qnt);
		Potion pot = new Potion(1);
		pot.setType(pt);
		pot.setSplash(splash);
		pot.apply(item);
		return item;
	}

	public static ItemStack I(Material m, String nome, int shrt, int qnt) {
		ItemStack x = new ItemStack(m, qnt, (short) shrt);
		ItemMeta x2 = x.getItemMeta();
		x2.setDisplayName(nome);
		x.setItemMeta(x2);
		return x;
	}

	public static ItemStack ISN(Material m, int shrt, int qnt) {
		ItemStack x = new ItemStack(m, qnt, (short) shrt);
		ItemMeta x2 = x.getItemMeta();
		x.setItemMeta(x2);
		return x;
	}

	public static ItemStack ILE(Material m, String nome, int shrt, int qnt, String[] lore, Enchantment encht, int nvl) {
		ItemStack x = new ItemStack(m, qnt, (short) shrt);
		ItemMeta x2 = x.getItemMeta();
		x2.setDisplayName(nome);
		x2.setLore(Arrays.asList(lore));
		x2.addEnchant(encht, nvl, true);
		x.setItemMeta(x2);
		return x;
	}

	public static ItemStack IE(Material m, String nome, int shrt, int qnt, Enchantment encht, int nvl) {
		ItemStack x = new ItemStack(m, qnt, (short) shrt);
		ItemMeta x2 = x.getItemMeta();
		x2.setDisplayName(nome);
		x2.addEnchant(encht, nvl, true);
		x.setItemMeta(x2);
		return x;
	}

	public static void lotar(Inventory inv, ItemStack item) {
		ItemStack[] is;
		int restante = (is = inv.getContents()).length;
		for (int i = 0; i < restante; i++) {
			ItemStack item2 = is[i];
			if (item2 == null) {
				inv.setItem(inv.firstEmpty(), item);
			}
		}
	}

	public static void sendTitle(Player p, String title) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
	}

	public static void sendSubTitle(Player p, String subtitle) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(subtitle)));
	}
}
