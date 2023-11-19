package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.item.custom.BowlItem;
import com.dupernite.aurus.item.custom.DivingSuitItem;
import com.dupernite.aurus.item.custom.SpearItem;
import com.dupernite.aurus.item.material.ModArmorMaterial;
import com.dupernite.aurus.item.material.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItem {
    public static void registerModItems()   {
        AurusMod.LOGGER.info("Registering Mod Items for " + AurusMod.MOD_ID);
    }

    //Food
    public static final Item CRYSTALIZED_SOUP = registerItem("crystalized_soup", new BowlItem(new FabricItemSettings().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5f).build())));

    //Ore
    public static final Item QUARTZ_FRAGMENT = registerItem("quartz_fragment", new Item(new FabricItemSettings()));
    public static final Item QUARTZUM_ALLOY = registerItem("quartzum_alloy", new Item(new FabricItemSettings()));

    //Armor
    public static final Item NETHERITE_HORSE_ARMOR = registerItem("netherite_horse_armor", new HorseArmorItem(14, "netherite", new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final DivingSuitItem DIVING_HELMET = registerGeoItem("diving_helmet", new DivingSuitItem(ModArmorMaterial.DIVING, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final DivingSuitItem DIVING_CHESTPLATE = registerGeoItem("diving_chestplate", new DivingSuitItem(ModArmorMaterial.DIVING, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final DivingSuitItem DIVING_LEGGINGS = registerGeoItem("diving_leggings", new DivingSuitItem(ModArmorMaterial.DIVING, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final DivingSuitItem DIVING_BOOTS = registerGeoItem("diving_boots", new DivingSuitItem(ModArmorMaterial.DIVING, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE)));

    //Others
    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings().maxCount(128)));
    public static final Item SPEAR =registerItem("spear",
            new SpearItem(ModToolMaterial.SPEAR, 6, -1f, new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item TANK = registerItem("tank", new Item(new FabricItemSettings().maxCount(8)));
    public static final Item DIVING_UPGRADE = registerItem("diving_upgrade", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item NIGHT_VISION_DIVING_UPGRADE = registerItem("night_vision_diving_upgrade", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item WATER_BREATHING__DIVING_UPGRADE = registerItem("water_breathing_diving_upgrade", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item JELLYFISH_SPAWN_EGG = registerItem("jellyfish_spawn_egg", new SpawnEggItem(ModEntity.JELLYFISH, 0x5BBCF4, 0x7BD4FF, new FabricItemSettings()));
    public static final Item ABYSSAL_CRAB_SPAWN_EGG = registerItem("abyssal_crab_spawn_egg", new SpawnEggItem(ModEntity.ABYSSAL_CRAB, 0x5BBCF4, 0x7BD4FF, new FabricItemSettings()));
    public static final Item QUARTZ_DUST = registerItem("quartz_dust", new Item(new FabricItemSettings()));
    public static final Item ABYSSAL_CLAW = registerItem("abyssal_claw", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name), item);
    }
    public static <I extends Item> I registerGeoItem(String name, I item) {
        return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name), item);
    }
}
