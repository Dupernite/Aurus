package com.dupernite.aurus.screen;

import com.dupernite.aurus.AurusMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
        renderSign1(context, x, y);
        renderSign2(context, x, y);
        renderSign3(context, x, y);
        renderSign4(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 84, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }
    private void renderSign1(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            setColor(2, 43, 20, x, y, 28, context);
        }
    }
    private void renderSign2(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(3, 43, 43, x, y, 52, context);
        }
    }
    private void renderSign3(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(4, 90, 20, x, y, 79, context);
        }
    }
    private void renderSign4(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            setColor(5, 90, 43, x, y, 104, context);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    public int getItemColor(ItemStack itemStack) {
            Item item = itemStack.getItem();
            Identifier itemId = Registries.ITEM.getId(item);

            // Assuming the texture identifier follows a certain pattern based on the item ID
            Identifier textureId = new Identifier(itemId.getNamespace(), "textures/item/" + itemId.getPath() + ".png");

            // Use the textureId to load the texture and analyze its color
            Optional<Resource> resourceOptional = getResource(textureId);
            if (resourceOptional.isPresent()) {
                try {
                    Resource resource = resourceOptional.get();
                    InputStream inputStream = resource.getInputStream();

                    // Use NativeImage to read the image data from the InputStream
                    NativeImage image = NativeImage.read(inputStream);

                    // Close the InputStream after reading
                    inputStream.close();

                    int mostCommonColor = getMostCommonColor(image);
                    System.out.println("Most Common Color - " + mostCommonColor);
                    return mostCommonColor;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return 0xFFFFFF; // Default color if texture couldn't be loaded
        }
    private static Optional<Resource> getResource(Identifier identifier) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            return minecraftClient.getResourceManager().getResource(identifier);
        }
    public int getMostCommonColor(NativeImage image) {
        Map<Integer, Integer> colorCountMap = new HashMap<>();
        int[] pixels = image.copyPixelsRgba();

        System.out.println("Number of pixels: " + pixels.length); // Debugging line

        for (int color : pixels) {
            if (color != 0) { // Skip color 0
                // Swap red and blue channels
                int a = (color >> 24) & 0xFF;
                int r = (color >> 16) & 0xFF;
                int g = (color >> 8) & 0xFF;
                int b = color & 0xFF;
                int correctedColor = (a << 24) | (b << 16) | (g << 8) | r;

                colorCountMap.put(correctedColor, colorCountMap.getOrDefault(correctedColor, 0) + 1);
            }
        }

        System.out.println("Color count map: " + colorCountMap); // Debugging line

        return colorCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0xFFFFFF); // Default color if no color was found
    }


    private void setColor(int slot, int X_Offset, int Y_Offset, int x, int y, int v, DrawContext context) {
        ItemStack itemStack = handler.getSlot(slot).getStack();
        int itemColor = getItemColor(itemStack);
        context.setShaderColor((float) ((itemColor >> 16) & 0xFF) / 255.0F,
                (float) ((itemColor >> 8) & 0xFF) / 255.0F,
                (float) (itemColor & 0xFF) / 255.0F, 1.0F);
        context.drawTexture(TEXTURE, x + X_Offset, y + Y_Offset, 176, v, 43, 24);
    }
}
