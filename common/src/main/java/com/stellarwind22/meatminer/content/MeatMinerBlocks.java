package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.object.MeatBlock;
import com.stellarwind22.meatminer.object.MeatLike;
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

    //Pure
    public static RegistrySupplier<Block> MEAT_BLOCK;
    public static RegistrySupplier<Block> COOKED_MEAT_BLOCK;

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

    public static void init() {
        BLOCKS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.BLOCK);

        MEAT_BLOCK = registerBlock("meat_block", new MBlock(
                props -> new MeatBlock(props, Optional.of(COOKED_MEAT_BLOCK)),
                Optional.of(Blocks.MUD)
        ));

        COOKED_MEAT_BLOCK = registerBlock("cooked_meat_block", new MBlock(
                MeatBlock::new,
                Optional.of(Blocks.MUD)
        ));

        MEAT_ORE = registerBlock("meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(COOKED_MEAT_ORE)),
                Optional.of(Blocks.STONE)
        ));

        COOKED_MEAT_ORE = registerBlock("cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(Blocks.STONE)
        ));

        DEEPSLATE_MEAT_ORE = registerBlock("deepslate_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(DEEPSLATE_COOKED_MEAT_ORE)),
                Optional.of(Blocks.DEEPSLATE)
        ));

        DEEPSLATE_COOKED_MEAT_ORE = registerBlock("deepslate_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(Blocks.DEEPSLATE)
        ));

        NETHERRACK_MEAT_ORE = registerBlock("netherrack_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(NETHERRACK_COOKED_MEAT_ORE)),
                Optional.of(Blocks.NETHERRACK)
        ));

        NETHERRACK_COOKED_MEAT_ORE = registerBlock("netherrack_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(Blocks.NETHERRACK)
        ));

        END_STONE_MEAT_ORE = registerBlock("end_stone_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(END_STONE_COOKED_MEAT_ORE)),
                Optional.of(Blocks.END_STONE)
        ));

        END_STONE_COOKED_MEAT_ORE = registerBlock("end_stone_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(Blocks.END_STONE)
        ));

        MeatMiner.registerFluidInteraction(((level, source, target, fluidState) -> {
            if(level.getBlockState(source).getBlock().equals(Blocks.LAVA)) {
                if(level.getBlockState(target).getBlock() instanceof MeatLike meatLike) {
                    if(meatLike.isRaw()) {
                        meatLike.cookedVersion().ifPresent(cVersion -> level.setBlockAndUpdate(target, cVersion.get().defaultBlockState()));
                    }
                }
            }
        }));

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
