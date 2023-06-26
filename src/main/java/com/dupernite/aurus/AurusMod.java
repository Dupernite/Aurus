package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AurusMod implements ModInitializer {
    public static final String MOD_ID = "aurus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
    }
}
