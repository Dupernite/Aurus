package com.dupernite.aurus.item.custom;

import com.dupernite.aurus.item.ModItem;
import com.dupernite.aurus.item.client.DivingArmorRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DivingSuitItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public DivingSuitItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private DivingArmorRenderer renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new DivingArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
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
