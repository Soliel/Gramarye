package com.mekelaina.gramarye.blocks.spellblocks;

import com.mekelaina.gramarye.blocks.spellblocks.tiles.FurnusTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class FurnusBlock extends Block {
    public FurnusBlock() {
        super(Properties
                .create(Material.AIR)
                .notSolid()
                .noDrops()
        );
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FurnusTile();
    }
}
