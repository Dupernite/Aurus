package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.ModBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static void registerModItemGroup()   {
        ItemGroup AURUSTAB = Registry.register(Registries.ITEM_GROUP, new Identifier(AurusMod.MOD_ID, "aurustab"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.aurustab"))
                .icon(() -> new ItemStack(ModBlock.OVERWORLD_QUARTZ_ORE)).entries((displayContext, entries) -> {
                    entries.add(ModBlock.DEEPSLATE_OVERWORLD_QUARTZ_ORE);
                    entries.add(ModBlock.OVERWORLD_QUARTZ_ORE);
                    entries.add(ModItem.QUARTZ_FRAGMENT);
                    entries.add(ModItem.CRYSTALIZED_SOUP);
                    entries.add(ModItem.NETHERITE_HORSE_ARMOR);
                    entries.add(ModItem.COIN);
                    entries.add(ModItem.DIVING_HELMET);
                    entries.add(ModItem.DIVING_CHESTPLATE);
                    entries.add(ModItem.DIVING_LEGGINGS);
                    entries.add(ModItem.DIVING_BOOTS);
                    entries.add(ModItem.TANK);
                    entries.add(ModItem.DIVING_UPGRADE);
                    entries.add(ModBlock.UPGRADER);
                    entries.add(ModItem.NIGHT_VISION_DIVING_UPGRADE);
                    entries.add(ModItem.WATER_BREATHING__DIVING_UPGRADE);
                    entries.add(ModBlock.RELIC1);
                    entries.add(ModBlock.RELIC2);
                    entries.add(ModBlock.PEDESTAL);
                    entries.add(ModItem.QUARTZUM_ALLOY);
                }).build());
    }
}