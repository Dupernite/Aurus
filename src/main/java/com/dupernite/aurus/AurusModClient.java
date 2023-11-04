package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntityRenderer;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishModel;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.screen.UpgraderScreen;
import com.dupernite.aurus.util.ModModelPredicateProvider;
import com.dupernite.aurus.util.ModRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RELIC2, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ModRegistry.registerModRegistries();
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JELLYFISH, JellyfishModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.UPGRADER_SCREEN_HANDLER, UpgraderScreen::new);
        EntityRendererRegistry.register(ModEntity.JELLYFISH, JellyfishEntityRenderer::new);
    }
}
