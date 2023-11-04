package com.dupernite.aurus.entity.custom.jellyfish;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class JellyfishModel<T extends JellyfishEntity> extends EntityModel<T>  {
	private final ModelPart jellyfish;
	private final ModelPart body;
	private final ModelPart legs;
	private final ModelPart head;

	public JellyfishModel(ModelPart root) {
		this.jellyfish = root.getChild("jellyfish");
		this.body = jellyfish.getChild("body");
		this.legs = body.getChild("legs");
		this.head = body.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData jellyfish = modelPartData.addChild("jellyfish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 29.0F, 0.0F));

		ModelPartData body = jellyfish.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = legs.addChild("cube_r1", ModelPartBuilder.create().uv(0, 5).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

		ModelPartData cube_r2 = legs.addChild("cube_r2", ModelPartBuilder.create().uv(8, 5).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -12.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(16, 3).cuboid(-2.0F, -11.0F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(10, 14).cuboid(-2.0F, -11.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, -0.5F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 0).cuboid(-2.0F, -0.5F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		jellyfish.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(JellyfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}