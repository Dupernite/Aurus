package com.dupernite.aurus.entity.layer;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer JELLYFISH =
            new EntityModelLayer(new Identifier(AurusMod.MOD_ID, "jellyfish"), "main");
}