package com.dupernite.aurus.data;

import com.dupernite.aurus.block.ModBlocks;
import com.dupernite.aurus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModBlocks.OVERWORLD_QUARTZ_ORE), RecipeCategory.MISC, ModItems.QUARTZ_FRAGMENT,
                0.2f, 200, "quartz_fragment");
        offerBlasting(exporter, List.of(ModBlocks.OVERWORLD_QUARTZ_ORE), RecipeCategory.MISC, ModItems.QUARTZ_FRAGMENT,
                0.2f, 100, "quartz_fragment");

        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_OVERWORLD_QUARTZ_ORE), RecipeCategory.MISC, ModItems.QUARTZ_FRAGMENT,
                0.2f, 200, "quartz_fragment");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_OVERWORLD_QUARTZ_ORE), RecipeCategory.MISC, ModItems.QUARTZ_FRAGMENT,
                0.2f, 100, "quartz_fragment");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.QUARTZ)
                .pattern(" S ")
                .pattern("SSS")
                .pattern(" S ")
                .input('S', ModItems.QUARTZ_FRAGMENT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.QUARTZ_FRAGMENT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.QUARTZ_FRAGMENT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Items.QUARTZ)));
    }
}
