package br.com.linux.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftSnowball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

import net.minecraft.server.v1_7_R4.EntityFishingHook;
import net.minecraft.server.v1_7_R4.EntityHuman;
import net.minecraft.server.v1_7_R4.EntitySnowball;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityDestroy;

public class HookUtil extends EntityFishingHook {
	private Entity entity;
	private Snowball snowball;
	private EntitySnowball entitySnowball;
	private boolean hooked;

	public HookUtil(org.bukkit.World world, EntityHuman entity) {
		super(((CraftWorld) world).getHandle(), entity);
		this.owner = entity;
	}

	public void remove() {
		super.die();
	}

	public boolean isHooked() {
		return this.hooked;
	}

	@SuppressWarnings("deprecation")
	public void spawn(Location location) {
		this.snowball = ((Snowball) this.owner.getBukkitEntity().launchProjectile(Snowball.class));
		this.entitySnowball = ((CraftSnowball) this.snowball).getHandle();
		for (Player all : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) all).getHandle().playerConnection
					.sendPacket(new PacketPlayOutEntityDestroy(new int[] { this.entitySnowball.getId() }));
		}
		((CraftWorld) location.getWorld()).getHandle().addEntity(this);
	}

	public void h() {
		for (Entity entity : this.entitySnowball.world.getWorld().getEntities()) {
			if ((entity.getEntityId() != getBukkitEntity().getEntityId())
					&& (entity.getEntityId() != this.owner.getBukkitEntity().getEntityId())
					&& (entity.getEntityId() != this.entitySnowball.getBukkitEntity().getEntityId())
					&& ((entity.getLocation().distance(this.entitySnowball.getBukkitEntity().getLocation()) < 2.0D)
							|| (((entity instanceof Player)) && (((Player) entity).getEyeLocation()
									.distance(this.entitySnowball.getBukkitEntity().getLocation()) < 2.0D)))) {
				this.entitySnowball.die();
				this.entity = entity;
				this.hooked = true;
				this.locX = entity.getLocation().getX();
				this.locY = entity.getLocation().getY();
				this.locZ = entity.getLocation().getZ();
				this.motX = 0.0D;
				this.motY = 0.04D;
				this.motZ = 0.0D;
			}
		}
		try {
			this.locX = this.entity.getLocation().getX();
			this.locY = this.entity.getLocation().getY();
			this.locZ = this.entity.getLocation().getZ();
			this.motX = 0.0D;
			this.motY = 0.04D;
			this.motZ = 0.0D;
			this.hooked = true;
		} catch (Exception e) {
			if (this.entitySnowball.dead) {
				this.hooked = true;
			}
			this.locX = this.entitySnowball.locX;
			this.locY = this.entitySnowball.locY;
			this.locZ = this.entitySnowball.locZ;
		}
	}
}
