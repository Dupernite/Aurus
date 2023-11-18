package com.dupernite.aurus.effect;

import com.dupernite.aurus.AurusMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffect {
    public static final StatusEffect ABYSSAL = registerStatusEffect("abyssal", new AbyssalEffect());

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AurusMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        AurusMod.LOGGER.info("Registering Mod Effects for " + AurusMod.MOD_ID);
    }
}