package com.dupernite.aurus.entity.layer;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SPEAR =
            new EntityModelLayer(new Identifier(AurusMod.MOD_ID, "spear"), "main");
}