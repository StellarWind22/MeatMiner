package com.stellarwind22.meatminer.neoforge.init;

import com.stellarwind22.meatminer.config.MeatMinerConfig;
import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.init.MeatMinerClient;
import eu.midnightdust.lib.config.MidnightConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;

@Mod(MeatMiner.MOD_ID)
public final class MeatMinerNeoForge {
    public MeatMinerNeoForge() {
        MeatMiner.init();

        if(FMLLoader.getDist() == Dist.CLIENT) {
            MeatMinerClient.init();
        }

        MeatMiner.LOGGER.info("MeatMiner initialized!");
    }

    @EventBusSubscriber
    public static class Events {

        @SubscribeEvent
        public static void setup(FMLCommonSetupEvent event) {
            MidnightConfig.init(MeatMiner.MOD_ID, MeatMinerConfig.class);
        }
    }
}
