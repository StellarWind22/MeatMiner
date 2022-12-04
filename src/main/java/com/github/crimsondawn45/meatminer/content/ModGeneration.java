package com.github.crimsondawn45.meatminer.content;

import com.github.crimsondawn45.meatminer.util.MContent;
import com.github.crimsondawn45.meatminer.util.MOreGenerator;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;

public class ModGeneration extends MContent {

    RuleTest endPlacement;

    MOreGenerator overworldMeatOre;
    MOreGenerator netherMeatOre;
    MOreGenerator endMeatOre;
     
    @Override
    public void registerContent(){

        endPlacement = new BlockMatchRuleTest(Blocks.END_STONE);

        overworldMeatOre =  new MOreGenerator("overworld",  ModBlocks.meat_ore,           BiomeSelectors.foundInOverworld(), OreConfiguredFeatures.STONE_ORE_REPLACEABLES, 10, 8, YOffset.BOTTOM, YOffset.TOP);
        netherMeatOre =     new MOreGenerator("nether",     ModBlocks.nether_meat_ore,    BiomeSelectors.foundInTheNether(), OreConfiguredFeatures.BASE_STONE_NETHER,      10, 8, YOffset.BOTTOM, YOffset.TOP);
        endMeatOre =        new MOreGenerator("end",        ModBlocks.end_meat_ore,       BiomeSelectors.foundInTheEnd(),    endPlacement,                                 10, 8, YOffset.BOTTOM, YOffset.TOP);
    }
}
