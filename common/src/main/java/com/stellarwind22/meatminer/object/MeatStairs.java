package com.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MeatStairs extends StairBlock implements MeatLike {

    private final boolean drips;
    private final Optional<RegistrySupplier<Block>> cookedVersion;

    public MeatStairs(BlockState blockState, Properties properties, boolean drips, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(blockState, properties);
        this.drips = drips;
        this.cookedVersion = cookedVersion;
    }

    public MeatStairs(BlockState blockState, Properties properties, Optional<RegistrySupplier<Block>> cookedVersion) {
        this(blockState, properties, true, cookedVersion);
    }

    public MeatStairs(BlockState blockState, boolean drips, Properties properties) {
        this(blockState, properties, drips, Optional.empty());
    }

    public MeatStairs(BlockState blockState, Properties properties) {
        this(blockState, properties, true, Optional.empty());
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
