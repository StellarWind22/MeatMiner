package com.github.crimsondawn45.meatminer.content;

import com.github.crimsondawn45.meatminer.util.MBlock;
import com.github.crimsondawn45.meatminer.util.MContent;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ModBlocks extends MContent {

    public static MBlock meat_ore;

    @Override
    public void registerContent(){
        meat_ore = new MBlock("meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.STONE)), new Item.Settings()));
    }
}
