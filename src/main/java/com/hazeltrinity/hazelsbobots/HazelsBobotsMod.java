package com.hazeltrinity.hazelsbobots;

import com.hazeltrinity.hazelsbobots.block.BobotBlocks;
import com.hazeltrinity.hazelsbobots.util.Initialized;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class HazelsBobotsMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();
    public static Level LOG_LEVEL = Level.INFO;

    public static final String MOD_ID = "hazelsbobots";
    public static final String MOD_NAME = "HazelsBobots";

    public static final BobotBlocks BLOCKS = new BobotBlocks();

    public static final Initialized[] INITIALIZED = new Initialized[] {
        BLOCKS
    };

    public static final ItemGroup BOBOTS_GROUP = FabricItemGroupBuilder.create(
        new Identifier(MOD_ID, "bobots"))
        .icon(() -> new ItemStack(BobotBlocks.BOBOT))
        .build();
        
    public static Identifier newId(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        log(Level.INFO, "Main initialization began.");

        for (Initialized initialized : INITIALIZED) {
            initialized.initialize();
        }

        log(Level.INFO, "Main initialization ended.");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    public static void log(String message) {
        log(LOG_LEVEL, message);
    }

}