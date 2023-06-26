package com.dupernite.aurus.block;

import com.dupernite.aurus.AurusMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlocks {

    private static Block registerBLock(String name, Block block, ItemGroup tab) {
        return Registry.register(Registries.BLOCK, new Identifier(AurusMod.MOD_ID, name), block);
    }
   // private static Item registerBlockItem(String name, Block block, ItemGroup tab){
   //     return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name),
 //               new BlockItem(block, new FabricItemSettings().group(tab)));
  //  }

    public static void registerModBlocks() {
        AurusMod.LOGGER.debug("Registering ModBlocks for " + AurusMod.MOD_ID);
    }
}
