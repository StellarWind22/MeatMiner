package com.github.crimsondawn45.meatminer.content;

import com.github.crimsondawn45.meatminer.util.MContent;
import com.github.crimsondawn45.meatminer.util.MOreGenerator;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.YOffset;

public class ModGeneration extends MContent {

    MOreGenerator overworldMeatOre;
     
    @Override
    public void registerContent(){
        overworldMeatOre = new MOreGenerator(ModBlocks.meat_ore, BiomeSelectors.foundInOverworld(), 10, 8, YOffset.BOTTOM, YOffset.TOP);
    }
}
