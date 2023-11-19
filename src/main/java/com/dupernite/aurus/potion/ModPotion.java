package com.dupernite.aurus.potion;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.effect.ModEffect;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotion {
    public static final Potion ABYSSAL_POTION = registerPotion("drowning",
            new Potion(new StatusEffectInstance(ModEffect.ABYSSAL, 1800)));
    public static final Potion LONG_ABYSSAL_POTION = registerPotion("long_drowning",
            new Potion("drowning", new StatusEffectInstance(ModEffect.ABYSSAL, 4800)));
    public static final Potion STRONG_ABYSSAL_POTION = registerPotion("strong_drowning",
            new Potion("drowning", new StatusEffectInstance(ModEffect.ABYSSAL, 400, 3)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(AurusMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        AurusMod.LOGGER.info("Registering Potions for " + AurusMod.MOD_ID);
    }
}
