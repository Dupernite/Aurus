package com.dupernite.aurus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AbyssalEffect extends StatusEffect {
    public AbyssalEffect() {
        super(StatusEffectCategory.HARMFUL, 0x0000FF);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.addVelocity(0, -0.01 * (amplifier + 1), 0);
        if (!entity.hasStatusEffect(StatusEffects.BLINDNESS)) {
            int pullEffectDuration = entity.getStatusEffect(ModEffect.ABYSSAL).getDuration();
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, pullEffectDuration, 0));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public static StatusEffectInstance createAbyssalPullEffect(int duration, int amplifier) {
        return new StatusEffectInstance(ModEffect.ABYSSAL, duration, amplifier);
    }
}
