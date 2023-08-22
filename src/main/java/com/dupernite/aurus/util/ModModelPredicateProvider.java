package com.dupernite.aurus.util;

import com.dupernite.aurus.item.ModItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels(){
        registerSpear();
    }

    private static void registerSpear() {
        ModelPredicateProviderRegistry.register(ModItem.SPEAR, new Identifier("throwing"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
    }
}
