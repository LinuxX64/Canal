package br.com.linux.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class APIGrupos {

	public static String Cargo(final Player p) {
		if (p.hasPermission("hasty.dono")) {
			return "DONO";

		} else if (p.hasPermission("hasty.diretor")) {
			return "DIRETOR";

		} else if (p.hasPermission("hasty.admin")) {
			return "ADMIN";

		} else if (p.hasPermission("hasty.gerente")) {
			return "GERENTE";

		} else if (p.hasPermission("hasty.modplus")) {
			return "MOD+";

		} else if (p.hasPermission("hasty.mod")) {
			return "MOD";

		} else if (p.hasPermission("hasty.youtuberplus")) {
			return "YOUTUBER+";

		} else if (p.hasPermission("hasty.trial")) {
			return "TRIALMOD";

		} else if (p.hasPermission("hasty.builder")) {
			return "BUILDER";

		} else if (p.hasPermission("hasty.youtuber")) {
			return "YOUTUBER";

		} else if (p.hasPermission("hasty.legend")) {
			return "LEGEND";

		} else if (p.hasPermission("hasty.extreme")) {
			return "EXTREME";

		} else if (p.hasPermission("hasty.pro")) {
			return "PRO";

		} else if (p.hasPermission("hasty.low")) {
			return "LOW";
		}
		return ChatColor.GRAY + "Membro";
	}

	public static String Cargo1(final Player p) {
		if (p.hasPermission("hasty.dono")) {
			return ChatColor.DARK_RED + ChatColor.BOLD.toString() + "DONO";

		} else if (p.hasPermission("hasty.diretor")) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "DIRETOR";

		} else if (p.hasPermission("hasty.admin")) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "ADMIN";

		} else if (p.hasPermission("hasty.gerente")) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "GERENTE";

		} else if (p.hasPermission("hasty.modplus")) {
			return ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "MOD+";

		} else if (p.hasPermission("hasty.mod")) {
			return ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "MOD";

		} else if (p.hasPermission("hasty.youtuberplus")) {
			return ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "YOUTUBER+";

		} else if (p.hasPermission("hasty.trial")) {
			return ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "TRIALMOD";

		} else if (p.hasPermission("hasty.builder")) {
			return ChatColor.YELLOW + ChatColor.BOLD.toString() + "BUILDER";

		} else if (p.hasPermission("hasty.youtuber")) {

		} else if (p.hasPermission("hasty.legend")) {
			return ChatColor.DARK_BLUE + ChatColor.BOLD.toString() + "LEGEND";

		} else if (p.hasPermission("hasty.extreme")) {
			return ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "EXTREME";

		} else if (p.hasPermission("hasty.pro")) {
			return ChatColor.GOLD + ChatColor.BOLD.toString() + "PRO";

		} else if (p.hasPermission("hasty.low")) {
			return ChatColor.GREEN + ChatColor.BOLD.toString() + "LOW";
		}
		return ChatColor.GRAY + "Membro";
	}
}