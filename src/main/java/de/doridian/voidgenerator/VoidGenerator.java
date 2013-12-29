package de.doridian.voidgenerator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VoidGenerator extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPhysics(BlockPhysicsEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockFade(BlockFadeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockGrow(BlockGrowEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockFromTo(BlockFromToEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onItemDropEvent(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		player.setGameMode(GameMode.ADVENTURE);
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		event.setCancelled(true);
		event.setDamage(0);
	}

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new ChunkGenerator() {
			private final List<BlockPopulator> populators = new ArrayList<>();
			private final byte[] generatorArray = new byte[32768];

			@Override
			public boolean canSpawn(World world, int x, int z) {
				return true;
			}

			@Override
			public List<BlockPopulator> getDefaultPopulators(World world) {
				return populators;
			}

			@Override
			public Location getFixedSpawnLocation(World world, Random random) {
				return new Location(world, 0.0D, 66.0D, 0.0D);
			}

			@Override
			public byte[] generate(World world, Random random, int x, int z) {
				return generatorArray;
			}
		};
	}
}
