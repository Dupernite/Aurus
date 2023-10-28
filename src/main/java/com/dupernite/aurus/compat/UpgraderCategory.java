package com.dupernite.aurus.compat;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.block.ModBlock;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

// Done with the help:
// https://github.com/TeamGalacticraft/Galacticraft/tree/main (MIT License)
public class UpgraderCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            new Identifier(AurusMod.MOD_ID, "textures/gui/upgrader_gui.png");
    public static final CategoryIdentifier<UpgraderDisplay> UPGRADING =
            CategoryIdentifier.of(AurusMod.MOD_ID, "upgrading");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return UPGRADING;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Upgrader");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlock.UPGRADER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE,
                new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 11))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 14))
                .entries(display.getInputEntries().get(1)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 57))
                .entries(display.getInputEntries().get(2)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 134, startPoint.y + 14))
                .entries(display.getInputEntries().get(3)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 134, startPoint.y + 57))
                .entries(display.getInputEntries().get(4)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59))
                .markOutput().entries(display.getOutputEntries().get(0)));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
