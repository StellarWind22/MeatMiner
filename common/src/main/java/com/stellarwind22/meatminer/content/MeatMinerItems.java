package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.function.Function;

public class MeatMinerItems {

    private static DeferredRegister<Item> ITEMS;

    public static ResourceKey<TrimMaterial> MEAT_TRIM;
    public static ResourceKey<TrimMaterial> COOKED_MEAT_TRIM;

    //Raw
    //Pure
    public static RegistrySupplier<Item> MEAT_NUGGET;
    public static RegistrySupplier<Item> MEAT;
    public static RegistrySupplier<BlockItem> MEAT_BLOCK;
    public static RegistrySupplier<BlockItem> MEAT_STAIRS;
    public static RegistrySupplier<BlockItem> MEAT_SLAB;
    //Ore
    public static RegistrySupplier<BlockItem> MEAT_ORE;
    public static RegistrySupplier<BlockItem> DEEPSLATE_MEAT_ORE;
    public static RegistrySupplier<BlockItem> NETHERRACK_MEAT_ORE;
    public static RegistrySupplier<BlockItem> END_STONE_MEAT_ORE;

    //Cooked
    //Pure
    public static RegistrySupplier<Item> COOKED_MEAT_NUGGET;
    public static RegistrySupplier<Item> COOKED_MEAT;
    public static RegistrySupplier<BlockItem> COOKED_MEAT_BLOCK;
    public static RegistrySupplier<BlockItem> COOKED_MEAT_STAIRS;
    public static RegistrySupplier<BlockItem> COOKED_MEAT_SLAB;
    //Ore
    public static RegistrySupplier<BlockItem> COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> DEEPSLATE_COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> NETHERRACK_COOKED_MEAT_ORE;
    public static RegistrySupplier<BlockItem> END_STONE_COOKED_MEAT_ORE;

    public static void init() {
        ITEMS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.ITEM);

        MEAT_TRIM = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, "meat"));
        COOKED_MEAT_TRIM = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, "cooked_meat"));

        //Raw
        //Pure
        MEAT_NUGGET = registerItem("meat_nugget", props -> new Item(props.food(MeatMinerFoods.MEAT_NUGGET, MeatMinerFoods.MEAT_NUGGET_CONSUMABLE).trimMaterial(MEAT_TRIM)));
        MEAT = registerItem("meat", props -> new Item(props.food(MeatMinerFoods.MEAT).trimMaterial(MEAT_TRIM)));
        MEAT_BLOCK = registerItem("meat_block", props -> new BlockItem(MeatMinerBlocks.MEAT_BLOCK.get(), props.food(MeatMinerFoods.MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        MEAT_STAIRS = registerItem("meat_stairs", props -> new BlockItem(MeatMinerBlocks.MEAT_STAIRS.get(), props.food(MeatMinerFoods.MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        MEAT_SLAB = registerItem("meat_slab", props -> new BlockItem(MeatMinerBlocks.MEAT_SLAB.get(), props.food(MeatMinerFoods.MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        //Ore
        MEAT_ORE = registerItem("meat_ore", props -> new BlockItem(MeatMinerBlocks.MEAT_ORE.get(), props));
        DEEPSLATE_MEAT_ORE = registerItem("deepslate_meat_ore", props -> new BlockItem(MeatMinerBlocks.DEEPSLATE_MEAT_ORE.get(), props));
        NETHERRACK_MEAT_ORE = registerItem("netherrack_meat_ore", props -> new BlockItem(MeatMinerBlocks.NETHERRACK_MEAT_ORE.get(), props));
        END_STONE_MEAT_ORE = registerItem("end_stone_meat_ore", props -> new BlockItem(MeatMinerBlocks.END_STONE_MEAT_ORE.get(), props));

        //Cooked
        //Pure
        COOKED_MEAT_NUGGET = registerItem("cooked_meat_nugget", props -> new Item(props.food(MeatMinerFoods.COOKED_MEAT_NUGGET, MeatMinerFoods.MEAT_NUGGET_CONSUMABLE).trimMaterial(COOKED_MEAT_TRIM)));
        COOKED_MEAT = registerItem("cooked_meat", props -> new Item(props.food(MeatMinerFoods.COOKED_MEAT).trimMaterial(COOKED_MEAT_TRIM)));
        COOKED_MEAT_BLOCK = registerItem("cooked_meat_block", props -> new BlockItem(MeatMinerBlocks.COOKED_MEAT_BLOCK.get(), props.food(MeatMinerFoods.COOKED_MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        COOKED_MEAT_STAIRS = registerItem("cooked_meat_stairs", props -> new BlockItem(MeatMinerBlocks.COOKED_MEAT_STAIRS.get(), props.food(MeatMinerFoods.COOKED_MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
        COOKED_MEAT_SLAB = registerItem("cooked_meat_slab", props -> new BlockItem(MeatMinerBlocks.COOKED_MEAT_SLAB.get(), props.food(MeatMinerFoods.COOKED_MEAT_BLOCK, MeatMinerFoods.MEAT_BLOCK_CONSUMABLE)));
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
