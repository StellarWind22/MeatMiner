package com.github.crimsondawn45.meatminer;

import com.github.crimsondawn45.meatminer.content.ModBlocks;
import com.github.crimsondawn45.meatminer.content.ModGeneration;

import net.fabricmc.api.ModInitializer;

public class MeatMinerInit implements ModInitializer {

    public static final String MOD_ID = "meatminer";

    @Override
    public void onInitialize() {
        new ModBlocks();
        new ModGeneration();
    }
}
