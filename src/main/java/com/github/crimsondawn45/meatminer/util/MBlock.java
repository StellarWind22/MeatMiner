package com.github.crimsondawn45.meatminer.util;

import com.github.crimsondawn45.meatminer.MeatMinerInit;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MBlock {

    private String name;
    private Identifier id;
    private Item item;
    private Block block;

    public MBlock(String name, BlockItem item) {
        this.name = name;
        this.item = item;
        this.id = new Identifier(MeatMinerInit.MOD_ID, name);
        this.block = item.getBlock();

        //Register item & block on instantiation
        Registry.register(Registry.ITEM, this.getId(), this.getItem());
        Registry.register(Registry.BLOCK, this.getId(), this.getBlock());
    }

    public MBlock(String name, Block block) {
        this.name = name;
        this.id = new Identifier(MeatMinerInit.MOD_ID, name);
        this.block = block;

        //Register block on instantiation
        Registry.register(Registry.BLOCK, this.getId(), this.getBlock());
    }

    public Block getBlock() {
        return this.block;
    }

    public String getName() {
        return this.name;
    }

    public Identifier getId() {
        return this.id;
    }

    public Item getItem() {
        return this.item;
    }

    public boolean hasItem() {
        return !(this.item == null);
    }
}