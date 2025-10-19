package com.github.stellarwind22.meatminer.fabric.init;

import com.github.stellarwind22.meatminer.init.MeatMinerClient;
import net.fabricmc.api.ClientModInitializer;

public class MeatMinerClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MeatMinerClient.init();
    }
}
