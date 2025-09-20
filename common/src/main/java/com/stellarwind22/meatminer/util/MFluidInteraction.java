package com.stellarwind22.meatminer.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;

@FunctionalInterface
public interface MFluidInteraction {
    void interact(Level level, BlockPos source, BlockPos target, FluidState fluidState);
}
