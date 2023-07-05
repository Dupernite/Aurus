package com.dupernite.aurus.entity;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.item.Spear.NewSpearEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntity implements ModInitializer {
   /* public static final EntityType<? extends PersistentProjectileEntity> SPEAR_ENTITY =
            Registry.register(Registries.ENTITY_TYPE, new Identifier(AurusMod.MOD_ID, "spear_entity"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC, NewSpearEntity::new)
                            .dimensions(EntityDimensions.fixed(0.5f, 0.75f)).build()); */

    public static final EntityType<NewSpearEntity> SPEAR_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(AurusMod.MOD_ID, "spear_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, NewSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {

    }
}
