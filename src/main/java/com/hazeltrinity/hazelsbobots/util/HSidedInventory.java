package com.hazeltrinity.hazelsbobots.util;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;

public interface HSidedInventory extends SidedInventory {
    DefaultedList<ItemStack> getItems();

    /**
     * Gets the total item slots.
     * 
     * Default behaviour is length of getItems().
     * 
     * @return number of item slots
     */
    default int getSize() {
        return getItems().size();
    }

    default int size() {
        return getSize();
    }

    // Sided Inventory Overrides
    
    /**
     * Gets the available slots to automation on a given side.
     * 
     * Gives all items by default.
     * 
     * @param side the side to check
     * @return abailable slots
     */
    @Override
    default int[] getAvailableSlots(Direction side) {
        int[] result = new int[getSize()];
        for (int i = 0; i < result.length; i ++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * Returns true if you can insert a stack into the inventory.
     * 
     * Default returns true
     * 
     * @param slot the slot to insert into
     * @param stack the slot to insert
     * @param side the side to insert into
     * @return if you can insert into the slot
     */
    @Override
    default boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return true;
    }

    /**
     * Returns true if the stack can be extracted from the slot on the given side.
     * 
     * Default returns true.
     * 
     * @param slot  the slot to extract from
     * @param stack the slot to extract
     * @param side  the side to extract out of
     * @return if you can extract from the slot
     */
    @Override
    default boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }
    
    @Override
    default boolean isEmpty() {
        for (ItemStack stack : getItems()) {
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    default ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    @Override
    default ItemStack removeStack(int slot, int count) {
        ItemStack result = getStack(slot);

        if (!result.isEmpty()) {
            markDirty();
        }

        return result;
    }

    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    default void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
        if(stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }

    // Clearable

    @Override
    default void clear() {
        getItems().clear();
    }

    /**
     * Overried if you want behavior
     */
    @Override
    default void markDirty() { }

    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}