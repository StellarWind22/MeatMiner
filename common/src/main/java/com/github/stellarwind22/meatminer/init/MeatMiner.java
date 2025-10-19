package com.github.stellarwind22.meatminer.init;

import com.github.stellarwind22.meatminer.content.MeatMinerBlocks;
import com.github.stellarwind22.meatminer.content.MeatMinerFoods;
import com.github.stellarwind22.meatminer.content.MeatMinerItems;
import com.github.stellarwind22.meatminer.content.MeatMinerTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeatMiner {

    public static final String MOD_ID = "meatminer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        //Init order matters!
        MeatMinerTabs.init();
        MeatMinerBlocks.init();
        MeatMinerFoods.init();
        MeatMinerItems.init();
    }
}
