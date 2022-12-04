package com.github.crimsondawn45.meatminer.content;

import java.util.Arrays;

import com.github.crimsondawn45.meatminer.MeatMinerInit;
import com.github.crimsondawn45.meatminer.util.MContent;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModGeneration extends MContent {

    private static ConfiguredFeature<? extends Feature<FeatureConfig>, ? extends FeatureConfig> OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature(
        Feature.ORE,
        new OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            ModBlocks.meat_ore.getBlock().getDefaultState(),
            4)); // vein size

    public static PlacedFeature OVERWORLD_MEAT_ORE_PLACED_FEATURE;
     
    @Override
    public void registerContent(){

        OVERWORLD_MEAT_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                CountPlacementModifier.of(20), // number of veins per chunk
                SquarePlacementModifier.of(), // spreading horizontally
                HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            )); // height

        //Register features
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MeatMinerInit.MOD_ID, "overworld_meat_ore"), OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MeatMinerInit.MOD_ID, "overworld_meat_ore"), OVERWORLD_MEAT_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MeatMinerInit.MOD_ID, "overworld_meat_ore")));
    }
}
