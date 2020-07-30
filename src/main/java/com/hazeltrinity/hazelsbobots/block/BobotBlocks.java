package com.hazeltrinity.hazelsbobots.block;

import com.hazeltrinity.hazelsbobots.HazelsBobotsMod;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotBlock;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotBlockEntity;
import com.hazeltrinity.hazelsbobots.util.Initialized;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BobotBlocks implements Initialized {
    public static final Block BOBOT = new BobotBlock();
    public static BlockEntityType<BobotBlockEntity> BOBOT_BLOCK_ENTITY;

    private void register(Block block, String name, BlockItem blockItem) {
        Registry.register(Registry.BLOCK, new Identifier(HazelsBobotsMod.MOD_ID, name), block);

        if (blockItem != null) {
            Registry.register(Registry.ITEM, new Identifier(HazelsBobotsMod.MOD_ID, name), blockItem);
        }
    }

    private void register(Block block, String name, Item.Settings settings) {
        register(block, name, new BlockItem(block, settings));
    }

    /* Add in when needed, annoying warning cba suppressing it
    private void register(Block block, String name) {
        register(block, name, (BlockItem)null);
    }
    */

    @Override
    public void initialize() {
        register(BOBOT, "bobot", new Item.Settings().group(HazelsBobotsMod.BOBOTS_GROUP).maxCount(1));
        
    }

    @Override
    public void clientInitialize() {
        BlockRenderLayerMap.INSTANCE.putBlock(BOBOT, RenderLayer.getCutout());
    }

    @Override
    public void serverInitialize() {

    }
}