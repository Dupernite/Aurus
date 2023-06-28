package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static void registerModItemGroup()   {
        ItemGroup AURUSTAB = Registry.register(Registries.ITEM_GROUP, new Identifier(AurusMod.MOD_ID, "aurustab"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.aurustab"))
                .icon(() -> new ItemStack(ModBlocks.OVERWORLD_QUARTZ_ORE)).entries((displayContext, entries) -> {
                    entries.add(ModBlocks.DEEPSLATE_OVERWORLD_QUARTZ_ORE);
                    entries.add(ModBlocks.OVERWORLD_QUARTZ_ORE);
                    entries.add(ModItems.QUARTZ_FRAGMENT);
                }).build());
    }
}