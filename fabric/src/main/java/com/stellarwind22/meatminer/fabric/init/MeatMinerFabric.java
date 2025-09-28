package com.stellarwind22.meatminer.fabric.init;

import com.stellarwind22.meatminer.config.MeatMinerConfig;
import com.stellarwind22.meatminer.init.MeatMiner;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

public final class MeatMinerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MeatMiner.init();

        MidnightConfig.init(MeatMiner.MOD_ID, MeatMinerConfig.class);

        MeatMiner.LOGGER.info("MeatMiner initialized!");
    }
}
