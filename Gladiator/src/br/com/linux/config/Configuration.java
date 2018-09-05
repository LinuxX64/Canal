package br.com.linux.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;

import br.com.linux.Main;


@SuppressWarnings("unchecked")

public enum Configuration {
	PREFIX(getValue("Prefix").replace("  ", " ").replace("&", "§").replace("{seta}", "»")), SEMP(
			getValue("SemPerm").replace("  ", " ").replace("&", "§")), SITE(getValue("Site")), MOTD(getValue("Motd").replace("&", "§"));

	private String message;
	private boolean active;
	private int value;
	private List<String> stringList;
	private Long expire;
	private Location location;

	public String getString(String path) {
		return getValue(path);
	}

	private Configuration(String message) {
		this.message = message;
	}

	private Configuration(Location location) {
		this.location = location;
	}

	private Configuration(boolean active) {
		this.active = active;
	}

	private Configuration(int value) {
		this.value = value;
	}

	private Configuration(List<String> stringList) {
		this.stringList = stringList;
	}

	private Configuration(Long expire) {
		this.expire = expire;
	}

	public String getMessage() {
		return message;
	}

	public boolean isActive() {
		return active;
	}

	public int getValue() {
		return value;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public Long getExpire() {
		return expire;
	}

	public Location getLocation() {
		return location;
	}

	public static void debug(String message) {
	}

	public static String getValue(String path) {
		if (Main.saveConfiguration.containsKey(path)) {
			return (String) Main.saveConfiguration.get(path);
		}
		if (Main.getPlugin().getConfig().getString(path) != null) {
			Main.saveConfiguration.put(path,
					Main.getPlugin().getConfig().getString(path).replace("{linha}", "\n"));
			debug("A configuracao " + path + " foi carregada!");
			return Main.getPlugin().getConfig().getString(path).replace("{linha}", "\n");
		}
		debug("Nao foi possivel carregar a config " + path.toLowerCase().replace("_", "-") + "§f.");
		return "[NOT FOUND: " + path + "]";
	}

	public static Long getExpire(String path, boolean saved) {
		if ((saved) && (Main.saveConfiguration.containsKey(path))) {
			return (Long) Main.saveConfiguration.get(path);
		}

		if (Main.getPlugin().getConfig().getString(path) != null) {
			if (saved) {
				Main.saveConfiguration.put(path, Long.valueOf(Main.getPlugin().getConfig().getLong(path)));
			}
			debug("A configuracao " + path + " foi carregada!");
			return Long.valueOf(Main.getPlugin().getConfig().getLong(path));
		}
		return Long.valueOf(-1L);
	}

	public static boolean getBoolean(String path) {
		if (Main.saveConfiguration.containsKey(path)) {
			return ((Boolean) Main.saveConfiguration.get(path)).booleanValue();
		}

		if (Main.getPlugin().getConfig().contains(path)) {
			debug("A configuracao " + path + " foi carregada!");
			Main.saveConfiguration.put(path, Boolean.valueOf(Main.getPlugin().getConfig().getBoolean(path)));
			return Main.getPlugin().getConfig().getBoolean(path);
		}
		debug("Nao foi possivel carregar a config " + path.toLowerCase().replace("_", "-") + "§f.");
		return false;
	}

	public static int getInteger(String path) {
		if (Main.saveConfiguration.containsKey(path)) {
			return ((Integer) Main.saveConfiguration.get(path)).intValue();
		}

		if (Main.getPlugin().getConfig().contains(path)) {
			debug("A configuracao " + path + " foi carregada!");
			Main.saveConfiguration.put(path, Integer.valueOf(Main.getPlugin().getConfig().getInt(path)));
			return Main.getPlugin().getConfig().getInt(path);
		}
		debug("Nao foi possivel carregar a config " + path.toLowerCase().replace("_", "-") + "§f.");
		return new Random().nextInt(1);
	}

	public static double getDouble(String path) {
		if (Main.saveConfiguration.containsKey(path)) {
			return ((Double) Main.saveConfiguration.get(path)).doubleValue();
		}

		if (Main.getPlugin().getConfig().contains(path)) {
			debug("A configuracao " + path + " foi carregada!");
			Main.saveConfiguration.put(path, Double.valueOf(Main.getPlugin().getConfig().getDouble(path)));
			return Main.getPlugin().getConfig().getDouble(path);
		}
		debug("Nao foi possivel carregar a config " + path.toLowerCase().replace("_", "-") + "§f.");
		return new Random().nextInt(5);
	}

	@SuppressWarnings({ "rawtypes" })
	public static List<String> getStringList(String path) {
		if (Main.saveConfiguration.containsKey(path)) {
			return (List) Main.saveConfiguration.get(path);
		}

		if (Main.getPlugin().getConfig().contains(path)) {
			debug("A configuracao " + path + " foi carregada!");
			Main.saveConfiguration.put(path, Integer.valueOf(Main.getPlugin().getConfig().getInt(path)));
			return Main.getPlugin().getConfig().getStringList(path);
		}
		debug("Nao foi possivel carregar a config " + path.toLowerCase().replace("_", "-") + "§f.");
		return new ArrayList();
	}
}
