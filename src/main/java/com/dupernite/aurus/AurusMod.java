package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.block.entity.ModBlockEntity;
import com.dupernite.aurus.recipe.ModRecipe;
import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.item.ModItemGroup;
import com.dupernite.aurus.item.ModItem;
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
        ModItem.registerModItems();
        ModBlock.registerModBlocks();

        ModWorldGeneration.generateModWorldGen();
        ModBlockEntity.registerBlockEntities();
        ModScreenHandlers.registerScreenHandler();

        ModRecipe.registerRecipe();
    }
}
