package com.github.stellarwind22.meatminer.fabric.init;

import com.github.stellarwind22.meatminer.config.MeatMinerConfig;
import com.github.stellarwind22.meatminer.init.MeatMiner;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class MeatMinerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MeatMiner.init();

        MidnightConfig.init(MeatMiner.MOD_ID, MeatMinerConfig.class);
        BiomeModifications.addFeature(
                BiomeSelectors.all(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE,
                        ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID,
                                "ore_meat"
                        ))
                );

        MeatMiner.LOGGER.info("MeatMiner initialized!");
    }
}
