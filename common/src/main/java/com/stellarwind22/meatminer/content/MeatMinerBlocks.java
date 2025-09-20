package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.util.MBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Optional;

public class MeatMinerBlocks {

    private static DeferredRegister<Block> BLOCKS;

    //Stone
    public static RegistrySupplier<Block> MEAT_ORE;
    public static RegistrySupplier<Block> COOKED_MEAT_ORE;

    //Deepslate
    public static RegistrySupplier<Block> DEEPSLATE_MEAT_ORE;
    public static RegistrySupplier<Block> DEEPSLATE_COOKED_MEAT_ORE;

    //Netherrack
    public static RegistrySupplier<Block> NETHERRACK_MEAT_ORE;
    public static RegistrySupplier<Block> NETHERRACK_COOKED_MEAT_ORE;

    //End Stone
    public static RegistrySupplier<Block> END_STONE_MEAT_ORE;
    public static RegistrySupplier<Block> END_STONE_COOKED_MEAT_ORE;

    public static RegistrySupplier<Block> MEAT_BLOCK;
    public static RegistrySupplier<Block> COOKED_MEAT_BLOCK;

    public static void init() {
        BLOCKS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.BLOCK);

        MEAT_ORE = registerBlock("meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.STONE)
        ));

        COOKED_MEAT_ORE = registerBlock("cooked_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.STONE)
        ));

        DEEPSLATE_MEAT_ORE = registerBlock("deepslate_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.DEEPSLATE)
        ));

        DEEPSLATE_COOKED_MEAT_ORE = registerBlock("deepslate_cooked_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.DEEPSLATE)
        ));

        NETHERRACK_MEAT_ORE = registerBlock("netherrack_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.NETHERRACK)
        ));

        NETHERRACK_COOKED_MEAT_ORE = registerBlock("netherrack_cooked_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.NETHERRACK)
        ));

        END_STONE_MEAT_ORE = registerBlock("end_stone_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.END_STONE)
        ));

        END_STONE_COOKED_MEAT_ORE = registerBlock("end_stone_cooked_meat_ore", new MBlock(
                Block::new,
                Optional.of(Blocks.END_STONE)
        ));

        MEAT_BLOCK = registerBlock("meat_block", new MBlock(
                Block::new,
                Optional.of(Blocks.MUD)
        ));

        COOKED_MEAT_BLOCK = registerBlock("cooked_meat_block", new MBlock(
                Block::new,
                Optional.of(Blocks.MUD)
        ));

        BLOCKS.register();
    }

    private static RegistrySupplier<Block> registerBlock(String name, MBlock mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, name));
        if(mBlock.copyOf().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.ofFullCopy(mBlock.copyOf().orElseThrow()).setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
