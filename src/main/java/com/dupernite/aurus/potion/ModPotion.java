package com.dupernite.aurus.potion;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.effect.ModEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotion {
    public static final Potion ABYSSAL_POTION = registerPotion("drowning",
            new Potion(new StatusEffectInstance(ModEffect.DROWNING, 1800)));
    public static final Potion LONG_ABYSSAL_POTION = registerPotion("long_drowning",
            new Potion("drowning", new StatusEffectInstance(ModEffect.DROWNING, 4800)));
    public static final Potion STRONG_ABYSSAL_POTION = registerPotion("strong_drowning",
            new Potion("drowning", new StatusEffectInstance(ModEffect.DROWNING, 400, 3)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(AurusMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        AurusMod.LOGGER.info("Registering Potions for " + AurusMod.MOD_ID);
    }
}
