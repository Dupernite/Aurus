package com.dupernite.aurus.entity.custom.abyssal_crab;

import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.abyssal_projectile.AbyssalProjectileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SpiderNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.function.BooleanSupplier;


public class AbyssalCrabEntity extends HostileEntity implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public static Boolean isShooting = false;
    public AbyssalCrabEntity(EntityType<? extends AbyssalCrabEntity> entityType, World world) {
        super(entityType, world);
    }
    private static final TrackedData<Byte> ABYSSAL_CRAB_FLAGS;

    protected void initGoals() {
        this.goalSelector.add(10, new AbyssalShootProjectileGoal(this, 0.8D));
        this.goalSelector.add(9, new AbyssalWallAndWaterGoal(this));
        this.targetSelector.add(1, new AbyssalCrabEntity.TargetGoal(this, PlayerEntity.class));
    }


    protected Vector3f getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return new Vector3f(0.0F, dimensions.height * 0.85F, 0.0F);
    }

    protected EntityNavigation createNavigation(World world) {
        return new SpiderNavigation(this, world);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ABYSSAL_CRAB_FLAGS, (byte)0);
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            this.setClimbingWall(this.horizontalCollision);
        }

        if (this.isSubmergedInWater()) {
            this.addWaterBreathingEffect();
        }
    }

    private void addWaterBreathingEffect() {
        if (!this.hasStatusEffect(StatusEffects.WATER_BREATHING)) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false));
        }
    }

    @Override
    public boolean isSubmergedInWater() {
        return this.getWorld().getFluidState(this.getBlockPos()).isIn(FluidTags.WATER);
    }

    public static DefaultAttributeContainer.Builder createAbyssalCrabAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896);
    }

/*    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }*/

    public boolean isClimbing() {
        return this.isClimbingWall();
    }

    public void slowMovement(BlockState state, Vec3d multiplier) {
        if (!state.isOf(Blocks.COBWEB)) {
            super.slowMovement(state, multiplier);
        }

    }


    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    public boolean isClimbingWall() {
        return ((Byte)this.dataTracker.get(ABYSSAL_CRAB_FLAGS) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = (Byte)this.dataTracker.get(ABYSSAL_CRAB_FLAGS);
        if (climbing) {
            b = (byte)(b | 1);
        } else {
            b &= -2;
        }

        this.dataTracker.set(ABYSSAL_CRAB_FLAGS, b);
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.65F;
    }

    protected float getUnscaledRidingOffset(Entity vehicle) {
        return vehicle.getWidth() <= this.getWidth() ? -0.3125F : 0.0F;
    }

    static {
        ABYSSAL_CRAB_FLAGS = DataTracker.registerData(SpiderEntity.class, TrackedDataHandlerRegistry.BYTE);
    }


    private static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
        public TargetGoal(AbyssalCrabEntity abyssal_crab, Class<T> targetEntityClass) {
            super(abyssal_crab, targetEntityClass, true);
        }

        public boolean canStart() {
            return super.canStart();
        }
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        /*AnimationController<AbyssalCrabEntity> controller = new AnimationController<>(this, "controller", 0, this::shootingAnimController);
        controllers.add(controller);*/
    }
/*    protected <E extends AbyssalCrabEntity> PlayState shootingAnimController(final AnimationState<E> event) {
        if (isShooting) {
            event.setAndContinue(SHOOTING_ANIM);
            return PlayState.CONTINUE;
        }
        event.setAndContinue(IDLE_ANM);
        return PlayState.CONTINUE;
    }*/

    private static class AbyssalShootProjectileGoal extends Goal {
        private final AbyssalCrabEntity entity;
        private int shotDelay;

        public AbyssalShootProjectileGoal(AbyssalCrabEntity abyssalCrabEntity, double speed) {
            this.entity = abyssalCrabEntity;
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            return this.entity.getTarget() instanceof PlayerEntity;
        }

        @Override
        public void start() {
            if (this.entity.getTarget() != null && this.entity.getTarget() instanceof PlayerEntity) {
                this.shootProjectile();
            }
        }

        @Override
        public void tick() {
            super.tick();
            if (this.entity.getTarget() != null && this.entity.getTarget() instanceof PlayerEntity) {
                if (shotDelay <= 0) {
                    this.entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, this.entity.getTarget().getPos());
                    this.shootProjectile();
                    shotDelay = 20;
                } else {
                    shotDelay--;
                }
            }
        }

        private void shootProjectile() {
            PlayerEntity targetPlayer = (PlayerEntity) this.entity.getTarget();
            isShooting = true;
            AbyssalProjectileEntity projectile = new AbyssalProjectileEntity(ModEntity.ABYSSAL_PROJECTILE, this.entity.getWorld());

            // Convert pixel values to world coordinates
            double mouthX = this.entity.getX() + (-0.5 / 16.0) + (2 / 16.0); // Increase offset to the right
            double mouthY = this.entity.getY() + (5 / 16.0);
            double mouthZ = this.entity.getZ() + (-5 / 16.0);

            projectile.refreshPositionAndAngles(mouthX, mouthY, mouthZ, this.entity.getYaw(), this.entity.getPitch());

            double d = targetPlayer.getX() - mouthX;
            double e = targetPlayer.getEyeY() - 0.5 - projectile.getY(); // Aim lower than the player's head
            double f = targetPlayer.getZ() - mouthZ;
            float g = MathHelper.sqrt((float)(d * d + f * f)) * 0.2F;

            projectile.setVelocity(d, e + g, f, 1.6F, 1); // Set deviation to 1
            isShooting = false;

            this.entity.getWorld().spawnEntity(projectile);
        }
    }
    private static class AbyssalWallAndWaterGoal extends Goal {
        private final AbyssalCrabEntity entity;

        public AbyssalWallAndWaterGoal(AbyssalCrabEntity abyssalCrabEntity) {
            this.entity = abyssalCrabEntity;
        }

        @Override
        public boolean canStart() {
            return !this.entity.isSubmergedInWater() || !this.entity.isOnGround();
        }

        @Override
        public void start() {
            BlockPos targetPos = this.findNearestWall();
            if (targetPos != null) {
                this.entity.getNavigation().startMovingTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, 0.8);
            }
        }

        private BlockPos findNearestWall() {
            BlockPos.Mutable mutablePos = new BlockPos.Mutable(this.entity.getX(), this.entity.getY(), this.entity.getZ());
            WorldView world = this.entity.getWorld();

            for (Direction direction : Direction.values()) {
                mutablePos.set(this.entity.getX() + direction.getOffsetX(), this.entity.getY(), this.entity.getZ() + direction.getOffsetZ());

                if (world.getBlockState(mutablePos).isOpaque() && world.getBlockState(mutablePos.up()).isAir() && world.getBlockState(mutablePos.down()).isAir()) {
                    return mutablePos;
                }
            }

            return null;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
