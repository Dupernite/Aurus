package com.dupernite.aurus.util;

import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistry {
    public static void registerModRegistries(){
        registerAttributes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntity.JELLYFISH, JellyfishEntity.createJellyfishAttributes());
    }
}
