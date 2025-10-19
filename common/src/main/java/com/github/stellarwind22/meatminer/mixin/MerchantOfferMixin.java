package com.github.stellarwind22.meatminer.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.github.stellarwind22.meatminer.config.MeatMinerConfig;
import com.github.stellarwind22.meatminer.content.MeatMinerItems;
import com.github.stellarwind22.meatminer.util.DeferredItem;
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

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mixin(MerchantOffer.class)
public abstract class MerchantOfferMixin {

    @Inject(at = @At("RETURN"), method = "getBaseCostA", cancellable = true)
    public void getBaseCostA(CallbackInfoReturnable<ItemStack> cir) {
        if(MeatMinerConfig.modify_trades) {
            var stack = cir.getReturnValue();
            var count = stack.getCount();

            if (stack.is(Items.EMERALD)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        )
                );
            }
            if (stack.is(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        )
                );
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "getCostA", cancellable = true)
    public void getCostA(CallbackInfoReturnable<ItemStack> cir) {
        if(MeatMinerConfig.modify_trades) {
            var stack = cir.getReturnValue();
            var count = stack.getCount();

            if (stack.is(Items.EMERALD)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        )
                );
            }
            if (stack.is(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        )
                );
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "getCostB", cancellable = true)
    public void getCostB(CallbackInfoReturnable<ItemStack> cir) {
        if(MeatMinerConfig.modify_trades) {
            var stack = cir.getReturnValue();
            var count = stack.getCount();

            if (stack.is(Items.EMERALD)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        )
                );
            }
            if (stack.is(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        )
                );
            }
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
        }
        if(item.equals(Items.EMERALD_BLOCK)) {
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
            }
            if(item.equals(Items.EMERALD_BLOCK)) {
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
        if(MeatMinerConfig.modify_trades) {
            var stack = cir.getReturnValue();
            var count = stack.getCount();

            if (stack.is(Items.EMERALD)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        )
                );
            }
            if (stack.is(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        )
                );
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "assemble", cancellable = true)
    public void assemble(CallbackInfoReturnable<ItemStack> cir) {
        if(MeatMinerConfig.modify_trades) {
            var stack = cir.getReturnValue();
            var count = stack.getCount();

            if(stack.is(Items.EMERALD)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT),
                                count * MeatMinerConfig.emerald_conversion_rate
                        )
                );
            }
            if(stack.is(Items.EMERALD_BLOCK)) {
                cir.setReturnValue(
                        new ItemStack(
                                new DeferredItem<>(MeatMinerItems.MEAT_BLOCK),
                                (count * 9) * MeatMinerConfig.emerald_conversion_rate / 4
                        )
                );
            }
        }
    }

    @Final @Shadow
    private ItemCost baseCostA;

    @Shadow
    public abstract ItemCost getItemCostA();

    @Final @Shadow
    private Optional<ItemCost> costB;

    @Shadow
    public abstract Optional<ItemCost> getItemCostB();

    @Unique
    @WrapOperation(method = "satisfiedBy", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/trading/ItemCost;test(Lnet/minecraft/world/item/ItemStack;)Z"))
    private boolean meatminer$satisfiedBy$testWrapper(
            ItemCost instance, ItemStack itemStack, Operation<Boolean> original
    ) {
        ItemCost cost = instance == baseCostA ? this.getItemCostA() : instance == this.costB.orElse(null) ? this.getItemCostB().orElse(instance) : instance;
        return original.call(cost, itemStack);
    }
}
