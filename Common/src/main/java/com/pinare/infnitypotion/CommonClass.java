package com.pinare.infnitypotion;

import com.pinare.infnitypotion.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CommonClass {

    // common sample init
    public static void init() {

        Constants.LOGGER.info("Hello from Common init on {}! we are currently in a {} environment!",
                Services.PLATFORM.getPlatformName(),
                Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
        Constants.LOGGER.info("Diamond Item >> {}", Registry.ITEM.getKey(Items.DIAMOND));
    }

    // sample method serves as a hook to modify item tooltips.
    public static void onItemTooltip(ItemStack stack, TooltipFlag context, List<Component> tooltip) {

        if (stack.isEmpty()) {return;}

        final FoodProperties food = stack.getItem().getFoodProperties();

        if (food == null) {return;}

        tooltip.add(Component.literal("Nutrition: " + food.getNutrition()));
        tooltip.add(Component.literal("Saturation: " + food.getSaturationModifier()));

    }
}
