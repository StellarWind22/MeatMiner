package com.stellarwind22.meatminer.content;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class MeatMinerFoods {

    //Nugget
    public static FoodProperties RAW_MEAT_NUGGET;
    public static FoodProperties COOKED_MEAT_NUGGET;

    //Item
    public static FoodProperties RAW_MEAT;
    public static FoodProperties COOKED_MEAT;

    //Block
    public static FoodProperties RAW_MEAT_BLOCK;
    public static FoodProperties COOKED_MEAT_BLOCK;
    public static Consumable MEAT_BLOCK_CONSUMABLE;

    public static void init() {
        RAW_MEAT_NUGGET = new FoodProperties(1, 0.1f, false);
        COOKED_MEAT_NUGGET = new FoodProperties(2, 0.2f, false);

        RAW_MEAT = new FoodProperties(4, 0.4f, false);
        COOKED_MEAT = new FoodProperties(8, 0.8f, false);

        RAW_MEAT_BLOCK = new FoodProperties(7, 0.7f, false);
        COOKED_MEAT_BLOCK = new FoodProperties(14, 1.4f, false);

        MEAT_BLOCK_CONSUMABLE = Consumables.defaultFood().consumeSeconds(3.2f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOWNESS, 300, 0), 0.8f)).build();
    }
}
