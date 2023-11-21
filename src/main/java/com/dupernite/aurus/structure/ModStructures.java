package com.dupernite.aurus.structure;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.util.AurusModUtils;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.dupernite.aurus.structure.dungeon.*;
import net.minecraft.world.gen.structure.StructureType;

public class ModStructures {
    public static StructureType<Dungeon> DUNGEON;

    public static void registerStructure() {
        AurusMod.LOGGER.info("[" + AurusModUtils.getModID() + "]" + " Registering Structures");
        DUNGEON = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(AurusMod.MOD_ID, "dungeon"), () -> Dungeon.CODEC);
    }
}
