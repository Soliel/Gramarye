package com.mekelaina.gramarye.blocks.spellblocks.tiles;

import com.mekelaina.gramarye.util.GroundInventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FurnusTile  extends TileEntity implements ITickableTileEntity {
    private final GroundInventory furnusInventory = new GroundInventory();
    private final NonNullList<ItemEntity> createdEntityList = NonNullList.create();

    public FurnusTile() {
        super(SpellTileEntities.FURNUS_TILE.get());
    }

    @Override
    public void tick() {
        List<ItemEntity> itemList = this.findItemEntitiesAroundBlockPos(this.pos, this.world);
        for (ItemEntity item : itemList) {
            if(createdEntityList.contains(item)) continue;

            furnusInventory.setInventorySlotContents(0, item.getItem());
            IRecipe<?> iRecipe = this.world.getRecipeManager().getRecipe(IRecipeType.SMELTING, furnusInventory, this.world).orElse(null);
            if(!this.furnusInventory.isEmpty() && iRecipe != null) {
                this.smeltItem(item, iRecipe);
            }
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(1, 1, 1));
    }

    private List<ItemEntity> findItemEntitiesAroundBlockPos(BlockPos pos, World worldIn) {
        final AxisAlignedBB checkRegion = new AxisAlignedBB(pos.add(-1, -1, -1), pos.add(1, 1, 1));
        return worldIn.getEntitiesWithinAABB(ItemEntity.class, checkRegion);
    }

    private void smeltItem(ItemEntity item, IRecipe recipe) {
        ItemStack resultItem = recipe.getCraftingResult(furnusInventory);
        resultItem.setCount(resultItem.getCount() * item.getItem().getCount());

        ItemEntity newEntity = new ItemEntity(this.world, this.pos.getX(), this.pos.getY() + 0.5, this.pos.getZ(), resultItem);
        this.world.addEntity(newEntity);

        furnusInventory.clear();
        item.remove();
        createdEntityList.add(newEntity);
    }
}
