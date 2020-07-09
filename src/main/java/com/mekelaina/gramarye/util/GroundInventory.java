package com.mekelaina.gramarye.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class GroundInventory implements IInventory {
    private ItemStack groundedItem = null;

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return groundedItem == null;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return groundedItem;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return groundedItem.split(count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack oldItem = groundedItem.copy();
        groundedItem = null;
        return oldItem;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        groundedItem = stack;
    }

    @Override
    public void markDirty() {
        return;
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return false;
    }

    @Override
    public void clear() {
        groundedItem = null;
    }
}
