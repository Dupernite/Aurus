package com.dupernite.aurus.util;

import com.dupernite.aurus.AurusMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AurusModUtils {
    // Get Item Color
    public static int getItemColor(ItemStack itemStack) {
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
                return mostCommonColor;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return 0xFFFFFF; // Default color if texture couldn't be loaded
    }
    public static Optional<Resource> getResource(Identifier identifier) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return minecraftClient.getResourceManager().getResource(identifier);
    }
    public static int getMostCommonColor(NativeImage image) {
        Map<Integer, Integer> colorCountMap = new HashMap<>();
        int[] pixels = image.copyPixelsRgba();

        for (int color : pixels) {
            // Swap red and blue channels
            int a = (color >> 24) & 0xFF;
            int r = (color >> 16) & 0xFF;
            int g = (color >> 8) & 0xFF;
            int b = color & 0xFF;
            int correctedColor = (a << 24) | (b << 16) | (g << 8) | r;

            // Calculate brightness
            double brightness = Math.sqrt(0.299 * Math.pow(r, 2) + 0.587 * Math.pow(g, 2) + 0.114 * Math.pow(b, 2));

            // Check if color is non-transparent and brightness is within range
            if (a != 0 && brightness >= 50 && brightness <= 200) {
                colorCountMap.put(correctedColor, colorCountMap.getOrDefault(correctedColor, 0) + 1);
            }
        }

        return colorCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0xFFFFFF); // Default color if no color was found
    }

    // String Related
    public static String capitalizeFirstLetter(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
    public static String getModID() {
        String str = AurusMod.MOD_ID;
        if(AurusMod.MOD_ID == null || AurusMod.MOD_ID.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
