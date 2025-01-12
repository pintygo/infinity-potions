package com.pinare.infnitypotion;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class Main {
    
    public Main() {

        // sample logger usage
        Constants.LOGGER.info("Hello Forge world!");

        // sample class init
        CommonClass.init();

        //sample event register
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
        
    }

    private void onItemTooltip(ItemTooltipEvent event) {
        CommonClass.onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }
}