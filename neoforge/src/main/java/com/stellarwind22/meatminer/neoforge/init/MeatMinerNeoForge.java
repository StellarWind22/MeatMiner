package com.stellarwind22.meatminer.neoforge.init;

import com.stellarwind22.meatminer.init.MeatMiner;
import net.neoforged.fml.common.Mod;

@Mod(MeatMiner.MOD_ID)
public final class MeatMinerNeoForge {
    public MeatMinerNeoForge() {
        // Run our common setup.
        MeatMiner.init();
    }
}
