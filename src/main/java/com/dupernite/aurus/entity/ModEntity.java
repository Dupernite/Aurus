package com.dupernite.aurus.entity;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.entity.custom.spear.SpearEntity;
import com.dupernite.aurus.entity.custom.jellyfish.JellyfishEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModEntity extends MobEntity {
    public static final EntityType<JellyfishEntity> JELLYFISH = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AurusMod.MOD_ID, "jellyfish"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, JellyfishEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.5f)).build()
    );

    public static final EntityType<SpearEntity> SPEAR_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AurusMod.MOD_ID, "spear_entity"),
            FabricEntityTypeBuilder.<SpearEntity>create(SpawnGroup.MISC, SpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.55f, 0.55f)).build());


    protected ModEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
}
