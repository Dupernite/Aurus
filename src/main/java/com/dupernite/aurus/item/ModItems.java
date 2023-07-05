package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.item.Spear.ModSpearEntity;
import com.dupernite.aurus.item.Spear.ModSpearItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static void registerModItems()   {
        AurusMod.LOGGER.info("Registering Mod Items for" + AurusMod.MOD_ID);
    }
    public static final Item QUARTZ_FRAGMENT = registerItem("quartz_fragment", new Item(new FabricItemSettings()));
    public static final Item SPEAR = registerItem("spear", new ModSpearItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).maxDamage(10)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name), item);
    }
}
