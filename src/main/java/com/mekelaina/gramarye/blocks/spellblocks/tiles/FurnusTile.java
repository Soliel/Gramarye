package com.mekelaina.gramarye.blocks.spellblocks.tiles;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class FurnusTile  extends TileEntity implements ITickableTileEntity {
    public FurnusTile() {
        super(SpellTileEntities.FURNUS_TILE.get());
    }

    @Override
    public void tick() {
        
    }
}
