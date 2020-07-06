package com.mekelaina.gramarye.blocks.spellblocks;

import com.mekelaina.gramarye.Gramarye;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpellBlocks {
    public static final DeferredRegister<Block> SPELL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gramarye.MODID);

    public static final RegistryObject<Block> FURNUS = SPELL_BLOCKS.register("spell_furnus", FurnusBlock::new);
}
