package com.github.crimsondawn45.meatminer.util;

import java.util.Arrays;
import java.util.function.Predicate;

import com.github.crimsondawn45.meatminer.MeatMinerInit;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.structure.rule.RuleTest;
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
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class MOreGenerator {

    private static ConfiguredFeature<? extends Feature<FeatureConfig>, ? extends FeatureConfig> ORE_CONFIGURED_FEATURE;
    public static PlacedFeature ORE_PLACED_FEATURE;

    public MOreGenerator(String name, MBlock ore, Predicate<BiomeSelectionContext> biomeSelector, RuleTest placementRules, int veinsPerChunk, int veinSize, YOffset min, YOffset max) {

        ORE_CONFIGURED_FEATURE = new ConfiguredFeature(
            Feature.ORE,
            new OreFeatureConfig(
                placementRules,
                ore.getBlock().getDefaultState(),  // ore
                veinSize)); // vein size

        ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                CountPlacementModifier.of(veinsPerChunk), // number of veins per chunk
                SquarePlacementModifier.of(), // spreading horizontally
                HeightRangePlacementModifier.uniform(min, max)
            )); // height

        //Register features
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MeatMinerInit.MOD_ID, name + "_" + ore.getName()), ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MeatMinerInit.MOD_ID, name + "_" + ore.getName()), ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MeatMinerInit.MOD_ID, name + "_" + ore.getName())));
    }
}
