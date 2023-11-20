package com.dupernite.aurus.entity.custom.abyssal_projectile;

import com.dupernite.aurus.effect.ModEffect;
import com.dupernite.aurus.entity.ModEntity;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.UUID;

public class AbyssalProjectileEntity extends ProjectileEntity implements GeoEntity {
    private static final double field_30666 = 0.15;
    @Nullable
    private Entity target;
    @Nullable
    private Direction direction;
    private int stepCount;
    private double targetX;
    private double targetY;
    private double targetZ;
    @Nullable
    private UUID targetUuid;
    protected static final RawAnimation IDLE_ANM = RawAnimation.begin().thenLoop("animation.abyssal_projectile.idle");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public AbyssalProjectileEntity(EntityType<AbyssalProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.noClip = true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }


    public AbyssalProjectileEntity(World world, LivingEntity owner, Entity target, Direction.Axis axis) {
        this(ModEntity.ABYSSAL_PROJECTILE, world);
        this.setOwner(owner);
        BlockPos blockPos = owner.getBlockPos();
        double d = (double)blockPos.getX() + 0.5;
        double e = (double)blockPos.getY() + 0.5;
        double f = (double)blockPos.getZ() + 0.5;
        this.refreshPositionAndAngles(d, e, f, this.getYaw(), this.getPitch());
        this.target = target;
        this.direction = Direction.UP;
        this.changeTargetDirection(axis);
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.target != null) {
            nbt.putUuid("Target", this.target.getUuid());
        }

        if (this.direction != null) {
            nbt.putInt("Dir", this.direction.getId());
        }

        nbt.putInt("Steps", this.stepCount);
        nbt.putDouble("TXD", this.targetX);
        nbt.putDouble("TYD", this.targetY);
        nbt.putDouble("TZD", this.targetZ);
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.stepCount = nbt.getInt("Steps");
        this.targetX = nbt.getDouble("TXD");
        this.targetY = nbt.getDouble("TYD");
        this.targetZ = nbt.getDouble("TZD");
        if (nbt.contains("Dir", 99)) {
            this.direction = Direction.byId(nbt.getInt("Dir"));
        }

        if (nbt.containsUuid("Target")) {
            this.targetUuid = nbt.getUuid("Target");
        }

    }

    protected void initDataTracker() {
    }

    @Nullable
    private Direction getDirection() {
        return this.direction;
    }

    private void setDirection(@Nullable Direction direction) {
        this.direction = direction;
    }

    private void changeTargetDirection(@Nullable Direction.Axis axis) {
        double d = 0.5;
        BlockPos blockPos;
        if (this.target == null) {
            blockPos = this.getBlockPos().down();
        } else {
            d = (double)this.target.getHeight() * 0.5;
            blockPos = BlockPos.ofFloored(this.target.getX(), this.target.getY() + d, this.target.getZ());
        }

        double e = (double)blockPos.getX() + 0.5;
        double f = (double)blockPos.getY() + d;
        double g = (double)blockPos.getZ() + 0.5;
        Direction direction = null;
        if (!blockPos.isWithinDistance(this.getPos(), 2.0)) {
            BlockPos blockPos2 = this.getBlockPos();
            List<Direction> list = Lists.newArrayList();
            if (axis != Direction.Axis.X) {
                if (blockPos2.getX() < blockPos.getX() && this.getWorld().isAir(blockPos2.east())) {
                    list.add(Direction.EAST);
                } else if (blockPos2.getX() > blockPos.getX() && this.getWorld().isAir(blockPos2.west())) {
                    list.add(Direction.WEST);
                }
            }

            if (axis != Direction.Axis.Y) {
                if (blockPos2.getY() < blockPos.getY() && this.getWorld().isAir(blockPos2.up())) {
                    list.add(Direction.UP);
                } else if (blockPos2.getY() > blockPos.getY() && this.getWorld().isAir(blockPos2.down())) {
                    list.add(Direction.DOWN);
                }
            }

            if (axis != Direction.Axis.Z) {
                if (blockPos2.getZ() < blockPos.getZ() && this.getWorld().isAir(blockPos2.south())) {
                    list.add(Direction.SOUTH);
                } else if (blockPos2.getZ() > blockPos.getZ() && this.getWorld().isAir(blockPos2.north())) {
                    list.add(Direction.NORTH);
                }
            }

            direction = Direction.random(this.random);
            if (list.isEmpty()) {
                for(int i = 5; !this.getWorld().isAir(blockPos2.offset(direction)) && i > 0; --i) {
                    direction = Direction.random(this.random);
                }
            } else {
                direction = (Direction)list.get(this.random.nextInt(list.size()));
            }

            e = this.getX() + (double)direction.getOffsetX();
            f = this.getY() + (double)direction.getOffsetY();
            g = this.getZ() + (double)direction.getOffsetZ();
        }

        this.setDirection(direction);
        double h = e - this.getX();
        double j = f - this.getY();
        double k = g - this.getZ();
        double l = Math.sqrt(h * h + j * j + k * k);
        if (l == 0.0) {
            this.targetX = 0.0;
            this.targetY = 0.0;
            this.targetZ = 0.0;
        } else {
            this.targetX = h / l * 0.15;
            this.targetY = j / l * 0.15;
            this.targetZ = k / l * 0.15;
        }

        this.velocityDirty = true;
        this.stepCount = 10 + this.random.nextInt(5) * 10;
    }

    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
            this.discard();
        }
    }

    public void tick() {
        super.tick();
        Vec3d vec3d;
        if (!this.getWorld().isClient) {
            if (this.target == null && this.targetUuid != null) {
                this.target = ((ServerWorld)this.getWorld()).getEntity(this.targetUuid);
                if (this.target == null) {
                    this.targetUuid = null;
                }
            }

            if (this.target == null || !this.target.isAlive() || this.target instanceof PlayerEntity && this.target.isSpectator()) {
                if (!this.hasNoGravity()) {
                    this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
                }
            } else {
                this.targetX = MathHelper.clamp(this.targetX * 1.025, -1.0, 1.0);
                this.targetY = MathHelper.clamp(this.targetY * 1.025, -1.0, 1.0);
                this.targetZ = MathHelper.clamp(this.targetZ * 1.025, -1.0, 1.0);
                vec3d = this.getVelocity();
                this.setVelocity(vec3d.add((this.targetX - vec3d.x) * 0.2, (this.targetY - vec3d.y) * 0.2, (this.targetZ - vec3d.z) * 0.2));
            }

            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
            if (hitResult.getType() != HitResult.Type.MISS) {
                this.onCollision(hitResult);
            }
        }

        this.checkBlockCollision();
        vec3d = this.getVelocity();
        this.setPosition(this.getX() + vec3d.x, this.getY() + vec3d.y, this.getZ() + vec3d.z);
        ProjectileUtil.setRotationFromVelocity(this, 0.5F);
        if (this.getWorld().isClient) {
            this.getWorld().addParticle(ParticleTypes.SCULK_SOUL, this.getX() - vec3d.x, this.getY() - vec3d.y + 0.15, this.getZ() - vec3d.z, 0.0, 0.0, 0.0);
        } else if (this.target != null && !this.target.isRemoved()) {
            if (this.stepCount > 0) {
                --this.stepCount;
                if (this.stepCount == 0) {
                    this.changeTargetDirection(this.direction == null ? null : this.direction.getAxis());
                }
            }

            if (this.direction != null) {
                BlockPos blockPos = this.getBlockPos();
                Direction.Axis axis = this.direction.getAxis();
                if (this.getWorld().isTopSolid(blockPos.offset(this.direction), this)) {
                    this.changeTargetDirection(axis);
                } else {
                    BlockPos blockPos2 = this.target.getBlockPos();
                    if (axis == Direction.Axis.X && blockPos.getX() == blockPos2.getX() || axis == Direction.Axis.Z && blockPos.getZ() == blockPos2.getZ() || axis == Direction.Axis.Y && blockPos.getY() == blockPos2.getY()) {
                        this.changeTargetDirection(axis);
                    }
                }
            }
        }

    }

    protected boolean canHit(Entity entity) {
        return super.canHit(entity) && !entity.noClip;
    }

    public boolean isOnFire() {
        return false;
    }

    public boolean shouldRender(double distance) {
        return distance < 16384.0;
    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();
        LivingEntity livingEntity = entity2 instanceof LivingEntity ? (LivingEntity) entity2 : null;
        boolean bl = entity.damage(this.getDamageSources().mobProjectile(this, livingEntity), 4.0F);
        if (bl) {
            this.applyDamageEffects(livingEntity, entity);
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity) entity;
                livingEntity2.addStatusEffect(new StatusEffectInstance(ModEffect.DROWNING, 10 * 20, 3), (Entity) MoreObjects.firstNonNull(entity2, this));
            }
        }
    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 2, 0.2, 0.2, 0.2, 0.0);
        this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0F, 1.0F);
    }

    private void destroy() {
        this.discard();
        this.getWorld().emitGameEvent(GameEvent.ENTITY_DAMAGE, this.getPos(), GameEvent.Emitter.of(this));
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.destroy();
    }

    public boolean canHit() {
        return true;
    }

    public boolean damage(DamageSource source, float amount) {
        if (!this.getWorld().isClient) {
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HURT, 1.0F, 1.0F);
            ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 15, 0.2, 0.2, 0.2, 0.0);
            this.destroy();
        }

        return true;
    }

    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        double d = packet.getVelocityX();
        double e = packet.getVelocityY();
        double f = packet.getVelocityZ();
        this.setVelocity(d, e, f);
    }
}
