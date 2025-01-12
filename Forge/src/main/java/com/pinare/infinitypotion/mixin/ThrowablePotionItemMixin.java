package com.pinare.infinitypotion.mixin;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ThrowablePotionItem.class)
public class ThrowablePotionItemMixin {

    /**
     * @author Xaxare
     * @reason ThrowablePotion not shrink after throw
     */
    @Overwrite
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            ThrownPotion thrownPotion = new ThrownPotion(level, player);
            thrownPotion.setItem(itemStack);
            thrownPotion.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.5F, 1.0F);
            level.addFreshEntity(thrownPotion);
        }

        player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
