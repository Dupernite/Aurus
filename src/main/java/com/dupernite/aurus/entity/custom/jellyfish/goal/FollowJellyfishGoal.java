package com.dupernite.aurus.entity.custom.jellyfish.goal;

import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;



public class FollowJellyfishGoal extends Goal {
    private final JellyfishEntity jellyfish;
    private final Predicate<JellyfishEntity> targetPredicate;
    @Nullable
    private JellyfishEntity target;
    private final double speed;
    private final EntityNavigation navigation;
    private int updateCountdownTicks;
    private final float minDistance;
    private float oldWaterPathFindingPenalty;
    private final float maxDistance;

    public FollowJellyfishGoal(JellyfishEntity jellyfish, double speed, float minDistance, float maxDistance) {
        this.jellyfish = jellyfish;
        this.targetPredicate = (target) -> target != null && target.getClass() != jellyfish.getClass();
        this.speed = speed;
        this.navigation = jellyfish.getNavigation();
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        if (!(jellyfish.getNavigation() instanceof EntityNavigation)) {
            throw new IllegalArgumentException("Unsupported entity type for FollowJellyfishGoal");
        }
    }

    public boolean canStart() {
        List<JellyfishEntity> list = this.jellyfish.getEntityWorld().getEntitiesByClass(JellyfishEntity.class, this.jellyfish.getBoundingBox().expand(this.maxDistance), this.targetPredicate);
        if (!list.isEmpty()) {
            Iterator<JellyfishEntity> iterator = list.iterator();

            while (iterator.hasNext()) {
                JellyfishEntity jellyfish = iterator.next();
                if (!jellyfish.isInvisible()) {
                    this.target = jellyfish;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean shouldContinue() {
        return this.target != null && !this.navigation.isIdle() && this.jellyfish.squaredDistanceTo(this.target) > (double)(this.minDistance * this.minDistance);
    }

    public void start() {
        this.updateCountdownTicks = 0;
        this.oldWaterPathFindingPenalty = this.jellyfish.getPathfindingPenalty(PathNodeType.WATER);
        this.jellyfish.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    public void stop() {
        this.target = null;
        this.navigation.stop();
        this.jellyfish.setPathfindingPenalty(PathNodeType.WATER, this.oldWaterPathFindingPenalty);
    }

    public void tick() {
        if (this.target != null && !this.jellyfish.isLeashed()) {
            this.jellyfish.getLookControl().lookAt(this.target, 10.0F, (float)this.jellyfish.getMaxLookPitchChange());
            if (--this.updateCountdownTicks <= 0) {
                this.updateCountdownTicks = this.getTickCount(10);
                double d = this.jellyfish.getX() - this.target.getX();
                double e = this.jellyfish.getY() - this.target.getY();
                double f = this.jellyfish.getZ() - this.target.getZ();
                double g = d * d + e * e + f * f;
                if (!(g <= (double)(this.minDistance * this.minDistance))) {
                    this.navigation.startMovingTo(this.target, this.speed);
                } else {
                    this.navigation.stop();
                    LookControl lookControl = this.target.getLookControl();
                    if (g <= (double)this.minDistance || lookControl.getLookX() == this.jellyfish.getX() && lookControl.getLookY() == this.jellyfish.getY() && lookControl.getLookZ() == this.jellyfish.getZ()) {
                        double h = this.target.getX() - this.jellyfish.getX();
                        double i = this.target.getZ() - this.jellyfish.getZ();
                        this.navigation.startMovingTo(this.jellyfish.getX() - h, this.jellyfish.getY(), this.jellyfish.getZ() - i, this.speed);
                    }

                }
            }
        }
    }
}
