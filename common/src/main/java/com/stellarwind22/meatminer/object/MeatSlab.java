package com.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MeatSlab extends SlabBlock implements MeatLike {

    private final boolean drips;
    private final Optional<RegistrySupplier<Block>> cookedVersion;

    public MeatSlab(Properties properties, boolean drips, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(properties);
        this.drips = drips;
        this.cookedVersion = cookedVersion;
    }

    public MeatSlab(Properties properties, Optional<RegistrySupplier<Block>> cookedVersion) {
        this(properties,true, cookedVersion);
    }

    public MeatSlab(Properties properties, boolean drips) {
        this(properties, drips,Optional.empty());
    }

    public MeatSlab(Properties properties) {
        this(properties,true, Optional.empty());
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.dripAnimation(level, blockPos, randomSource);
    }

    @Override
    public boolean drips() {
        return this.drips;
    }

    @Override
    public boolean isRaw() {
        return this.cookedVersion.isPresent();
    }

    @Override
    public Optional<RegistrySupplier<Block>> cookedVersion() {
        return this.cookedVersion;
    }
}
