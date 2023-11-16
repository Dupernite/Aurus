package com.dupernite.aurus.entity.custom.abyssal_projectile;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AbyssalProjectileEntityRenderer extends GeoEntityRenderer<AbyssalProjectileEntity> {
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/abyssal_projectile.png");

    public AbyssalProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalProjectileGeoModel());
    }

    public Identifier getTexture(AbyssalProjectileEntity abyssalPullProjectile) {
        return TEXTURE;
    }

}
