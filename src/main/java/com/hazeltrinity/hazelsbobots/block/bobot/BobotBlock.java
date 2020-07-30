package com.hazeltrinity.hazelsbobots.block.bobot;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BobotBlock extends Block implements BlockEntityProvider {
    public BobotBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(1.5f).nonOpaque());
        setDefaultState(((BlockState) ((BlockState) this.stateManager.getDefaultState())
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)));
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return VoxelShapes.cuboid(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        PlayerEntity player = ctx.getPlayer();
        Direction facing = ctx.getPlayerFacing();

        if (player != null) {
            if (player.isSneaking()) {
                facing = facing.getOpposite();
            }
        }

        return (BlockState) this.getDefaultState().with(Properties.HORIZONTAL_FACING, facing);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new BobotBlockEntity();
    }
}