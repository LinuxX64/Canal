 
package br.com.linux.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.ProtocolInjector;

import br.com.linux.Glad;
import br.com.linux.Main;
import br.com.linux.config.Configuration;
import br.com.linux.metodos.Metodos;
import br.com.linux.scoreboard.asScoreAPI;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class PlayerEvent implements Listener {

	public static HashMap<Player, String> damage = new HashMap<>();
	public static ArrayList<String> addelo = new ArrayList<>();
	public static HashMap<String, Integer> players = new HashMap<String, Integer>();

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

	@EventHandler
	public void modificarchat(AsyncPlayerChatEvent evento) {
		Player jogador = evento.getPlayer();

		if (jogador.hasPermission("glad.color")) {
			evento.setFormat(jogador.getDisplayName() + "§7(" + getRank(jogador) + "§7) §f: §7"
					+ evento.getMessage().replace("&", "§").replace("%", " Porcento(s)"));
		} else {
			evento.setFormat(jogador.getDisplayName() + " §7(" + getRank(jogador) + "§7) §f: §7" + evento.getMessage());
		}
		if (jogador.hasPermission("glad.color")) {
			evento.setFormat(jogador.getDisplayName() + " §7(" + getRank(jogador) + "§7) §f: §7" + evento.getMessage());
		} else {
			evento.setFormat(jogador.getDisplayName() + " §7(" + getRank(jogador) + "§7) §f: §7" + evento.getMessage());
		}

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		Main.jogadores.add(p.getUniqueId());
		Metodos.sendTitle(p, "§aBem vindo §a", p.getName() + "§7!");
		PlayerItemClickEvent.dawn.remove(p.getName());
		PlayerItemClickEvent.desafiar.remove(p);
		p.teleport(Bukkit.getWorld("world").getSpawnLocation());
		Glad.emluta.remove(p.getName());
		Main.getitemDefault(p);
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");

		asScoreAPI.Score.add(p.getName());

		asScoreAPI.setScore(p);

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);

		Player p = e.getPlayer();
		if (Glad.emluta.containsKey(p.getName())) {
			Glad.removeArena(p);
			PlayerItemClickEvent.dawn.remove(p.getName());
			PlayerItemClickEvent.desafiar.remove(p);
			p.sendMessage("§cSeu oponente desistiu e deslogou!");
			p.sendMessage("§aVocê ganhou a batalha!");

		}
		Main.jogadores.remove(p.getUniqueId());
		PlayerItemClickEvent.toFight = null;

	}

	@EventHandler
	public void Chuva(WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void noInfos(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if ((e.getMessage().toLowerCase().startsWith("/pl")) || (e.getMessage().toLowerCase().startsWith("/plugins"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:pl"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:plugins"))
				|| (e.getMessage().toLowerCase().startsWith("/about"))
				|| (e.getMessage().toLowerCase().startsWith("/ver"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:about"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:ver"))
				|| (e.getMessage().toLowerCase().startsWith("/help")) || (e.getMessage().toLowerCase().startsWith("/?"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:?"))
				|| (e.getMessage().toLowerCase().startsWith("/bukkit:help"))) {
			p.sendMessage("§fPlugins feito por §e§l@vsfLinux§f. Todos os direitos reservados.");
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMotd(ServerListPingEvent evento) {
		evento.setMaxPlayers(120);
		evento.setMotd(Configuration.MOTD.getMessage() + "");
	}

	@EventHandler
	public void onsopa(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		Damageable hp = p;
		ItemStack tigela = new ItemStack(Material.BOWL);
		ItemMeta tigelam = tigela.getItemMeta();
		tigela.setItemMeta(tigelam);

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
			if (hp.getHealth() != hp.getMaxHealth()) {
				p.setHealth(hp.getHealth() + 7.00 > hp.getMaxHealth() ? hp.getMaxHealth() : (hp.getHealth() + 7.0D));
				p.getItemInHand().setType(Material.BOWL);
				p.getItemInHand().setItemMeta(tigelam);
			}
		}

	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerLogin3(PlayerLoginEvent e) {
		if ((Bukkit.getOnlinePlayers().length >= 60) && (e.getPlayer().hasPermission("join.full"))) {
			e.setResult(PlayerLoginEvent.Result.ALLOWED);
		} else if ((Bukkit.getOnlinePlayers().length >= 80) && (!e.getPlayer().hasPermission("join.full"))) {
			e.setResult(PlayerLoginEvent.Result.KICK_FULL);
			e.setKickMessage("§c§l " + Configuration.PREFIX.getMessage() + " \n \n§cServidor FULL. \n \n§cCompre §aVIP§c e tenha acesso à servidores lotados. \n \n§cAcesse: loja.wavemc.com.br");
		}
		if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			if (!e.getPlayer().hasPermission("whitelist.join")) {
				e.setKickMessage("§c§l" + Configuration.PREFIX.getMessage() + " \n \n§cServidor em MANUTENÇÃO!");
			} else {
				e.setResult(PlayerLoginEvent.Result.ALLOWED);
			}
		}
	}
	
	@SuppressWarnings({ "deprecation", "deprecation" })
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Material D = e.getItemDrop().getItemStack().getType();

		if (D == Material.IRON_FENCE) {
			e.setCancelled(true);
		}
		if (D == Material.MELON) {
			e.setCancelled(true);
		}
		if (D == Material.getMaterial(351)) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void death(PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			e.getDrops().clear();
			return;
		}

		if (!(e.getEntity().getKiller() instanceof Player)) {
			e.getDrops().clear();
			return;
		}

		Player p = (Player) e.getEntity();
		Player k = p.getKiller();

		if (Glad.emluta.containsKey(k.getName())) {
			Main.getitemDefault(k);
			Glad.removeArena(k);
			Glad.removeArena(p);
			Glad.emluta.remove(k.getName());
		}
		Glad.emluta.remove(p.getName());
		e.getDrops().clear();
		e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 1);
		e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
		p.sendMessage("§cVocê perdeu a batalha contra: §7" + k.getName());
		k.sendMessage("§aVocê ganhou a batalha contra: §7" + p.getName());
		k.teleport(Bukkit.getWorld("world").getSpawnLocation());
		p.teleport(Bukkit.getWorld("world").getSpawnLocation());

		//Config.addDeaths(p, 1);
		//Config.addWins(k, 1);
		//Config.setWinsStreak(k, 1);
		//Config.setWinsStreak(p, 0);
		//Config.stats.saveDefault();

		asScoreAPI.setScore(p);
		asScoreAPI.setScore(k);

		if (PlayerItemClickEvent.ranked.contains(p.getName()) && PlayerItemClickEvent.ranked.contains(k.getName())) {
			//Config.addElo(k, 5);

		}
		PlayerItemClickEvent.ranked.remove(p.getName());
		PlayerItemClickEvent.ranked.remove(k.getName());

		PlayerItemClickEvent.toFight = null;
		PlayerItemClickEvent.toFight1 = null;
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		Player p = e.getPlayer();

		p.closeInventory();
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);

		PlayerItemClickEvent.dawn.remove(p.getName());
		PlayerItemClickEvent.desafiar.remove(p);
		p.teleport(Bukkit.getWorld("world").getSpawnLocation());
		Glad.emluta.remove(p.getName());
		Main.getitemDefault(p);
		if (damage.containsKey(p)) {

			Player matou = Bukkit.getPlayerExact(damage.get(p));

			Main.getitemDefault(matou);
			Glad.removeArena(matou);
			Glad.emluta.remove(matou.getName());
			matou.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
			damage.remove(p);
		}
	}

	@EventHandler
	public void Block(BlockBreakEvent e) {

		Player p = e.getPlayer();

		if (p.getGameMode() == GameMode.SURVIVAL) {
			e.setCancelled(true);
		} else {
			if (Glad.emluta.containsKey(p.getName())) {
				e.setCancelled(false);
			}

		}

	}

	@EventHandler
	public void fome(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void morreu(PlayerDeathEvent e) {
		Player player = e.getEntity();
		e.setDeathMessage(null);
		new BukkitRunnable() {

			@Override
			public void run() {
				if (!player.isDead())
					return;
				CraftPlayer cp = (CraftPlayer) player;
				EntityPlayer ep = cp.getHandle();
				PlayerConnection pc = ep.playerConnection;
				PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
				pc.a(packet);

			}
		}.runTask(Main.getPlugin());
	}

	@EventHandler
	public void pegar(PlayerPickupItemEvent e) {

		Player p = e.getPlayer();

		if (Glad.emluta.containsKey(p.getName())) {
			if (e.getItem().getItemStack().getType() == Material.MUSHROOM_SOUP) {
				return;
			}
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void spawn(EntitySpawnEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void placeblock(BlockPlaceEvent e) {
		if (Glad.emluta.containsKey(e.getPlayer().getName()) || e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);

		}
	}

	@EventHandler
	public void getdamager(EntityDamageByEntityEvent e) {

		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {

			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();

			damage.put(p, d.getName());
		}

	}

	@EventHandler
	public void damagera(EntityDamageEvent e) {
		if (e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);

		}
	}

	@EventHandler
	public void damager(EntityDamageByEntityEvent e) {

		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (Glad.emluta.containsKey(p.getName())) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		}

	}
}
