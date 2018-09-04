package br.com.linux.config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinConfig implements Listener {

	@EventHandler
	public void Criarconfig(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		if (!Config.stats.contains("Status." + p.getName())) {
			Config.stats.set("Status." + p.getName() + ".Wins", Config.getWins(p));
			Config.stats.set("Status." + p.getName() + ".Deaths", Config.getDeaths(p));
			Config.stats.set("Status." + p.getName() + ".Elo", Config.getElo(p));
			Config.stats.set("Status." + p.getName() + ".Rank", "UNRANKED");
			Config.stats.set("Status." + p.getName() + ".WinStreak", Config.getWinsStreak(p));
			Config.stats.set("Status." + p.getName() + ".Nick", p.getName());
			Config.stats.saveConfig();
		}

		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "UNRANKED") {
			Rank.setRank(p.getName(), Ranks.Unranked);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Carvão") {
			Rank.setRank(p.getName(), Ranks.Carvão);
			Config.stats.saveConfig();
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Prata") {
			Rank.setRank(p.getName(), Ranks.Prata);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Ouro") {
			Rank.setRank(p.getName(), Ranks.Ouro);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Platina") {
			Rank.setRank(p.getName(), Ranks.Platina);
		}

		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Diamante") {
			Rank.setRank(p.getName(), Ranks.Diamante);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Esmeralda") {
			Rank.setRank(p.getName(), Ranks.Esmeralda);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Rubi") {
			Rank.setRank(p.getName(), Ranks.Rubi);
		}
		if (Config.stats.getString("Status." + p.getName() + ".Rank") == "Safira") {
			Rank.setRank(p.getName(), Ranks.Safira);
		}
	}
}
