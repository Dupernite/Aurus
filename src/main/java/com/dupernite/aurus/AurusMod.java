package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlocks;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.item.ModItemGroup;
import com.dupernite.aurus.item.ModItems;
import com.dupernite.aurus.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AurusMod implements ModInitializer {
    public static final String MOD_ID = "aurus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModItemGroup.registerModItemGroup();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModWorldGeneration.generateModWorldGen();
    }
}
