package com.stellarwind22.meatminer.init;

import com.stellarwind22.meatminer.content.MeatMinerBlocks;
import com.stellarwind22.meatminer.content.MeatMinerParticles;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.particle.WaterDropParticle;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MeatMinerClient {

    public static void init() {
        ParticleProviderRegistry.register(MeatMinerParticles.DRIPPING_MEAT_JUICE, WaterDropParticle.Provider::new);
        ParticleProviderRegistry.register(MeatMinerParticles.DRIPPING_COOKED_MEAT_JUICE, WaterDropParticle.Provider::new);
        RenderTypeRegistry.register(ChunkSectionLayer.TRANSLUCENT, MeatMinerBlocks.MEMBRANE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.TRANSLUCENT, MeatMinerBlocks.COOKED_MEMBRANE.get());
    }
}
