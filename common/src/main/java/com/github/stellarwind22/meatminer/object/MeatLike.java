package com.github.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public interface MeatLike {

    boolean drips();

    boolean isRaw();

    Optional<RegistrySupplier<Block>> cookedVersion();

    default void dripAnimation(Level level, BlockPos blockPos, RandomSource randomSource) {
        if(this.drips()) {

            if (randomSource.nextInt(16) == 0) {
                BlockPos blockPos2 = blockPos.below();
                if(isFree(level.getBlockState(blockPos2))) {
                    //ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, );
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    static boolean isFree(BlockState blockState) {
        return blockState.isAir() || blockState.is(BlockTags.FIRE) || blockState.liquid() || blockState.canBeReplaced();
    }
}
