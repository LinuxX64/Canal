package br.com.linux.api;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import br.com.linux.Main;

public class API {

	public static void TranferirJogador(Player p, String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
	}

	public static ItemStack criarItem(Player p, Material material, String nome, String[] lore, int quantidade,
			short cor) {
		ItemStack item = new ItemStack(material, quantidade, cor);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);

		return item;
	}

	@SuppressWarnings("deprecation")
	public static void sendWarn(String msg) {
		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (todos.hasPermission("warn.ver")) {
				todos.sendMessage(msg);
				return;
			}
		}

	}

	public static int getAmount(Player p, Material m) {
		int amount = 0;
		for (ItemStack item : p.getInventory().getContents()) {
			if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
				amount += item.getAmount();
			}
		}
		return amount;
	}
}
