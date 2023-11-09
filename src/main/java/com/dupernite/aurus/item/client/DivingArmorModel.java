package com.dupernite.aurus.item.client;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.item.custom.DivingSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DivingArmorModel extends GeoModel<DivingSuitItem> {
    private final Identifier modelResource = new Identifier(AurusMod.MOD_ID, "geo/divingsuit.geo.json");
    private final Identifier textureResource = new Identifier(AurusMod.MOD_ID, "textures/item/armor/divingsuit.png");
    private final Identifier animationResource = new Identifier(AurusMod.MOD_ID, "animations/divingsuit.animation.json");
    @Override
    public Identifier getModelResource(DivingSuitItem animatable) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(DivingSuitItem animatable) {
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(DivingSuitItem animatable) {
        return animationResource;
    }
}
