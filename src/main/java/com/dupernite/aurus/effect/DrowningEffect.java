package com.dupernite.aurus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class DrowningEffect extends StatusEffect {
    public DrowningEffect() {
        super(StatusEffectCategory.HARMFUL, 0x292929);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        /*float cappedAmplifier = Math.abs(amplifier);
        if (amplifier < 0) {
            cappedAmplifier = 256 + amplifier;
        }*/

        entity.addVelocity(0, (float)(-0.01 * (amplifier + 1)), 0);
        if (!entity.hasStatusEffect(StatusEffects.DARKNESS)) {
            int pullEffectDuration = entity.getStatusEffect(ModEffect.DROWNING).getDuration();
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, pullEffectDuration, 0));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public static StatusEffectInstance createAbyssalPullEffect(int duration, int amplifier) {
        return new StatusEffectInstance(ModEffect.DROWNING, duration, amplifier);
    }
}
