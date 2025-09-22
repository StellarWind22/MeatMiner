package com.stellarwind22.meatminer.object;

import com.stellarwind22.meatminer.content.MeatMinerFoods;
import com.stellarwind22.meatminer.util.DeferredItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public record MReplaceItem(DeferredItem<Item> replaceWith, Optional<MobEffectInstance> effect) implements ConsumeEffect {

    public MReplaceItem(DeferredItem<Item> replaceWith) {
        this(replaceWith, Optional.empty());
    }

    @Override
    public @NotNull Type<? extends ConsumeEffect> getType() {
        return MeatMinerFoods.MEAT_BLOCK_CONSUME_TYPE.get();
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        return false;
    }
}
