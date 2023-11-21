package com.dupernite.aurus.screen;

import com.dupernite.aurus.AurusMod;
import com.dupernite.aurus.util.AurusModUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class UpgraderScreen extends HandledScreen<UpgraderScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(AurusMod.MOD_ID, "textures/gui/upgrader_gui.png");

    public UpgraderScreen(UpgraderScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        titleY = 1000;
        playerInventoryTitleY = 1000;
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderSlot1(context, x, y);
        renderSlot2(context, x, y);
        renderSlot3(context, x, y);
        renderSlot4(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 84, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }
    private void renderSlot1(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            setColor(2, 43, 20, x, y, 176,28,43, 23, context);
        }
    }
    private void renderSlot2(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(3, 43, 43, x, y, 176,52,43, 23, context);
        }
    }
    private void renderSlot3(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(4, 90, 20, x, y, 176,80,43, 23, context);
        }
    }
    private void renderSlot4(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(5, 90, 43, x, y, 176,104,43, 23, context);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private void setColor(int slot, int X_offset, int Y_offset, int x_value, int y_value, int u, int v, int width, int height, DrawContext context) {
        ItemStack itemStack = handler.getSlot(slot).getStack();
        int itemColor = AurusModUtils.getItemColor(itemStack);
        context.setShaderColor((float) ((itemColor >> 16) & 0xFF) / 255.0F,
                (float) ((itemColor >> 8) & 0xFF) / 255.0F,
                (float) (itemColor & 0xFF) / 255.0F, 1.0F);
        context.drawTexture(TEXTURE, x + X_offset, y + Y_offset, u, v, width, height);
    }
}
