package com.stellarwind22.meatminer.object;

import com.stellarwind22.meatminer.init.MeatMiner;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

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
    public void onPlace(BlockState newState, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(newState, level, pos, oldState, isMoving);
        if (!level.isClientSide()) {
            var collisionShape = newState.getCollisionShape(level, pos, CollisionContext.empty());
            var outlineShape = newState.getShape(level, pos, CollisionContext.empty());
            MeatMiner.LOGGER.info("[meat] placed {} at {} state={} collisionEmpty={} outlineEmpty={}",
                    this.getClass().getSimpleName(),
                    pos,
                    newState,
                    collisionShape.isEmpty(),
                    outlineShape.isEmpty()
            );
            MeatMiner.LOGGER.info("[meat] collision: {}", collisionShape);
            MeatMiner.LOGGER.info("[meat] outline: {}", outlineShape);
        }
    }


    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.dripAnimation(blockState, level, blockPos, randomSource);
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
