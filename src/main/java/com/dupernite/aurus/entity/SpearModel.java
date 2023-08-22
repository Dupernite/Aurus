package com.dupernite.aurus.entity;

import com.dupernite.aurus.item.Spear.NewSpearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SpearModel<T extends NewSpearEntity> extends SinglePartEntityModel<T> {
	public ModelPart Head;
	public ModelPart ZAxis;
	public ModelPart _z2;
	public ModelPart cube_r1;
	public ModelPart cube_r2;
	public ModelPart ZAxis2;
	public ModelPart _z3;
	public ModelPart cube_r3;
	public ModelPart cube_r4;
	public ModelPart XAxis;
	public ModelPart _z4;
	public ModelPart cube_r5;
	public ModelPart cube_r6;
	public ModelPart XAxis2;
	public ModelPart _z5;
	public ModelPart cube_r7;
	public ModelPart cube_r8;
	public ModelPart Cable;
	public SpearModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Cable = root.getChild("Cable");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, 0.0F));

		ModelPartData ZAxis = Head.addChild("ZAxis", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.0F, 0.0F));

		ModelPartData _z2 = ZAxis.addChild("_z2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -1.0F, 1.5708F, -1.1781F, -1.5708F));

		ModelPartData cube_r1 = _z2.addChild("cube_r1", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -0.8579F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 3.1416F, 0.0F, -0.6517F));

		ModelPartData cube_r2 = _z2.addChild("cube_r2", ModelPartBuilder.create().uv(1, 1).cuboid(2.0F, 1.1421F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		ModelPartData ZAxis2 = Head.addChild("ZAxis2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData _z3 = ZAxis2.addChild("_z3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -1.0F, 1.5708F, -1.1781F, -1.5708F));

		ModelPartData cube_r3 = _z3.addChild("cube_r3", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -0.8579F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 3.1416F, 0.0F, -0.6517F));

		ModelPartData cube_r4 = _z3.addChild("cube_r4", ModelPartBuilder.create().uv(1, 1).cuboid(2.0F, 1.1421F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		ModelPartData XAxis = Head.addChild("XAxis", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData _z4 = XAxis.addChild("_z4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -1.0F, 1.5708F, -1.1781F, -1.5708F));

		ModelPartData cube_r5 = _z4.addChild("cube_r5", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -0.8579F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 3.1416F, 0.0F, -0.6517F));

		ModelPartData cube_r6 = _z4.addChild("cube_r6", ModelPartBuilder.create().uv(1, 1).cuboid(2.0F, 1.1421F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		ModelPartData XAxis2 = Head.addChild("XAxis2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData _z5 = XAxis2.addChild("_z5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, -1.0F, 1.5708F, -1.1781F, -1.5708F));

		ModelPartData cube_r7 = _z5.addChild("cube_r7", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -0.8579F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 3.1416F, 0.0F, -0.6517F));

		ModelPartData cube_r8 = _z5.addChild("cube_r8", ModelPartBuilder.create().uv(1, 1).cuboid(2.0F, 1.1421F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		ModelPartData Cable = modelPartData.addChild("Cable", ModelPartBuilder.create().uv(0, 0).cuboid(-0.75F, -12.0F, -0.75F, 1.5F, 7.0F, 1.5F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-0.5F, -19.0F, -0.5F, 1.0F, 19.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(NewSpearEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}