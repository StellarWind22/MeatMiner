package com.stellarwind22.meatminer.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(MerchantOffer.class)
public class MerchantOfferMixin {

    @Inject(
            at = @At("RETURN"),
            method = "getBaseCostA"
    )
    public void getBaseCostA(CallbackInfoReturnable<ItemStack> cir) {
        //return this.baseCostA.itemStack();
    }

    @Inject(
            at = @At("RETURN"),
            method = "getCostA"
    )
    public void getCostA(CallbackInfoReturnable<ItemStack> cir) {
        //return this.baseCostA.itemStack().copyWithCount(this.getModifiedCostCount(this.baseCostA));
    }

    @Inject(
            at = @At("RETURN"),
            method = "getCostB"
    )
    public void getCostB(CallbackInfoReturnable<ItemStack> cir) {
        //return this.costB.map(ItemCost::itemStack).orElse(ItemStack.EMPTY);
    }

    @Inject(
            at = @At("RETURN"),
            method = "getItemCostA"
    )
    public void getItemCostA(CallbackInfoReturnable<ItemCost> cir) {
        //return this.baseCostA;
    }

    @Inject(
            at = @At("RETURN"),
            method = "getItemCostB"
    )
    public void getItemCostB(CallbackInfoReturnable<Optional<ItemCost>> cir) {
        //return this.costB;
    }

    @Inject(
            at = @At("RETURN"),
            method = "getResult"
    )
    public void getResult(CallbackInfoReturnable<ItemStack> cir) {
        //return this.result;
    }

    @Inject(
            at = @At("RETURN"),
            method = "assemble"
    )
    public void assemble(CallbackInfoReturnable<ItemStack> cir) {
        //return this.result.copy();
    }

    @Inject(
            at = @At("RETURN"),
            method = "satisfiedBy"
    )
    public void satisfiedBy(ItemStack itemStack, ItemStack itemStack2, CallbackInfoReturnable<Boolean> cir) {
//        if (this.baseCostA.test(itemStack) && itemStack.getCount() >= this.getModifiedCostCount(this.baseCostA)) {
//            if (!this.costB.isPresent()) {
//                return itemStack2.isEmpty();
//            } else {
//                return ((ItemCost)this.costB.get()).test(itemStack2) && itemStack2.getCount() >= ((ItemCost)this.costB.get()).count();
//            }
//        } else {
//            return false;
//        }
    }
}
