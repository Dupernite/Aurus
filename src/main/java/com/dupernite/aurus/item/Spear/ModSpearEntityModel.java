package com.dupernite.aurus.item.Spear;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ModSpearEntityModel extends EntityModel<Entity> {
    private final ModelPart Head;
    private final ModelPart ZAxis2;
    private final ModelPart _z3;
    private final ModelPart cube_r1;
    private final ModelPart XAxis2;
    private final ModelPart _z4;
    private final ModelPart cube_r2;
    private final ModelPart ZAxis;
    private final ModelPart _z5;
    private final ModelPart cube_r3;
    private final ModelPart XAxis;
    private final ModelPart _z2;
    private final ModelPart cube_r4;
    private final ModelPart Cable;
    public ModSpearEntityModel(ModelPart root, ModelPart zAxis2, ModelPart z3, ModelPart cubeR1, ModelPart xAxis2, ModelPart z4, ModelPart cubeR2, ModelPart zAxis, ModelPart z5, ModelPart cubeR3, ModelPart xAxis, ModelPart z2, ModelPart cubeR4) {
        this.Head = root.getChild("Head");
        this.Cable = root.getChild("Cable");
        ZAxis2 = zAxis2;
        _z3 = z3;
        cube_r1 = cubeR1;
        XAxis2 = xAxis2;
        _z4 = z4;
        cube_r2 = cubeR2;
        ZAxis = zAxis;
        _z5 = z5;
        cube_r3 = cubeR3;
        XAxis = xAxis;
        _z2 = z2;
        cube_r4 = cubeR4;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 19.0F, 0.0F));

        ModelPartData ZAxis2 = Head.addChild("ZAxis2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -15.0F, 0.0F));

        ModelPartData _z3 = ZAxis2.addChild("_z3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData cube_r1 = _z3.addChild("cube_r1", ModelPartBuilder.create().uv(4, 0).cuboid(-1.0F, 1.2183F, -1.6173F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-1.0F, -0.7716F, 2.2902F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData XAxis2 = Head.addChild("XAxis2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.0F, 0.0F));

        ModelPartData _z4 = XAxis2.addChild("_z4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData cube_r2 = _z4.addChild("cube_r2", ModelPartBuilder.create().uv(8, 5).cuboid(-1.6173F, 1.2183F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(2.2902F, -0.7716F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData ZAxis = Head.addChild("ZAxis", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -15.0F, 1.0F));

        ModelPartData _z5 = ZAxis.addChild("_z5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData cube_r3 = _z5.addChild("cube_r3", ModelPartBuilder.create().uv(8, 11).cuboid(-1.0F, -2.3827F, -2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 7).cuboid(-1.0F, -3.2902F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData XAxis = Head.addChild("XAxis", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 5.0F, 0.0F));

        ModelPartData _z2 = XAxis.addChild("_z2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -20.0F, -1.0F));

        ModelPartData cube_r4 = _z2.addChild("cube_r4", ModelPartBuilder.create().uv(8, 5).cuboid(-2.3827F, 1.2183F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-3.2902F, -0.7716F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData Cable = modelPartData.addChild("Cable", ModelPartBuilder.create().uv(4, 5).cuboid(-1.25F, -12.0F, -0.25F, 1.5F, 7.0F, 1.5F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -19.0F, 0.0F, 1.0F, 19.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Cable.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}