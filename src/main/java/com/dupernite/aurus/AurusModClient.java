package com.dupernite.aurus;

import com.dupernite.aurus.util.ModRegistry;
import net.fabricmc.api.ClientModInitializer;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRegistry.registerModRegistries();
    }
}
