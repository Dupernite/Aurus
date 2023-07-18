package com.dupernite.aurus.block;

import com.dupernite.aurus.AurusMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {


    //Register Blocks
    private static Item registerItemBlock(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }
    private static Block registerBlock(String name, Block block) {
        registerItemBlock(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AurusMod.MOD_ID, name), block);
    }

    //Register ModBlocks
    public static void registerModBlocks() {
        AurusMod.LOGGER.debug("Registering ModBlocks for " + AurusMod.MOD_ID);
    }

    //Blocks
    public static final Block OVERWORLD_QUARTZ_ORE = registerBlock("overworld_quartz_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(2, 6)));

    public static final Block DEEPSLATE_OVERWORLD_QUARTZ_ORE = registerBlock("deepslate_overworld_quartz_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(6.0f).requiresTool(),
                    UniformIntProvider.create(2, 6)));

}
