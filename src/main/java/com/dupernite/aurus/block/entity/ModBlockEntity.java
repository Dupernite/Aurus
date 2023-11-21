package com.dupernite.aurus.block.entity;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.util.AurusModUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntity {
    public static final BlockEntityType<UpgraderBlockEntity> UPGRADER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AurusMod.MOD_ID, "upgrader_be"),
                    FabricBlockEntityTypeBuilder.create(UpgraderBlockEntity::new,
                            ModBlock.UPGRADER).build(null));

    public static void registerBlockEntities() {
        AurusMod.LOGGER.info("[" + AurusModUtils.getModID() + "]" + " Registering Block Entities");
    }
}
