package br.com.linux.utils;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;

public class TabList {
	public static void broadcastHeader(String header) {
		broadcastHeaderAndFooter(header, null);
	}

	public static void broadcastFooter(String footer) {
		broadcastHeaderAndFooter(null, footer);
	}

	@SuppressWarnings("deprecation")
	public static void broadcastHeaderAndFooter(String header, String footer) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			setHeaderAndFooter(player, header, footer);
		}
	}

	public static void setHeader(Player p, String header) {
		setHeaderAndFooter(p, header, null);
	}

	public static void setFooter(Player p, String footer) {
		setHeaderAndFooter(p, null, footer);
	}

	public static void setHeaderAndFooter(Player p, String rawHeader, String rawFooter) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < 47) {
			return;
		}
		CraftPlayer player = (CraftPlayer) p;
		IChatBaseComponent header = ChatSerializer.a(TextConverter.convert(rawHeader));
		IChatBaseComponent footer = ChatSerializer.a(TextConverter.convert(rawFooter));
		ProtocolInjector.PacketTabHeader packet = new ProtocolInjector.PacketTabHeader(header, footer);
		player.getHandle().playerConnection.sendPacket(packet);
	}

	private static class TextConverter {
		public static String convert(String text) {
			if ((text == null) || (text.length() == 0)) {
				return "\"\"";
			}
			int len = text.length();
			StringBuilder sb = new StringBuilder(len + 4);

			sb.append('"');
			for (int i = 0; i < len; i++) {
				char c = text.charAt(i);
				switch (c) {
				case '"':
				case '\\':
					sb.append('\\');
					sb.append(c);
					break;
				case '/':
					sb.append('\\');
					sb.append(c);
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\r':
					sb.append("\\r");
					break;
				default:
					if (c < ' ') {
						String t = "000" + Integer.toHexString(c);
						sb.append("\\u").append(t.substring(t.length() - 4));
					} else {
						sb.append(c);
					}
					break;
				}
			}
			sb.append('"');
			return sb.toString();
		}
	}
}