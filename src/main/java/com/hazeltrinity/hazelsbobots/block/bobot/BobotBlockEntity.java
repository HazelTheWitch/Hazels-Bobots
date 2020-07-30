package com.hazeltrinity.hazelsbobots.block.bobot;

import com.hazeltrinity.hazelsbobots.block.BobotBlocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class BobotBlockEntity extends BlockEntity implements Tickable {
    public BobotBlockEntity() {
        super(BobotBlocks.BOBOT_BLOCK_ENTITY);
    }
    
    @Override
    public void tick() {
        
    }
}