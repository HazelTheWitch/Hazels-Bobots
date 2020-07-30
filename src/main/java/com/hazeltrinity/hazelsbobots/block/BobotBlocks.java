package com.hazeltrinity.hazelsbobots.block;

import com.hazeltrinity.hazelsbobots.HazelsBobotsMod;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotBlock;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotBlockEntity;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotScreen;
import com.hazeltrinity.hazelsbobots.block.bobot.BobotScreenDescription;
import com.hazeltrinity.hazelsbobots.util.Initialized;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BobotBlocks implements Initialized {
    public static final Block BOBOT = new BobotBlock();
    public static BlockEntityType<BobotBlockEntity> BOBOT_BLOCK_ENTITY = BlockEntityType.Builder.create(BobotBlockEntity::new, BOBOT).build(null);
    // public static ScreenHandlerType<BobotScreenHandler> BOBOT_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
    //     new Identifier(HazelsBobotsMod.MOD_ID, "bobot"),
    //     factory
    // );
    public static ScreenHandlerType<BobotScreenDescription> BOBOT_SCREEN_HANDLER;

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
        BOBOT_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            new Identifier(HazelsBobotsMod.MOD_ID, "bobot"),
                (syncId, inventory) -> new BobotScreenDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    }

    @Override
    public void clientInitialize() {
        BlockRenderLayerMap.INSTANCE.putBlock(BOBOT, RenderLayer.getCutout());
        ScreenRegistry.<BobotScreenDescription, BobotScreen>register(BOBOT_SCREEN_HANDLER, (gui, inventory, title) -> new BobotScreen(gui, inventory.player, title));
    }

    @Override
    public void serverInitialize() {

    }
}