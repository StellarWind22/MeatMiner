package com.stellarwind22.meatminer.object;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MReplaceItemEffect implements ConsumeEffect {

    @Override
    public @NotNull Type<MReplaceItemEffect> getType() {
        return this.getType();
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        return false;
    }
}
