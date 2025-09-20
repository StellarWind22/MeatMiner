package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class MeatMinerItems {

    private static DeferredRegister<Item> ITEMS;

    //Raw
    //Pure
    public static RegistrySupplier<Item> RAW_MEAT_NUGGET;
    public static RegistrySupplier<Item> RAW_MEAT;
    public static RegistrySupplier<BlockItem> RAW_MEAT_BLOCK;
    //Ore
    public static RegistrySupplier<BlockItem> RAW_MEAT_ORE;
    public static RegistrySupplier<BlockItem> DEEPSLATE_RAW_MEAT_ORE;
    public static RegistrySupplier<BlockItem> NETHERRACK_RAW_MEAT_ORE;
    public static RegistrySupplier<BlockItem> END_STONE_RAW_MEAT_ORE;

    //Cooked
    //Pure
    public static RegistrySupplier<Item> COOKED_MEAT_NUGGET;
    public static RegistrySupplier<Item> COOKED_MEAT;
    public static RegistrySupplier<BlockItem> COOKED_MEAT_BLOCK;
    //Ore
    public static RegistrySupplier<BlockItem> COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> DEEPSLATE_COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> NETHERRACK_COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> END_STONE_COOKED_MEAT_ORE;

    public static void init() {
        ITEMS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.ITEM);

        //Raw
        //Pure
        RAW_MEAT_NUGGET = registerItem("raw_meat_nugget", props -> new Item(props.food(MeatMinerFoods.RAW_MEAT_NUGGET)));
        RAW_MEAT = registerItem("raw_meat", props -> new Item(props.food(MeatMinerFoods.RAW_MEAT)));
        RAW_MEAT_BLOCK = registerItem("raw_meat_block", props -> new BlockItem(MeatMinerBlocks.RAW_MEAT_BLOCK.get(), props.food(MeatMinerFoods.RAW_MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        //Ore
        RAW_MEAT_ORE = registerItem("raw_meat_ore", props -> new BlockItem(MeatMinerBlocks.RAW_MEAT_ORE.get(), props));
        DEEPSLATE_RAW_MEAT_ORE = registerItem("deepslate_raw_meat_ore", props -> new BlockItem(MeatMinerBlocks.DEEPSLATE_RAW_MEAT_ORE.get(), props));
        NETHERRACK_RAW_MEAT_ORE = registerItem("netherrack_raw_meat_ore", props -> new BlockItem(MeatMinerBlocks.NETHERRACK_RAW_MEAT_ORE.get(), props));
        END_STONE_RAW_MEAT_ORE = registerItem("end_stone_raw_meat_ore", props -> new BlockItem(MeatMinerBlocks.END_STONE_RAW_MEAT_ORE.get(), props));

        //Cooked
        //Pure
        COOKED_MEAT_NUGGET = registerItem("cooked_meat_nugget", props -> new Item(props.food(MeatMinerFoods.COOKED_MEAT_NUGGET)));
        COOKED_MEAT = registerItem("cooked_meat", props -> new Item(props.food(MeatMinerFoods.COOKED_MEAT)));
        COOKED_MEAT_BLOCK = registerItem("cooked_meat_block", props -> new BlockItem(MeatMinerBlocks.COOKED_MEAT_BLOCK.get(), props.food(MeatMinerFoods.COOKED_MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        //Ore
        COOKED_MEAT_ORE = registerItem("cooked_meat_ore", props -> new BlockItem(MeatMinerBlocks.COOKED_MEAT_ORE.get(), props));
        DEEPSLATE_COOKED_MEAT_ORE = registerItem("deepslate_cooked_meat_ore", props -> new BlockItem(MeatMinerBlocks.DEEPSLATE_COOKED_MEAT_ORE.get(), props));
        NETHERRACK_COOKED_MEAT_ORE = registerItem("netherrack_cooked_meat_ore", props -> new BlockItem(MeatMinerBlocks.NETHERRACK_COOKED_MEAT_ORE.get(), props));
        END_STONE_COOKED_MEAT_ORE = registerItem("end_stone_cooked_meat_ore", props -> new BlockItem(MeatMinerBlocks.END_STONE_COOKED_MEAT_ORE.get(), props));

        ITEMS.register();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Function<Item.Properties, T> constructor) {
        return ITEMS.register(name, () -> constructor.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, name))).arch$tab(MeatMinerTabs.TAB)));
    }
}
