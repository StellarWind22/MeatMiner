package com.github.stellarwind22.meatminer.mixin;

import com.github.stellarwind22.meatminer.content.MeatMinerItems;
import com.github.stellarwind22.meatminer.init.MeatMiner;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmithingTrimRecipe;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Optional;

@Mixin(SmithingTrimRecipe.class)
public class SmithingRecipeMixin {

    @Inject(
            at = @At("HEAD"),
            method = "applyTrim",
            cancellable = true
    )
    private static void applyTrim(HolderLookup.Provider provider, ItemStack itemStack, ItemStack itemStack2, Holder<TrimPattern> holder, CallbackInfoReturnable<ItemStack> cir) {
        Optional<Holder<TrimMaterial>> optional = TrimMaterials.getFromIngredient(provider, itemStack2);
        if(optional.isPresent()) {
            var trimMaterialHolder = optional.get();

            var isMeat = trimMaterialHolder.is(MeatMinerItems.MEAT_TRIM);
            var isCookedMeat = trimMaterialHolder.is(MeatMinerItems.COOKED_MEAT_TRIM);

            if(isMeat || isCookedMeat) {

                ArmorTrim armorTrim = itemStack.get(DataComponents.TRIM);
                ArmorTrim armorTrim2 = new ArmorTrim(optional.get(), holder);

                if (Objects.equals(armorTrim, armorTrim2)) {
                    cir.setReturnValue(ItemStack.EMPTY);
                } else {
                    ItemStack itemStack3 = itemStack.copyWithCount(1);
                    var itemId = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
                    itemStack3.set(DataComponents.TRIM, armorTrim2);

                    if(isMeat) {
                        itemStack3.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, itemId.getPath() + "_meat_trim"));
                    }
                    if(isCookedMeat) {
                        itemStack3.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, itemId.getPath() + "_cooked_meat_trim"));
                    }

                    cir.setReturnValue(itemStack3);
                }
            }
        }
    }
}
