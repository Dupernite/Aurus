package com.dupernite.aurus.entity.custom.jellyfish;

import com.dupernite.aurus.AurusMod;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class JellyfishGeoModel extends GeoModel<JellyfishEntity> {
    private final Identifier modelResource = new Identifier(AurusMod.MOD_ID, "geo/jellyfish.geo.json");
    private final Identifier textureResource = new Identifier(AurusMod.MOD_ID, "textures/entity/jellyfish");
    private final Identifier animationResource = new Identifier(AurusMod.MOD_ID, "animations/jellyfish.animation.json");


    @Override
    public Identifier getModelResource(JellyfishEntity animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(JellyfishEntity animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(JellyfishEntity animatable) {
        return animationResource;
    }
}
