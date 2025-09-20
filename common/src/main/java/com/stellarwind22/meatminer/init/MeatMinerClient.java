package com.stellarwind22.meatminer.init;

import com.stellarwind22.meatminer.content.MeatMinerParticles;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import net.minecraft.client.particle.WaterDropParticle;

public class MeatMinerClient {

    public static void init() {
        ParticleProviderRegistry.register(MeatMinerParticles.DRIPPING_MEAT_JUICE, WaterDropParticle.Provider::new);
        ParticleProviderRegistry.register(MeatMinerParticles.DRIPPING_COOKED_MEAT_JUICE, WaterDropParticle.Provider::new);
    }
}
