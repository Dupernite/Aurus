package com.dupernite.aurus.entity.custom.abyssal_crab;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AbyssalCrabEntityRenderer extends GeoEntityRenderer<AbyssalCrabEntity> {
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_crab.png");

    public AbyssalCrabEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalCrabGeoModel());
    }

    public Identifier getTexture(AbyssalCrabEntity abyssalCrabEntity) {
        return TEXTURE;
    }

}
