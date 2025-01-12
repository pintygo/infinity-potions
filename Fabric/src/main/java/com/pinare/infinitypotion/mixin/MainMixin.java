package com.pinare.infinitypotion.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TitleScreen.class)
public class MainMixin {

    //sample mixin for Fabric
//    @Inject(at = @At("HEAD"), method = "init()V")
//    private void init(CallbackInfo info) {
//
//        Constants.LOGGER.info("This line is printed by an example mod mixin from Fabric!");
//        Constants.LOGGER.info("MC Version: {}", Minecraft.getInstance().getVersionType());
//        Constants.LOGGER.info("Classloader: {}", this.getClass().getClassLoader());
//    }
}