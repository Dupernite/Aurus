package com.dupernite.aurus.block;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.custom.PedestalBlock;
import com.dupernite.aurus.block.custom.PotBlock;
import com.dupernite.aurus.block.custom.TrophyBlock;
import com.dupernite.aurus.block.custom.UpgraderBlock;
import com.dupernite.aurus.block.entity.UpgraderBlockEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlock {


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
    public static final Block UPGRADER = registerBlock("upgrader",
            new UpgraderBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)));

    public static final Block RELIC1 = registerBlock("trophy",
            new TrophyBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    public static final Block RELIC2 = registerBlock("pot",
            new PotBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    public static final Block PEDESTAL = registerBlock("pedestal",
            new PedestalBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

}
