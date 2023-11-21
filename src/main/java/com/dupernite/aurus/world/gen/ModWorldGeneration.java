package com.dupernite.aurus.world.gen;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.util.AurusModUtils;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        AurusMod.LOGGER.info("[" + AurusModUtils.getModID() + "]" + " Registering World Generation");
        ModOreGeneration.generateOres();
        ModEntitySpawn.addSpawns();
    }
}
