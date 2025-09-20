package com.stellarwind22.meatminer.util;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class DeferredItem implements ItemLike {

    public RegistrySupplier<Item> supplier;

    public DeferredItem(RegistrySupplier<Item> supplier) {
        this.supplier = supplier;
    }

    @Override
    public @NotNull Item asItem() {
        return supplier.orElse(Items.AIR);
    }
}
