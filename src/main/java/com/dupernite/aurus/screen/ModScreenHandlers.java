package com.dupernite.aurus.screen;

import com.dupernite.aurus.AurusMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<UpgraderScreenHandler> UPGRADER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(AurusMod.MOD_ID, "upgrader_screen_handler"),
                    new ExtendedScreenHandlerType<>(UpgraderScreenHandler::new));

    public static void registerScreenHandler() {
        AurusMod.LOGGER.info("Registering GUI Handlers for " + AurusMod.MOD_ID);
    }
}
