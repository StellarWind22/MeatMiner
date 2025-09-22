package com.stellarwind22.meatminer.mixin;

import com.stellarwind22.meatminer.config.MeatMinerConfig;
import com.stellarwind22.meatminer.content.MeatMinerItems;
import com.stellarwind22.meatminer.util.DeferredItem;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(MerchantOffer.class)
public abstract class MerchantOfferMixin {

    @Inject(at = @At("RETURN"), method = "getBaseCostA", cancellable = true)
    public void getBaseCostA(CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        var count = stack.getCount() * MeatMinerConfig.emerald_conversion_rate;

        if(stack.is(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count
                    )
            );
        } else if(stack.is(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            count
                    )
            );
        }
    }

    @Inject(at = @At("RETURN"), method = "getCostA", cancellable = true)
    public void getCostA(CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        var count = stack.getCount();

        if(stack.is(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count * MeatMinerConfig.emerald_conversion_rate
                    )
            );
        } else if(stack.is(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                    )
            );
        }
    }

    @Inject(at = @At("RETURN"), method = "getCostB", cancellable = true)
    public void getCostB(CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        var count = stack.getCount();

        if(stack.is(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count * MeatMinerConfig.emerald_conversion_rate
                    )
            );
        } else if(stack.is(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                    )
            );
        }
    }

    @Inject(at = @At("RETURN"), method = "getItemCostA", cancellable = true)
    public void getItemCostA(CallbackInfoReturnable<ItemCost> cir) {
        var cost = cir.getReturnValue();
        var count = cost.count();
        var item = cost.item().value();
        if(item.equals(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemCost(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count * MeatMinerConfig.emerald_conversion_rate
                    )
            );
        } else if(item.equals(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemCost(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                    )
            );
        }
    }

    @Inject(at = @At("RETURN"), method = "getItemCostB", cancellable = true)
    public void getItemCostB(CallbackInfoReturnable<Optional<ItemCost>> cir) {
        var returnValue = cir.getReturnValue();
        if(returnValue.isPresent()) {
            var cost = returnValue.get();
            var count = cost.count();
            var item = cost.item().value();
            if(item.equals(Items.EMERALD)) {
                cir.setReturnValue(
                        Optional.of(new ItemCost(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        ))
                );
            } else if(item.equals(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        Optional.of(new ItemCost(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        ))
                );
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "getResult", cancellable = true)
    public void getResult(CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        var count = stack.getCount();

        if(stack.is(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count * MeatMinerConfig.emerald_conversion_rate
                    )
            );
        } else if(stack.is(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                    )
            );
        }
    }

    @Inject(at = @At("RETURN"), method = "assemble", cancellable = true)
    public void assemble(CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        var count = stack.getCount();

        if(stack.is(Items.EMERALD)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT),
                            count * MeatMinerConfig.emerald_conversion_rate
                    )
            );
        } else if(stack.is(Items.EMERALD_BLOCK)) {
            cir.setReturnValue(
                    new ItemStack(
                            new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                            (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                    )
            );
        }
    }

    @Final @Shadow
    private ItemCost baseCostA;

    @Shadow
    public abstract ItemCost getItemCostA();

    @Inject(at = @At("RETURN"), method = "satisfiedBy", cancellable = true)
    public void satisfiedBy(ItemStack itemStack, ItemStack itemStack2, CallbackInfoReturnable<Boolean> cir) {
        if(itemStack.is(Items.EMERALD) || itemStack.is(Items.EMERALD_BLOCK) || itemStack2.is(Items.EMERALD) || itemStack2.is(Items.EMERALD_BLOCK)) {
            MerchantOffer self = (MerchantOffer) (Object) this;

            if (self.getItemCostA().test(itemStack) && itemStack.getCount() >= meatminer$getModifiedCostCount(self, this.baseCostA)) {
                if (self.getItemCostB().isEmpty()) {
                    cir.setReturnValue(itemStack2.isEmpty());
                } else {
                    var costB = self.getItemCostB().get();
                    cir.setReturnValue(costB.test(itemStack2) && itemStack2.getCount() >= costB.count());
                }
            } else {
                cir.setReturnValue(false);
            }
        }
    }

    @Unique
    private int meatminer$getModifiedCostCount(MerchantOffer self, ItemCost itemCost) {
        int i = itemCost.count();
        int j = Math.max(0, Mth.floor((float)(i * self.getDemand()) * self.getPriceMultiplier()));
        return Mth.clamp(i + j + self.getSpecialPriceDiff(), 1, itemCost.itemStack().getMaxStackSize());
    }
}
