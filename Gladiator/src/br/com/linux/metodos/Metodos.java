package br.com.linux.metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.ProtocolInjector;

import com.mysql.jdbc.PreparedStatement;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class Metodos {

	/* Metodos principais. */

	public static String Prefix() {
		return "§6§lHasty§f§lMC §7» ";
	}

	public static String PrefixModo() {
		return "§6§lHasty§f§lMC §7» Gladiator";
	}

	public static String PrefixTitle() {
		return "§6§lHasty§f§lMC §7»";
	}

	public static String WebSite() {
		return "www.hastymc.com.br";
	}

	/* Error Methods ( General ) */

	public static String getWithoutPermissionMessage() {
		return Prefix() + "§cVocê não tem permissão de acesso ao comando.";
	}

	public static String getWrongArgumentMessage(String correctUsage) {
		return "" + Prefix() + "§cOcorreu um erro! " + "§cCausa: Argumentação incorreta. " + "§cUso correto: "
				+ correctUsage + "\n ";
	}

	@SuppressWarnings("null")
	public static List<String> getTopsKills() {
		PreparedStatement stm = null;
		List<String> tops = new ArrayList<String>();

		try {
			// stm = con.prepareStatement("SELECT * FROM `kills´ ORDER BY `amount` DESC");
			ResultSet rs = stm.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i <= 9)
					;
				i++;
				tops.add("§7" + i + "° §6" + rs.getString("player") + ":§e " + rs.getInt("amount") + " WINS");

			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(Prefix() + "§cNÃO FOI POSSÍVEL CARREGAR O TOP WINS.");
		}
		return tops;
	}

	public static String getPlayerOfflineMessage(String offlineName) {
		return Prefix() + "§cO jogador §f" + offlineName + "§c não está online!";
	}

	public static String getCommandOnlyForPlayersMessage() {
		return "§cEste comando só pode ser executado por jogadores.";
	}

	/* Broadcast Methods */

	@SuppressWarnings("deprecation")
	public static void sendBroadcast(String message) {
		for (Player players : Bukkit.getOnlinePlayers())
			players.sendMessage(message);
	}

	@SuppressWarnings("deprecation")
	public static void sendActionBar(Player player, String message) {
		if (player != null) {
			if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() > 46) {
				IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
				PacketPlayOutChat packet = new PacketPlayOutChat(cbc);
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
			}
		} else {
			for (Player players : Bukkit.getOnlinePlayers())
				sendActionBar(players, message);
		}
	}

	@SuppressWarnings("deprecation")
	public static void sendClick(Player player, String message, String messageClick, String message2, String cmd) {
		if (player != null) {
			IChatBaseComponent comp = ChatSerializer.a("{\"text\":\"" + message + "\",\"extra\":[{\"text\":\""
					+ messageClick + "\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + message2
					+ "\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + cmd + "\"}}]}");
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		} else {
			for (Player players : Bukkit.getOnlinePlayers())
				sendClick(players, message, messageClick, message2, cmd);
		}
	}

	@SuppressWarnings("deprecation")
	public static void sendTitle(Player player, String message, String message2) {
		if (player != null) {
			if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() >= 46) {
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
						ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(message)));
				((CraftPlayer) player).getHandle().playerConnection
						.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE,
								ChatSerializer.a("{\"text\": \"\"}").a(message2)));
			}
		} else {
			for (Player players : Bukkit.getOnlinePlayers())
				sendTitle(players, message, message2);
		}
	}

}