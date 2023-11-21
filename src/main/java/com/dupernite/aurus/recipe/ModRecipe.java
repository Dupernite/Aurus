package com.dupernite.aurus.recipe;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.util.AurusModUtils;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipe {
    public static void registerRecipe() {
        AurusMod.LOGGER.info("[" + AurusModUtils.getModID() + "]" + " Registering Recipes");
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(AurusMod.MOD_ID, UpgraderRecipe.Serializer.ID),
                UpgraderRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(AurusMod.MOD_ID, UpgraderRecipe.Type.ID),
                UpgraderRecipe.Type.INSTANCE);
    }
}
