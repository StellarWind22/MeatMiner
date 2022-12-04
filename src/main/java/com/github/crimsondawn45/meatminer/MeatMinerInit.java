package com.github.crimsondawn45.meatminer;

import com.github.crimsondawn45.meatminer.content.ModBlocks;

import net.fabricmc.api.ModInitializer;

public class MeatMinerInit implements ModInitializer {

    public static final String MOD_ID = "meatminer";

    @Override
    public void onInitialize() {
        new ModBlocks();
    }
}
