package com.dupernite.aurus.entity.custom.abyssal_crab;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AbyssalCrabEntityRenderer extends GeoEntityRenderer<AbyssalCrabEntity> {
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_crab.png");
    private static final Identifier SHOOTING_TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_crab_shooting.png");

    public AbyssalCrabEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalCrabGeoModel());
    }

    @Override
    public Identifier getTexture(AbyssalCrabEntity abyssalCrabEntity) {
        if (AbyssalCrabEntity.isShooting) {
            return SHOOTING_TEXTURE;
        } else {
            return TEXTURE;
        }
    }

}
