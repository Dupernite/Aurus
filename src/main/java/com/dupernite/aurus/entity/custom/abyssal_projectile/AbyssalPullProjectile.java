package com.dupernite.aurus.entity.custom.abyssal_projectile;

import com.dupernite.aurus.entity.ModEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AbyssalPullProjectile extends ProjectileEntity implements GeoEntity {
    protected static final RawAnimation IDLE_ANM = RawAnimation.begin().thenLoop("animation.abyssal_projectile.idle");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public AbyssalPullProjectile(EntityType<? extends AbyssalPullProjectile> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            Entity target = ((EntityHitResult) hitResult).getEntity();

            if (target instanceof LivingEntity) {
                target.setVelocity(0, -0.5, 0);
            }

            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
        } else {
            if (this.isSubmergedInWater()) {
                this.applyPullEffect();
            }
        }
    }

    private void applyPullEffect() {
        double range = 16.0;
        double pullStrength = 0.1;

        this.getWorld().getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(range),
                entity -> entity != this.getOwner()).forEach(entity -> {
            double dx = this.getX() - entity.getX();
            double dz = this.getZ() - entity.getZ();
            double distance = Math.sqrt(dx * dx + dz * dz);

            if (distance > 0) {
                double motionX = dx / distance * pullStrength;
                double motionZ = dz / distance * pullStrength;

                entity.addVelocity(motionX, 0, motionZ);
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
