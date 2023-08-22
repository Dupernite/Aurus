package com.dupernite.aurus.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DivingArmorEffect extends ArmorItem {


    public DivingArmorEffect(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
                ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
                ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
                ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

                if(helmet.isOf(ModItem.DIVING_HELMET) && chestplate.isOf(ModItem.DIVING_CHESTPLATE) && leggings.isOf(ModItem.DIVING_LEGGINGS) && boots.isOf(ModItem.DIVING_BOOTS) && player.isSubmergedInWater())
                {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 1, false, false, false));
                }
                if(helmet.isOf(ModItem.DIVING_HELMET) && player.isSubmergedInWater())
                {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 1, false, false, false));
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
