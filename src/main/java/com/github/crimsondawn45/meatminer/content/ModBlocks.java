package com.github.crimsondawn45.meatminer.content;

import com.github.crimsondawn45.meatminer.util.MBlock;
import com.github.crimsondawn45.meatminer.util.MContent;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ModBlocks extends MContent {

    public static MBlock meat_ore;

    @Override
    public void registerContent(){
        meat_ore = new MBlock("meat_ore", new BlockItem(new Block(null), null));
    }
}
