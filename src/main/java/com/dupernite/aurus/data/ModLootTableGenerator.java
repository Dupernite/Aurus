package com.dupernite.aurus.data;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlock.OVERWORLD_QUARTZ_ORE, oreDrops(ModBlock.OVERWORLD_QUARTZ_ORE, ModItem.QUARTZ_FRAGMENT));
        addDrop(ModBlock.DEEPSLATE_OVERWORLD_QUARTZ_ORE, oreDrops(ModBlock.DEEPSLATE_OVERWORLD_QUARTZ_ORE, ModItem.QUARTZ_FRAGMENT));
    }
}
