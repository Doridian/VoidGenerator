package de.doridian.voidgenerator;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VoidGenerator extends JavaPlugin implements Listener {
    private final ChunkGenerator chunkGenerator = new ChunkGenerator() {
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

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return chunkGenerator;
	}
}
