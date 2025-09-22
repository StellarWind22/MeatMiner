package com.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
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
        this(properties, true, cookedVersion);
    }

    public MeatBlock(Properties properties, boolean drips) {
        this(properties, drips, Optional.empty());
    }

    public MeatBlock(Properties properties) {
        this(properties, true, Optional.empty());
    }

    public void onPlace(BlockState newState, Level level, BlockPos blockPos, BlockState oldState, boolean bl) {
        super.onPlace(newState, level, blockPos, oldState, bl);
        handleLava(level, blockPos.offset(1,1,1));
    }

    public void handleLava(Level level, BlockPos blockPos) {
        var state = level.getFluidState(blockPos);
        if(state.is(FluidTags.LAVA)) {
            level.scheduleTick(blockPos, state.getType(), state.getType().getTickDelay(level));
        }
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.dripAnimation(level, blockPos, randomSource);
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
}
