package com.pinare.template;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class Main implements ModInitializer {
    
    @Override
    public void onInitialize() {

        // sample logger usage
        Constants.LOGGER.info("Hello Fabric world!");

        // sample class init
        CommonClass.init();

        //sample event register
        ItemTooltipCallback.EVENT.register(CommonClass::onItemTooltip);
    }
}
