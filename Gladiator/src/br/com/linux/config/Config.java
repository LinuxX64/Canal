package br.com.linux.config;

import org.bukkit.entity.Player;

import br.com.linux.Main;
import br.com.linux.api.LinuxConfig;

public class Config {

	public static LinuxConfig stats = new LinuxConfig(Main.getPlugin(Main.class), "stats.yml");
	public static LinuxConfig config = new LinuxConfig(Main.getPlugin(Main.class), "config.yml");

	public static int getDeaths(Player player) {
		return stats.getInt("Status." + player.getName() + ".Deaths");
	}

	public static int getWins(Player player) {
		return stats.getInt("Status." + player.getName() + ".Wins");
	}

	public static int getWinsStreak(Player player) {
		return stats.getInt("Status." + player.getName() + ".WinStreak");
	}

	public static int getElo(Player player) {
		return stats.getInt("Status." + player.getName() + ".Elo");
	}

	public static void addWins(Player p) {
		Config.stats.set("Status." + p.getName() + ".Wins", Config.getWins(p) + 1);

	}

	public static void addDeaths(Player p) {
		Config.stats.set("Status." + p.getName() + ".Deaths", Config.getDeaths(p) + 1);
	}

	public static void addWinsStreak(Player p) {
		Config.stats.set("Status." + p.getName() + ".WinStreak", Config.getWinsStreak(p) + 1);
	}

	public static void addWins(Player p, int quantia) {
		Config.stats.set("Status." + p.getName() + ".Wins", Config.getWins(p) + quantia);
	}

	public static void addElo(Player p, int quantia) {
		Config.stats.set("Status." + p.getName() + ".Elo", Config.getElo(p) + quantia);
	}

	public static void addDeaths(Player p, int quantia) {
		Config.stats.set("Status." + p.getName() + ".Deaths", Config.getDeaths(p) + quantia);
	}

	public static void setWinsStreak(Player p, int quantia) {
		Config.stats.set("Status." + p.getName() + ".WinStreak", Config.getWinsStreak(p) + quantia);
	}

	public static void addElo(Player player) {
		Config.stats.set("Status." + player.getName() + ".Elo", Config.getElo(player) + 1);
	}
}
