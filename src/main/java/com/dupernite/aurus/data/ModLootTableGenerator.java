package com.dupernite.aurus.data;

import com.dupernite.aurus.block.ModBlocks;
import com.dupernite.aurus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.OVERWORLD_QUARTZ_ORE, oreDrops(ModBlocks.OVERWORLD_QUARTZ_ORE, ModItems.QUARTZ_FRAGMENT));
        addDrop(ModBlocks.DEEPSLATE_OVERWORLD_QUARTZ_ORE, oreDrops(ModBlocks.DEEPSLATE_OVERWORLD_QUARTZ_ORE, ModItems.QUARTZ_FRAGMENT));
    }
}
