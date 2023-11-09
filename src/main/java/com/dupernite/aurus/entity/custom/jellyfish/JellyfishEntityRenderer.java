package com.dupernite.aurus.entity.custom.jellyfish;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JellyfishEntityRenderer extends GeoEntityRenderer<JellyfishEntity> {
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/jellyfish.png");

    public JellyfishEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new JellyfishGeoModel());
    }

    public Identifier getTexture(JellyfishEntity jellyfishEntity) {
        return TEXTURE;
    }

}
