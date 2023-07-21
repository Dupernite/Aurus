package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.item.Spear.ModSpearItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItem {
    public static void registerModItems()   {
        AurusMod.LOGGER.info("Registering Mod Items for" + AurusMod.MOD_ID);
    }
    public static final Item QUARTZ_FRAGMENT = registerItem("quartz_fragment", new Item(new FabricItemSettings()));
    public static final Item CRYSTALIZED_SOUP = registerItem("crystalized_soup", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(1f).build())));
    public static final Item SPEAR = registerItem("spear", new ModSpearItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).maxDamage(10)));
    public static final Item NETHERITE_HORSE_ARMOR = registerItem("netherite_horse_armor", new HorseArmorItem(14, "netherite", new FabricItemSettings()));
    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));
    public static final Item DIVING_HELMET = registerItem("diving_helmet", new ArmorItem(ModArmorMaterial.DIVING, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item DIVING_CHESTPLATE = registerItem("diving_chestplate", new ArmorItem(ModArmorMaterial.DIVING, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item DIVING_LEGGINGS = registerItem("diving_leggings", new ArmorItem(ModArmorMaterial.DIVING, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item DIVING_BOOTS = registerItem("diving_boots", new ArmorItem(ModArmorMaterial.DIVING, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name), item);
    }
}
