package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.object.MSimpleParticleType;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class MeatMinerParticles {

    private static DeferredRegister<ParticleType<?>> PARTICLES;

    public static RegistrySupplier<ParticleType<SimpleParticleType>> DRIPPING_MEAT_JUICE;
    public static RegistrySupplier<ParticleType<SimpleParticleType>> DRIPPING_COOKED_MEAT_JUICE;

    public static void init() {
        PARTICLES = DeferredRegister.create(MeatMiner.MOD_ID, Registries.PARTICLE_TYPE);

        DRIPPING_MEAT_JUICE = registerParticle("dripping_meat_juice", new MSimpleParticleType(false));
        DRIPPING_COOKED_MEAT_JUICE = registerParticle("dripping_cooked_meat_juice", new MSimpleParticleType(false));

        PARTICLES.register();
    }

    private static <T extends ParticleOptions> RegistrySupplier<ParticleType<T>> registerParticle(String name, ParticleType<T> particleType) {
        return PARTICLES.register(name, () -> particleType);
    }
}
