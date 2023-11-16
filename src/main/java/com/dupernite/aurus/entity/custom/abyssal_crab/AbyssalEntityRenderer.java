package com.dupernite.aurus.entity.custom.abyssal_crab;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AbyssalEntityRenderer extends GeoEntityRenderer<AbyssalEntity> {
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_crab.png");

    public AbyssalEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalGeoModel());
    }

    public Identifier getTexture(AbyssalEntity abyssalEntity) {
        return TEXTURE;
    }

}
