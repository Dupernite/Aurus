package com.dupernite.aurus;

import com.dupernite.aurus.entity.SpearModel;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class AurusModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPEAR, SpearModel::getTexturedModelData);
    }
}
