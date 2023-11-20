package com.dupernite.aurus.entity.custom.jellyfish.goal;

import com.dupernite.aurus.entity.ModEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntityRenderer;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;
import java.util.Random;

public class JellyfishMovementGoal extends Goal {
    private final JellyfishEntity jellyfish;
    private final Random random = new Random();
    private int pulsationTimer = 0;
    private boolean isMoving = false;

    public JellyfishMovementGoal(JellyfishEntity jellyfish) {
        this.jellyfish = jellyfish;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return this.jellyfish.hasPositionTarget() || random.nextInt(500) == 0;
    }

    @Override
    public void start() {
        isMoving = true;
        pulsationTimer = 0;
    }

    @Override
    public void stop() {
        isMoving = false;
        jellyfish.setVelocity(Vec3d.ZERO); // Stop the entity's movement
    }

    @Override
    public void tick() {
        if (isMoving) {
            if (pulsationTimer < 20) {
                jellyfish.setVelocity(jellyfish.getRotationVector().multiply(0.1D)); // Move forward
            } else {
                jellyfish.setVelocity(Vec3d.ZERO); // Stop
            }

            pulsationTimer++;
            if (pulsationTimer >= 40) { // Total duration of pulsation cycle
                pulsationTimer = 0;
                isMoving = false;
            }
        } else {
            float sidewaysMotion = MathHelper.sin((jellyfish.age + jellyfish.getId()) * 0.5f) * 0.2f; // Simulate floating motion
            jellyfish.setVelocity(new Vec3d(0, sidewaysMotion, 0)); // Apply floating movement
        }
    }
}