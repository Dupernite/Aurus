package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.abyssal_crab.AbyssalEntityRenderer;
import com.dupernite.aurus.entity.custom.abyssal_projectile.AbyssalProjectileEntityRenderer;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntityRenderer;
import com.dupernite.aurus.entity.custom.spear.SpearModel;
import com.dupernite.aurus.entity.custom.spear.SpearModelRenderer;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.screen.UpgraderScreen;
import com.dupernite.aurus.util.ModModelPredicateProvider;
import com.dupernite.aurus.util.ModRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RELIC2, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ModRegistry.registerModRegistries();

        HandledScreens.register(ModScreenHandlers.UPGRADER_SCREEN_HANDLER, UpgraderScreen::new);

        EntityRendererRegistry.register(ModEntity.JELLYFISH, JellyfishEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.ABYSSAL_CRAB, AbyssalEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.ABYSSAL_PROJECTILE, AbyssalProjectileEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.SPEAR_ENTITY, SpearModelRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPEAR, SpearModel::getTexturedModelData);
        FabricDefaultAttributeRegistry.register(ModEntity.JELLYFISH, createGenericEntityAttributes());
    }
    private static DefaultAttributeContainer.Builder createGenericEntityAttributes() {
        return PathAwareEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.80000000298023224D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D).add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0D);
    }
}
