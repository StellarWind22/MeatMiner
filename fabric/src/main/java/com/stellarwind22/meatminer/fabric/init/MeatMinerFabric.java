package com.stellarwind22.meatminer.fabric.init;

import com.stellarwind22.meatminer.init.MeatMiner;
import net.fabricmc.api.ModInitializer;

public final class MeatMinerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MeatMiner.init();
    }
}
