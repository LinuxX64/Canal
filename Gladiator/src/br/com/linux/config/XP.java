package br.com.linux.config;

public class XP {

	public static void setXP(String nome, int valor) {
		Config.stats.set("Status." + nome + ".XP", valor);
		Config.stats.saveConfig();
	}

	public static void addXP(String nome, int valor) {
		Config.stats.set("Status." + nome + ".XP", getXp(nome) + valor);
		Config.stats.saveConfig();
	}

	public static void RemoveXPTotal(String nome) {
		Config.stats.set("Status." + nome + ".XP", 0);
		Config.stats.saveConfig();
	}
	
	public static int getXp(String nome){
		return Config.stats.getInt("Status." + nome + ".XP");
	}
	public static void RemoveXP(String nome, int valor) {
		Config.stats.set("Status." + nome + ".XP", getXp(nome) - valor);
		Config.stats.saveConfig();
	}
}
