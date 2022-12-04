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
    public static MBlock nether_meat_ore;
    public static MBlock end_meat_ore;

    public static MBlock raw_meat_block;

    @Override
    public void registerContent(){
        meat_ore = new MBlock("meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.STONE)), new Item.Settings()));
        nether_meat_ore = new MBlock("nether_meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.STONE)), new Item.Settings()));
        end_meat_ore = new MBlock("end_meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.STONE)), new Item.Settings()));
    }
}
