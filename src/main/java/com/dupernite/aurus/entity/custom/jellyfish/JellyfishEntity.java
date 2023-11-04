package com.dupernite.aurus.entity.custom.jellyfish;

import blue.endless.jankson.annotation.Nullable;
import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.jellyfish.goal.FollowJellyfishGoal;
import com.dupernite.aurus.entity.custom.jellyfish.goal.JellyfishMovementGoal;
import com.dupernite.aurus.item.ModItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class JellyfishEntity extends FishEntity {

    public JellyfishEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new JellyfishMovementGoal(this));
    }

    public static DefaultAttributeContainer.Builder createJellyfishAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }
}