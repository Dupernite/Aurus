package com.dupernite.aurus.util;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.abyssal_crab.AbyssalCrabEntity;
import com.dupernite.aurus.entity.custom.abyssal_crab.AbyssalCrabEntityRenderer;
import com.dupernite.aurus.entity.custom.abyssal_projectile.AbyssalProjectileEntityRenderer;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntityRenderer;
import com.dupernite.aurus.entity.custom.spear.SpearModel;
import com.dupernite.aurus.entity.custom.spear.SpearModelRenderer;
import com.dupernite.aurus.entity.layer.ModModelLayers;
import com.dupernite.aurus.item.ModItem;
import com.dupernite.aurus.mixin.BrewingRecipeRegistryMixin;
import com.dupernite.aurus.potion.ModPotion;
import com.dupernite.aurus.screen.ModScreenHandlers;
import com.dupernite.aurus.screen.UpgraderScreen;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

public class ModRegistry {
    public static void registerModRegistries(){
        registerAttributes();
        registerPotionRecipes();
        registerRenderers();
        registerModelLayer();
        registerScreen();
        registerModModels();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntity.JELLYFISH, JellyfishEntity.createJellyfishAttributes());
        FabricDefaultAttributeRegistry.register(ModEntity.ABYSSAL_CRAB, AbyssalCrabEntity.createAbyssalCrabAttributes());
        AurusMod.LOGGER.info("Attributes registered for: " + AurusMod.MOD_ID);
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItem.ABYSSAL_CLAW, ModPotion.ABYSSAL_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotion.ABYSSAL_POTION, Items.REDSTONE, ModPotion.LONG_ABYSSAL_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotion.ABYSSAL_POTION, Items.GLOWSTONE_DUST, ModPotion.STRONG_ABYSSAL_POTION);
        AurusMod.LOGGER.info("Potion Recipes registered for: " + AurusMod.MOD_ID);
    }

    private static void registerRenderers() {
        EntityRendererRegistry.register(ModEntity.JELLYFISH, JellyfishEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.ABYSSAL_CRAB, AbyssalCrabEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.ABYSSAL_PROJECTILE, AbyssalProjectileEntityRenderer::new);
        EntityRendererRegistry.register(ModEntity.SPEAR_ENTITY, SpearModelRenderer::new);
        AurusMod.LOGGER.info("Renderers registered for: " + AurusMod.MOD_ID);
    }

    private static void registerModelLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RELIC2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.RELIC1, RenderLayer.getCutout());


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPEAR, SpearModel::getTexturedModelData);
        AurusMod.LOGGER.info("Model Layers registered for: " + AurusMod.MOD_ID);
    }

    private static void registerScreen() {
        HandledScreens.register(ModScreenHandlers.UPGRADER_SCREEN_HANDLER, UpgraderScreen::new);
        AurusMod.LOGGER.info("Screens registered for: " + AurusMod.MOD_ID);
    }
    public static void registerModModels(){
        AurusMod.LOGGER.info("Models registered for: " + AurusMod.MOD_ID);
    }
}
