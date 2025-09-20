package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.util.DeferredItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MeatMinerTabs {

    protected static DeferredRegister<CreativeModeTab> TABS;

    public static RegistrySupplier<CreativeModeTab> TAB;

    public static void init() {
        TABS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.CREATIVE_MODE_TAB);

        TAB = registerTab("main", CreativeTabRegistry.create(Component.translatable("tab.meatminer.main"), () -> new ItemStack(new DeferredItem<>(MeatMinerItems.MEAT_ORE))));

        TABS.register();
    }

    private static RegistrySupplier<CreativeModeTab> registerTab(String name, CreativeModeTab tab) {
        return TABS.register(name, () -> tab);
    }
}
