/**
 * This file is part of VoidGenerator.
 *
 * VoidGenerator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VoidGenerator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with VoidGenerator.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.foxelbox.voidgenerator;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VoidGenerator extends JavaPlugin {
    private final ChunkGenerator chunkGenerator = new ChunkGenerator() {
        private final List<BlockPopulator> populators = new ArrayList<>();
        private final byte[] generatorArray = new byte[32768];

        @Override public boolean canSpawn(World world, int x, int z) { return true; }
        @Override public List<BlockPopulator> getDefaultPopulators(World world) { return populators; }
        @Override public Location getFixedSpawnLocation(World world, Random random) { return new Location(world, 0.0D, 66.0D, 0.0D); }
        @Override public byte[] generate(World world, Random random, int x, int z) { return generatorArray; }
    };

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) { return chunkGenerator; }
}
