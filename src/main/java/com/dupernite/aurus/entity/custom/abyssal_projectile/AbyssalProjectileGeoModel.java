package com.dupernite.aurus.entity.custom.abyssal_projectile;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AbyssalProjectileGeoModel extends GeoModel<AbyssalProjectileEntity>{
    private final Identifier modelResource = new Identifier(AurusMod.MOD_ID, "geo/abyssal_projectile.geo.json");
    private final Identifier textureResource = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_projectile");
    private final Identifier animationResource = new Identifier(AurusMod.MOD_ID, "animations/abyssal_projectile.animation.json");


    @Override
    public Identifier getModelResource(AbyssalProjectileEntity animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(AbyssalProjectileEntity animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(AbyssalProjectileEntity animatable) {
        return animationResource;
    }
}
