package com.github.crimsondawn45.meatminer.util;

import com.github.crimsondawn45.meatminer.MeatMinerInit;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MItem {

    private String name;
    private Identifier id;
    private Item item;

    public MItem(String name, Item item) {
        this.name = name;
        this.item = item;
        this.id = new Identifier(MeatMinerInit.MOD_ID, name);

        //Register item on instantiation
        Registry.register(Registry.ITEM, this.getId(), this.getItem());
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
}