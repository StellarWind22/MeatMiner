package com.github.stellarwind22.meatminer.object;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MeatPane extends IronBarsBlock implements MeatLike {

    private final boolean drips;
    private final Optional<RegistrySupplier<Block>> cookedVersion;

    public MeatPane(Properties properties, boolean drips, Optional<RegistrySupplier<Block>> cookedVersion) {
        super(properties);
        this.drips = drips;
        this.cookedVersion = cookedVersion;
    }

    public MeatPane(Properties properties, Optional<RegistrySupplier<Block>> cookedVersion) {
        this(properties, false, cookedVersion);
    }

    @SuppressWarnings("unused")
    public MeatPane(Properties properties, boolean drips) {
        this(properties, drips, Optional.empty());
    }

    public MeatPane(Properties properties) {
        this(properties, false, Optional.empty());
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
