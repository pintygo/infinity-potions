package com.pinare.infinitypotion.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PotionItem.class)
public class PotionMixin {

    /**
     * @author Xaxare
     * @reason Common potion not consume
     */
    @Overwrite
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player)entity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            for (MobEffectInstance effectInstance : PotionUtils.getMobEffects(itemStack)) {
                if (effectInstance.getEffect().isInstantenous()) {
                    effectInstance.getEffect().applyInstantenousEffect(player, player, entity, effectInstance.getAmplifier(), 1.0);
                } else {
                    entity.addEffect(new MobEffectInstance(effectInstance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
//            if (!player.getAbilities().instabuild) {
//                itemStack.shrink(1);
//            }
        }

//        if (player == null || !player.getAbilities().instabuild) {
////            if (itemStack.isEmpty()) {
////                return new ItemStack(Items.GLASS_BOTTLE);
////            }
//
//            if (player != null) {
//                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
//            }
//        }

        entity.gameEvent(GameEvent.DRINK);
        return itemStack;
    }

}
