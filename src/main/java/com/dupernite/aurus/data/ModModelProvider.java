package com.dupernite.aurus.data;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlock.OVERWORLD_QUARTZ_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlock.DEEPSLATE_OVERWORLD_QUARTZ_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItem.QUARTZ_FRAGMENT, Models.GENERATED);
    }
}
