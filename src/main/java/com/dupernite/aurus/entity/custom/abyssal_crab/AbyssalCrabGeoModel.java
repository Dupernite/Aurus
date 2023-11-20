package com.dupernite.aurus.entity.custom.abyssal_crab;

import com.dupernite.aurus.AurusMod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AbyssalCrabGeoModel extends GeoModel<AbyssalCrabEntity> {
    private final Identifier modelResource = new Identifier(AurusMod.MOD_ID, "geo/abyssal_crab.geo.json");
    private final Identifier textureResource = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_crab");
    private final Identifier animationResource = new Identifier(AurusMod.MOD_ID, "animations/abyssal_crab.animation.json");


    @Override
    public Identifier getModelResource(AbyssalCrabEntity animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(AbyssalCrabEntity animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(AbyssalCrabEntity animatable) {
        return animationResource;
    }
}
