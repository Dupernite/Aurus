package com.dupernite.aurus;

import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.screen.UpgraderScreen;
import com.dupernite.aurus.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();

        HandledScreens.register(ModScreenHandlers.UPGRADER_SCREEN_HANDLER, UpgraderScreen::new);
    }
}
