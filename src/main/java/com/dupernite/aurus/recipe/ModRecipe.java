package com.dupernite.aurus.recipe;

import com.dupernite.aurus.AurusMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipe {
    public static void registerRecipe() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(AurusMod.MOD_ID, UpgraderRecipe.Serializer.ID),
                UpgraderRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(AurusMod.MOD_ID, UpgraderRecipe.Type.ID),
                UpgraderRecipe.Type.INSTANCE);
    }
}
