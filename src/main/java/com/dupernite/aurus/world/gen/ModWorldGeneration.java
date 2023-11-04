package com.dupernite.aurus.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModEntitySpawn.addSpawns();
    }
}
