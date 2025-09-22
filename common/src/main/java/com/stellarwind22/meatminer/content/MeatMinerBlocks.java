package com.stellarwind22.meatminer.content;

import com.stellarwind22.meatminer.init.MeatMiner;
import com.stellarwind22.meatminer.object.MeatBlock;
import com.stellarwind22.meatminer.object.MeatSlab;
import com.stellarwind22.meatminer.object.MeatStairs;
import com.stellarwind22.meatminer.util.MBlock;
import com.stellarwind22.meatminer.util.MBlockProps;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.Optional;

public class MeatMinerBlocks {

    private static DeferredRegister<Block> BLOCKS;

    //Props
    public static final MBlockProps MEAT_PROPS = new MBlockProps().strength(0.5F).mapColor(MapColor.TERRACOTTA_RED).isValidSpawn(MBlockProps::always).isRedstoneConductor(MBlockProps::always).isViewBlocking(MBlockProps::always).isSuffocating(MBlockProps::always).sound(SoundType.MUD);
    public static final MBlockProps COOKED_MEAT_PROPS = new MBlockProps().strength(0.5F).mapColor(MapColor.TERRACOTTA_CYAN).isValidSpawn(MBlockProps::always).isRedstoneConductor(MBlockProps::always).isViewBlocking(MBlockProps::always).isSuffocating(MBlockProps::always).sound(SoundType.MUD);

    //Raw
    //Pure
    public static RegistrySupplier<Block> MEAT_BLOCK;
    public static RegistrySupplier<Block> MEAT_STAIRS;
    public static RegistrySupplier<Block> MEAT_SLAB;
    //Ores
    public static RegistrySupplier<Block> MEAT_ORE;
    public static RegistrySupplier<Block> DEEPSLATE_MEAT_ORE;
    public static RegistrySupplier<Block> NETHERRACK_MEAT_ORE;
    public static RegistrySupplier<Block> END_STONE_MEAT_ORE;

    //Cooked
    //Pure
    public static RegistrySupplier<Block> COOKED_MEAT_BLOCK;
    public static RegistrySupplier<Block> COOKED_MEAT_STAIRS;
    public static RegistrySupplier<Block> COOKED_MEAT_SLAB;
    //Ores
    public static RegistrySupplier<Block> COOKED_MEAT_ORE;
    public static RegistrySupplier<Block> DEEPSLATE_COOKED_MEAT_ORE;
    public static RegistrySupplier<Block> NETHERRACK_COOKED_MEAT_ORE;
    public static RegistrySupplier<Block> END_STONE_COOKED_MEAT_ORE;

    public static RegistrySupplier<Block> TEST_MUD_STAIRS;

    public static void init() {
        BLOCKS = DeferredRegister.create(MeatMiner.MOD_ID, Registries.BLOCK);

        // temporary debug registration
        TEST_MUD_STAIRS = registerBlock("test_mud_stairs", new MBlock(
                props -> new StairBlock(Blocks.MUD.defaultBlockState(), props),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD))
        ));

        MEAT_BLOCK = registerBlock("meat_block", new MBlock(
                props -> new MeatBlock(props, Optional.of(COOKED_MEAT_BLOCK)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD))
        ));

        MEAT_STAIRS = registerBlock("meat_stairs", new MBlock(
                props -> new MeatStairs(MEAT_BLOCK.get().defaultBlockState(), props, Optional.of(COOKED_MEAT_STAIRS)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD))
        ));

        MEAT_SLAB = registerBlock("meat_slab", new MBlock(
                props -> new MeatSlab(props, Optional.of(COOKED_MEAT_SLAB)),
                Optional.of(MEAT_PROPS.getCopy())
        ));

        MEAT_ORE = registerBlock("meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(COOKED_MEAT_ORE)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
        ));

        DEEPSLATE_MEAT_ORE = registerBlock("deepslate_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(DEEPSLATE_COOKED_MEAT_ORE)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE))
        ));

        NETHERRACK_MEAT_ORE = registerBlock("netherrack_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(NETHERRACK_COOKED_MEAT_ORE)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK))
        ));

        END_STONE_MEAT_ORE = registerBlock("end_stone_meat_ore", new MBlock(
                props -> new MeatBlock(props, false, Optional.of(END_STONE_COOKED_MEAT_ORE)),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE))
        ));

        COOKED_MEAT_BLOCK = registerBlock("cooked_meat_block", new MBlock(
                MeatBlock::new,
                Optional.of(COOKED_MEAT_PROPS.getCopy())
        ));

        COOKED_MEAT_STAIRS = registerBlock("cooked_meat_stairs", new MBlock(
                props -> new MeatStairs(COOKED_MEAT_BLOCK.get().defaultBlockState(), props),
                Optional.of(COOKED_MEAT_PROPS.getCopy())
        ));

        COOKED_MEAT_SLAB = registerBlock("cooked_meat_slab", new MBlock(
                MeatSlab::new,
                Optional.of(COOKED_MEAT_PROPS.getCopy())
        ));

        COOKED_MEAT_ORE = registerBlock("cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
        ));

        DEEPSLATE_COOKED_MEAT_ORE = registerBlock("deepslate_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE))
        ));

        NETHERRACK_COOKED_MEAT_ORE = registerBlock("netherrack_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK))
        ));

        END_STONE_COOKED_MEAT_ORE = registerBlock("end_stone_cooked_meat_ore", new MBlock(
                props -> new MeatBlock(props, false),
                Optional.of(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE))
        ));

        BLOCKS.register();
    }

    private static RegistrySupplier<Block> registerBlock(String name, MBlock mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MeatMiner.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
