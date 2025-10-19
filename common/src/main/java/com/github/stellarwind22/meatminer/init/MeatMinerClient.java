package com.github.stellarwind22.meatminer.init;

import com.github.stellarwind22.meatminer.content.MeatMinerBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MeatMinerClient {

    public static void init() {
        RenderTypeRegistry.register(ChunkSectionLayer.TRANSLUCENT, MeatMinerBlocks.MEMBRANE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.TRANSLUCENT, MeatMinerBlocks.COOKED_MEMBRANE.get());
    }
}
