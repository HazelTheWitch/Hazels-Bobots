package com.hazeltrinity.hazelsbobots.block;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;

public class BlockGroup {
    public BlockGroup(String name, Block block, Item.Settings settings, Function<BlockEntityType<?>,BlockEntity> initializer) {
        
    }
}