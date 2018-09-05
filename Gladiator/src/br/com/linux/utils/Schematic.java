package br.com.linux.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

import br.com.linux.Main;

public class Schematic {

	public Schematic(String name, Location l) {
		WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		File schematic = new File(Main.getPlugin().getDataFolder() + File.separator + name + ".schematic");
		EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory()
				.getEditSession(new BukkitWorld(l.getWorld()), 10000);
		try {
			CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
			clipboard.rotate2D(90);
			clipboard.paste(session, new Vector(l.getX(), l.getY(), l.getZ()), false);
		} catch (MaxChangedBlocksException | DataException | IOException e) {
			e.printStackTrace();
		}
	}

}
