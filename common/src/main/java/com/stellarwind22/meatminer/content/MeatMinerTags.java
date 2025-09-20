package com.stellarwind22.meatminer.content;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class MeatMinerTags {

    public static TagKey<Block> C_MINEABLE_SWORD;

    public static void init() {
        C_MINEABLE_SWORD = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "mineable/sword"));
    }
}
