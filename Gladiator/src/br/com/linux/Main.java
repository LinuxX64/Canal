package br.com.linux;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;
	public static Plugin instance;

	public static String semp = "§c§lERRO §fVocê não tem §3§lACESSO §fa esse comando.";

	public static Plugin getPlugin() {
		return plugin;
	}

	public static Plugin getInstance() {
		return instance;
	}

}
