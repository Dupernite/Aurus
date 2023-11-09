package com.dupernite.aurus.entity.custom.spear;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SpearModel extends EntityModel<SpearEntity> {
	private final ModelPart Spear;
	private final ModelPart Body;
	private final ModelPart Handle;
	private final ModelPart Head;
	private final ModelPart side1;
	private final ModelPart side2;
	private final ModelPart side3;
	private final ModelPart side4;
	public SpearModel(ModelPart root) {
		this.Spear = root.getChild("Spear");
		this.Body = Spear.getChild("Body");
		this.Handle = Body.getChild("Handle");
		this.Head = Body.getChild("Head");
		this.side1 = Head.getChild("side1");
		this.side2 = Head.getChild("side2");
		this.side3 = Head.getChild("side3");
		this.side4 = Head.getChild("side4");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Spear = modelPartData.addChild("Spear", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

		ModelPartData Body = Spear.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -25.0F, 7.0F, 2.0F, 25.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Handle = Body.addChild("Handle", ModelPartBuilder.create().uv(8, 0).cuboid(-9.5F, -16.0F, 6.5F, 3.0F, 11.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData side1 = Head.addChild("side1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = side1.addChild("cube_r1", ModelPartBuilder.create().uv(20, 20).cuboid(-0.25F, -1.8321F, 1.5821F, 0.5F, 3.75F, 1.75F, new Dilation(0.0F))
				.uv(16, 9).cuboid(-0.5F, 1.0821F, -2.3321F, 1.0F, 1.75F, 5.75F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -26.7626F, 9.9142F, 0.3927F, 0.0F, 0.0F));

		ModelPartData side2 = Head.addChild("side2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r2 = side2.addChild("cube_r2", ModelPartBuilder.create().uv(8, 22).cuboid(1.3321F, -1.8321F, -0.25F, 1.75F, 3.75F, 0.5F, new Dilation(0.0F))
				.uv(13, 26).cuboid(-2.5821F, 1.0821F, -0.5F, 5.75F, 1.75F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.7474F, -26.8384F, 7.8624F, 0.0F, 0.0F, -0.3927F));

		ModelPartData side3 = Head.addChild("side3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r3 = side3.addChild("cube_r3", ModelPartBuilder.create().uv(8, 14).cuboid(-0.25F, -1.8321F, -3.0821F, 0.5F, 3.75F, 1.75F, new Dilation(0.0F))
				.uv(8, 14).cuboid(-0.5F, 1.0821F, -3.1679F, 1.0F, 1.75F, 5.75F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -26.7626F, 5.8107F, -0.3927F, 0.0F, 0.0F));

		ModelPartData side4 = Head.addChild("side4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r4 = side4.addChild("cube_r4", ModelPartBuilder.create().uv(20, 3).cuboid(-3.0821F, -1.8321F, -0.25F, 1.75F, 3.75F, 0.5F, new Dilation(0.0F))
				.uv(17, 0).cuboid(-3.1679F, 1.0821F, -0.5F, 5.75F, 1.75F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-10.2526F, -26.8384F, 7.8624F, 0.0F, 0.0F, 0.3927F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(SpearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Spear.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}