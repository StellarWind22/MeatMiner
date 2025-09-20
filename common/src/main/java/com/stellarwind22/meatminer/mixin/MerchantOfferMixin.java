package com.stellarwind22.meatminer.mixin;

import com.stellarwind22.meatminer.content.MeatMinerItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Optional;

@Mixin(MerchantOffer.class)
public class MerchantOfferMixin {

    @ModifyVariable(
            at = @At("HEAD"),
            method = "<init>(Lnet/minecraft/world/item/trading/ItemCost;Ljava/util/Optional;Lnet/minecraft/world/item/ItemStack;IIF)V",
            index = 1,
            argsOnly = true
    )
    private static ItemCost costA(ItemCost costA) {
        if(costA.item().value().equals(Items.EMERALD)) {
            costA = new ItemCost(
                    MeatMinerItems.MEAT.get(),
                    costA.count()
            );
        }
        return costA;
    }

    @ModifyVariable(
            at = @At("HEAD"),
            method = "<init>(Lnet/minecraft/world/item/trading/ItemCost;Ljava/util/Optional;Lnet/minecraft/world/item/ItemStack;IIF)V",
            index = 2,
            argsOnly = true
    )
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private static Optional<ItemStack> costB (Optional<ItemStack> costB) {
        if(costB.isPresent()) {
            var costBItem = costB.orElseThrow();

            if(costBItem.is(Items.EMERALD)) {
                costB = Optional.of(
                        new ItemStack(
                                MeatMinerItems.MEAT.get(),
                                costBItem.getCount()
                        )
                );
            }
        }
        return costB;
    }

    @ModifyVariable(
            at = @At("HEAD"),
            method = "<init>(Lnet/minecraft/world/item/trading/ItemCost;Ljava/util/Optional;Lnet/minecraft/world/item/ItemStack;IIF)V",
            index = 3,
            argsOnly = true
    )
    private static ItemStack result(ItemStack result) {
        if(result.is(Items.EMERALD)) {
            result = new ItemStack(
                    MeatMinerItems.MEAT.get(),
                    result.getCount()
            );
        }
        return result;
    }
}
