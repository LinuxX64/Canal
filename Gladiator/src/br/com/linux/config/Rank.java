package br.com.linux.config;

import java.util.HashMap;

public class Rank {

	public static HashMap<String, Ranks> rank = new HashMap<String, Ranks>();

	public static void setRank(String nome, Ranks ranks) {
		rank.put(nome, ranks);
	}

	public static void removeRank(String nome) {
		rank.put(nome, Ranks.Unranked);
	}
}
