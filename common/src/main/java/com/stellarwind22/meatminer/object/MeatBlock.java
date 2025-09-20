package com.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MeatBlock extends Block implements MeatLike {

    private final boolean drips;
    private final Optional<RegistrySupplier<Block>> cookedVersion;

    public MeatBlock(Properties properties, boolean drips, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(properties);
        this.drips = drips;
        this.cookedVersion = cookedVersion;
    }

    public MeatBlock(Properties properties, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(properties);
        this.drips = true;
        this.cookedVersion = cookedVersion;
    }

    public MeatBlock(Properties properties, boolean drips) {
        super(properties);
        this.drips = drips;
        this.cookedVersion = Optional.empty();
    }

    public MeatBlock(Properties properties) {
        super(properties);
        this.drips = true;
        this.cookedVersion = Optional.empty();
    }

    public boolean drips() {
        return this.drips;
    }

    public boolean isRaw() {
        return this.cookedVersion.isPresent();
    }

    public Optional<RegistrySupplier<Block>> cookedVersion() {
        return this.cookedVersion;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.dripAnimation(blockState, level, blockPos, randomSource);
    }
}
