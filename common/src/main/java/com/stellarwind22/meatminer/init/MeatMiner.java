package com.stellarwind22.meatminer.init;

import com.stellarwind22.meatminer.content.*;
import com.stellarwind22.meatminer.util.MFluidInteraction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;

import java.util.ArrayList;

public class MeatMiner {

    public static final String MOD_ID = "meatminer";

    public static final ArrayList<MFluidInteraction> fluidInteractions = new ArrayList<>();

    public static void init() {

        //Init order matters!
        MeatMinerTabs.init();
        MeatMinerParticles.init();
        MeatMinerBlocks.init();
        MeatMinerFoods.init();
        MeatMinerItems.init();
    }

    public static void registerFluidInteraction(MFluidInteraction interaction) {
        fluidInteractions.add(interaction);
    }

    public static void invokeFluidInteractions(Level level, BlockPos source, BlockPos target, FluidState fluidState) {
        fluidInteractions.forEach(interaction -> interaction.interact(level, source, target, fluidState));
    }
}
