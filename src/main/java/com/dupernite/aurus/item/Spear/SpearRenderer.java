package com.dupernite.aurus.item.Spear;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;

public class SpearRenderer extends TridentEntityRenderer{
    private static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/spear_entity.png");

    public SpearRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(TridentEntity spearEntity) {
        return TEXTURE;
    }

}

