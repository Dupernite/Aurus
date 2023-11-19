package com.dupernite.aurus.util;

import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.abyssal_crab.AbyssalEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import com.dupernite.aurus.item.ModItem;
import com.dupernite.aurus.mixin.BrewingRecipeRegistryMixin;
import com.dupernite.aurus.potion.ModPotion;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

public class ModRegistry {
    public static void registerModRegistries(){
        registerAttributes();
        registerPotionRecipes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntity.JELLYFISH, JellyfishEntity.createJellyfishAttributes());
        FabricDefaultAttributeRegistry.register(ModEntity.ABYSSAL_CRAB, AbyssalEntity.createAbyssalCrabAttributes());
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItem.ABYSSAL_CLAW, ModPotion.ABYSSAL_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotion.ABYSSAL_POTION, Items.REDSTONE, ModPotion.LONG_ABYSSAL_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotion.ABYSSAL_POTION, Items.GLOWSTONE_DUST, ModPotion.STRONG_ABYSSAL_POTION);
    }
}
