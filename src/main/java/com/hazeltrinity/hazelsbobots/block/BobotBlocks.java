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
    public static BlockEntityType<BobotBlockEntity> BOBOT_BLOCK_ENTITY = BlockEntityType.Builder.create(BobotBlockEntity::new, BOBOT).build(null);
    

    private void register(Block block, String name, BlockItem blockItem, BlockEntityType<?> blockEntity) {
        Identifier id = new Identifier(HazelsBobotsMod.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);

        if (blockItem != null) {
            Registry.register(Registry.ITEM, id, blockItem);
        }

        if (blockEntity != null) {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, id, blockEntity);
        }
    }

    private void register(Block block, String name, Item.Settings settings, BlockEntityType<?> blockEntity) {
        register(block, name, new BlockItem(block, settings), blockEntity);
    }

    /* Add in when needed, annoying warning cba suppressing it
    private void register(Block block, String name, Item.Settings settings) {
        register(block, name, new BlockItem(block, settings), null);
    }
    
    private void register(Block block, String name) {
        register(block, name, (BlockItem)null);
    }
    */

    @Override
    public void initialize() {
        register(BOBOT, "bobot", new Item.Settings().group(HazelsBobotsMod.BOBOTS_GROUP).maxCount(1), BOBOT_BLOCK_ENTITY);
        
    }

    @Override
    public void clientInitialize() {
        BlockRenderLayerMap.INSTANCE.putBlock(BOBOT, RenderLayer.getCutout());
    }

    @Override
    public void serverInitialize() {

    }
}