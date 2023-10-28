package com.dupernite.aurus.compat;

import com.dupernite.aurus.block.ModBlock;
import com.dupernite.aurus.recipe.UpgraderRecipe;
import com.dupernite.aurus.screen.UpgraderScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class AurusModREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new UpgraderCategory());

        registry.addWorkstations(UpgraderCategory.UPGRADING, EntryStacks.of(ModBlock.UPGRADER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(UpgraderRecipe.class, UpgraderRecipe.Type.INSTANCE,
                UpgraderDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                UpgraderScreen.class,
                UpgraderCategory.UPGRADING);
    }
}
