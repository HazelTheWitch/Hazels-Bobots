package com.hazeltrinity.hazelsbobots.block.bobot;

import com.hazeltrinity.hazelsbobots.block.BobotBlocks;
import com.hazeltrinity.hazelsbobots.util.HSidedInventory;

import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;

public class BobotBlockEntity extends LootableContainerBlockEntity implements HSidedInventory, Tickable {
    private DefaultedList<ItemStack> items;

    public BobotBlockEntity() {
        super(BobotBlocks.BOBOT_BLOCK_ENTITY);

        items = DefaultedList.ofSize(BobotScreenDescription.INVENTORY_SIZE, ItemStack.EMPTY);
    }

    @Override
    public void tick() {

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return items;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        items = list;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("block.hazelsbobots.bobot");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new BobotScreenDescription(syncId, playerInventory, ScreenHandlerContext.create(world, pos));
    }
}