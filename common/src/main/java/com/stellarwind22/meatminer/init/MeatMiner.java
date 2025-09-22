package com.stellarwind22.meatminer.init;

import com.stellarwind22.meatminer.content.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeatMiner {

    public static final String MOD_ID = "meatminer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        //Init order matters!
        MeatMinerTabs.init();
        MeatMinerParticles.init();
        MeatMinerBlocks.init();
        MeatMinerFoods.init();
        MeatMinerItems.init();
    }
}
