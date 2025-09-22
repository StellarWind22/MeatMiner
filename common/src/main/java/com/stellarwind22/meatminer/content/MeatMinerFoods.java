package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;

public class MeatMinerFoods {

    private static DeferredRegister<ConsumeEffect.Type<?>> CONSUME_EFFECT_TYPE;

    //Nugget
    public static FoodProperties MEAT_NUGGET;
    public static FoodProperties COOKED_MEAT_NUGGET;
    public static Consumable MEAT_NUGGET_CONSUMABLE;

    //Item
    public static FoodProperties MEAT;
    public static FoodProperties COOKED_MEAT;

    //Block
    public static FoodProperties MEAT_BLOCK;
    public static FoodProperties COOKED_MEAT_BLOCK;
    public static Consumable MEAT_BLOCK_CONSUMABLE;

    public static void init() {

        CONSUME_EFFECT_TYPE = DeferredRegister.create(MeatMiner.MOD_ID, Registries.CONSUME_EFFECT_TYPE);

        MEAT_NUGGET = new FoodProperties(1, 0.1f, false);
        COOKED_MEAT_NUGGET = new FoodProperties(2, 0.2f, false);

        MEAT_NUGGET_CONSUMABLE = Consumables.defaultFood().consumeSeconds(0.8f).build();

        MEAT = new FoodProperties(4, 0.4f, false);
        COOKED_MEAT = new FoodProperties(8, 0.8f, false);

        MEAT_BLOCK = new FoodProperties(7, 0.7f, false);
        COOKED_MEAT_BLOCK = new FoodProperties(14, 1.4f, false);

        MEAT_BLOCK_CONSUMABLE = Consumables.defaultFood().consumeSeconds(3.2f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOWNESS, 300, 0), 0.8f)).build();

        CONSUME_EFFECT_TYPE.register();
    }

    private static <T extends ConsumeEffect.Type<?>> RegistrySupplier<T> registerConsumeEffect(String name, T consumeEffectType) {
        return CONSUME_EFFECT_TYPE.register(name, () -> consumeEffectType);
    }
}
