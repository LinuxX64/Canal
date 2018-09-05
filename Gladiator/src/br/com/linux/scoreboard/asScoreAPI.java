package br.com.linux.scoreboard;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import br.com.linux.Glad;
import br.com.linux.config.Config;

@SuppressWarnings({ "unchecked", "rawtypes" })

public class asScoreAPI {
	public asScoreAPI() {
	}

	public static ArrayList<String> Score = new ArrayList();
	public static ArrayList<Player> Delay = new ArrayList();

	public static String getRank(Player p) {
		double a = Config.getWins(p);
		if (a <= 100.0D) {
			return "§f-";
		}
		if (a <= 200.0D) {
			return "§a☰";
		}
		if (a <= 300.0D) {
			return "§e☲";
		}
		if (a <= 400.0D) {
			return "§6✶";
		}
		if (a <= 500.0D) {
			return "§b✳";
		}
		if (a <= 600.0D) {
			return "§5✹";
		}
		if (a <= 700.0D) {
			return "§c✪";
		}
		if (a <= 1000.0D) {
			return "§4✪";
		}
		return "§4✪";
	}

	public static String getRankConfig(Player p) {
		double a = Config.getWins(p);
		if (a <= 100.0D) {
			return "§fUNRANKED";
		}
		if (a <= 200.0D) {
			return "§aPRYMARY";
		}
		if (a <= 300.0D) {
			return "§eBRONZE";
		}
		if (a <= 400.0D) {
			return "§6OURO";
		}
		if (a <= 500.0D) {
			return "§7DIAMOND";
		}
		if (a <= 600.0D) {
			return "§6ELITE";
		}
		if (a <= 700.0D) {
			return "§bMASTER";
		}
		if (a <= 1000.0D) {
			return "§4RUBY";
		}
		return "§4RUBY";
	}

	public static String getNomeRank(Player p) {
		double a = Config.getWins(p);
		if (a <= 100.0D) {
			return "§fUNRANKED";
		}
		if (a <= 200.0D) {
			return "§aPRYMARY";
		}
		if (a <= 300.0D) {
			return "§eBRONZE";
		}
		if (a <= 400.0D) {
			return "§6OURO";
		}
		if (a <= 500.0D) {
			return "§7DIAMOND";
		}
		if (a <= 600.0D) {
			return "§6ELITE";
		}
		if (a <= 700.0D) {
			return "§bMASTER";
		}
		if (a <= 1000.0D) {
			return "§4RUBY";
		}
		return "§4RUBY";
	}

	public static void setScore(Player p) {
		if (Score.contains(p.getName())) {

		}
		ScoreAPI score = new ScoreAPI("   §6§lGLADIATOR-1   ");
		score.blankLine();
		score.addLinha("§7Wins: §b" + Config.getWins(p));
		score.addLinha("§7Deaths: §b" + Config.getDeaths(p));
		score.addLinha("§7Winstreak: §b" + Config.getWinsStreak(p));
		score.blankLine();
		score.addLinha("§7XP: §b" + Config.getElo(p));
		score.addLinha("§7Liga: §b" + getRank(p) + " " + getNomeRank(p));
		score.blankLine();
		score.addLinha("§7Batalhando contra:");
		score.addLinha("§3Ninguém");
		score.blankLine();
		score.addLinha("§6www.hastymc.com.br");
		score.build();
		score.send(p);
	}


	public static void setScore1(Player p) {
		if (Score.contains(p.getName())) {
		}
		ScoreAPI score = new ScoreAPI("   §6§lGLADIATOR-1   ");
		score.blankLine();
		score.addLinha("§7Wins: §b" + Config.getWins(p));
		score.addLinha("§7Deaths: §b" + Config.getDeaths(p));
		score.addLinha("§7Winstreak: §b" + Config.getWinsStreak(p));
		score.blankLine();
		score.addLinha("§7XP: §b" + Config.getElo(p));
		score.addLinha("§7Liga: §b" + getRank(p) + " " + getNomeRank(p));
		score.blankLine();
		score.addLinha("§7Batalhando contra:");
		score.addLinha("§3" + Glad.getPlayerLuta(p));
		score.blankLine();
		score.addLinha("§6www.hastymc.com.br");
		score.build();
		score.send(p);
	}


	public static void setScore2(Player p) {
		if (Score.contains(p.getName())) {

		}
		ScoreAPI score = new ScoreAPI("   §6§lGLADIATOR-1   ");
		score.blankLine();
		score.addLinha("§7Wins: §b" + Config.getWins(p));
		score.addLinha("§7Deaths: §b" + Config.getDeaths(p));
		score.addLinha("§7Winstreak: §b" + Config.getWinsStreak(p));
		score.blankLine();
		score.addLinha("§7XP: §b" + Config.getElo(p));
		score.addLinha("§7Liga: §b" + getRank(p) + " " + getNomeRank(p));
		score.blankLine();
		score.addLinha("§7Batalhando contra:");
		score.addLinha("§3" + Glad.getPlayerLuta(p));
		score.blankLine();
		score.addLinha("§6www.hastymc.com.br");
		score.build();
		score.send(p);
	}
}
