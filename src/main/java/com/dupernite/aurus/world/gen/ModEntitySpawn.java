package com.dupernite.aurus.world.gen;

import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN,
                                                                BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN,
                                                                BiomeKeys.DEEP_LUKEWARM_OCEAN),
                SpawnGroup.WATER_CREATURE, ModEntity.JELLYFISH, 50, 3, 5);

        SpawnRestriction.register(ModEntity.JELLYFISH, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::canSpawn);
    }
}
