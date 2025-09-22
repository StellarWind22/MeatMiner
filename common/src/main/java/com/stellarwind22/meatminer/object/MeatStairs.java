package com.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MeatStairs extends StairBlock implements SimpleWaterloggedBlock, MeatLike {

    private final boolean drips;
    private final Optional<RegistrySupplier<Block>> cookedVersion;

    public MeatStairs(BlockState blockState, BlockBehaviour.Properties properties, boolean drips, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(blockState, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM).setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, false));
        this.drips = drips;
        this.cookedVersion = cookedVersion;
    }

    public MeatStairs(BlockState blockState, BlockBehaviour.Properties properties, Optional<RegistrySupplier<Block>> cookedVersion) {
        this(blockState, properties, true, cookedVersion);
    }

    public MeatStairs(BlockState blockState, boolean drips, BlockBehaviour.Properties properties) {
        this(blockState, properties, drips, Optional.empty());
    }

    public MeatStairs(BlockState blockState, BlockBehaviour.Properties properties) {
        this(blockState, properties, true, Optional.empty());
    }

    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource randomSource) {
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
