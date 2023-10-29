package com.dupernite.aurus;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.screen.UpgraderScreen;
import com.dupernite.aurus.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RELIC2, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        HandledScreens.register(ModScreenHandlers.UPGRADER_SCREEN_HANDLER, UpgraderScreen::new);
    }
}
