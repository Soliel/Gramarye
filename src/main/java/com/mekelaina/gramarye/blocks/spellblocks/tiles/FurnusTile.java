package com.mekelaina.gramarye.blocks.spellblocks.tiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FurnusTile  extends TileEntity implements ITickableTileEntity {
    public FurnusTile() {
        super(SpellTileEntities.FURNUS_TILE.get());
    }

    @Override
    public void tick() {

    }

    private List<ItemEntity> findItemEntitiesAroundBlockPos(BlockPos pos, World worldIn) {
        final AxisAlignedBB checkRegion = new AxisAlignedBB(pos.add(-1, -1, -1), pos.add(1, 1, 1));
        return worldIn.getEntitiesWithinAABB(ItemEntity.class, checkRegion);
    }
}
