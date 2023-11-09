package com.dupernite.aurus.item.client;

import com.dupernite.aurus.item.custom.DivingSuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DivingArmorRenderer extends GeoArmorRenderer<DivingSuitItem> {
    public DivingArmorRenderer() {
        super(new DivingArmorModel());
    }
}
