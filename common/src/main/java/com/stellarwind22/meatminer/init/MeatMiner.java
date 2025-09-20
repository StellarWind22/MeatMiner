package com.stellarwind22.meatminer.init;

import com.stellarwind22.meatminer.content.*;

public class MeatMiner {

    public static final String MOD_ID = "meatminer";

    public static void init() {

        //Init order matters!
        MeatMinerTabs.init();
        MeatMinerBlocks.init();
        MeatMinerFoods.init();
        MeatMinerTags.init();
        MeatMinerItems.init();
    }
}
