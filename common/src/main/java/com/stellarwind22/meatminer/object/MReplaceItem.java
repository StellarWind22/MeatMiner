package com.stellarwind22.meatminer.object;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.stellarwind22.meatminer.content.MeatMinerFoods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record MReplaceItem(List<MobEffectInstance> effects, float probability) implements ConsumeEffect {

    public static final MapCodec<MReplaceItem> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(MobEffectInstance.CODEC.listOf().fieldOf("effect").forGetter(MReplaceItem::effects), Codec.floatRange(0.0F, 1.0F).optionalFieldOf("probability", 1.0F).forGetter(MReplaceItem::probability)).apply(instance, MReplaceItem::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, MReplaceItem> STREAM_CODEC;

    @Override
    public @NotNull Type<? extends ConsumeEffect> getType() {
        return MeatMinerFoods.MEAT_BLOCK_CONSUME_TYPE.get();
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        return false;
    }

    static {
        STREAM_CODEC = StreamCodec.composite(MobEffectInstance.STREAM_CODEC.apply(ByteBufCodecs.list()), MReplaceItem::effects, ByteBufCodecs.FLOAT, MReplaceItem::probability, MReplaceItem::new);
    }
}
