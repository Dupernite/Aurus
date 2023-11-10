package com.dupernite.aurus.entity.custom.spear;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class SpearModelRenderer extends EntityRenderer<SpearEntity> {
    public static final Identifier TEXTURE = new Identifier(AurusMod.MOD_ID, "textures/entity/spear.png");
    protected SpearModel model;

    public SpearModelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new SpearModel(ctx.getPart(ModModelLayers.SPEAR));
    }

    @Override
    public void render(SpearEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 5.0F, 5.0F, 5.0F, 5.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(SpearEntity entity) {
        return TEXTURE;
    }
}
