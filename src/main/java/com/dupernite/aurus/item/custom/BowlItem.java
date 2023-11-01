package com.dupernite.aurus.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BowlItem extends Item {
    public BowlItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;

            if (!player.isCreative()) {
                if (stack.getItem() instanceof BowlItem) {
                    if (stack.getCount() == 1) {
                        ItemStack existingBowls = findEmptyBowlStack(player);

                        if (!existingBowls.isEmpty()) {
                            stack.decrement(1);
                        } else {
                            return new ItemStack(Items.BOWL);
                        }
                    } else {
                        stack.decrement(1);
                        ItemStack existingBowls = findEmptyBowlStack(player);

                        if (!existingBowls.isEmpty()) {
                            existingBowls.increment(1);
                        } else {
                            player.getInventory().insertStack(new ItemStack(Items.BOWL));
                        }
                    }
                }
            }
        }

        return super.finishUsing(stack, world, user);
    }

    private ItemStack findEmptyBowlStack(PlayerEntity player) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == Items.BOWL && stack.isEmpty()) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
}
