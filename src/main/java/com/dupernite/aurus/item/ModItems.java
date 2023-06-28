package com.dupernite.aurus.item;

import com.dupernite.aurus.AurusMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems()   {
        AurusMod.LOGGER.info("Registering Mod Items for" + AurusMod.MOD_ID);
    }
    public static final Item QUARTZ_FRAGMENT = registerItem("quartz_fragment", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AurusMod.MOD_ID, name), item);
    }
}
