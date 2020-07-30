package com.hazeltrinity.hazelsbobots;

import com.hazeltrinity.hazelsbobots.util.Initialized;

import org.apache.logging.log4j.Level;

import net.fabricmc.api.DedicatedServerModInitializer;

public class HazelsBobotsServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        HazelsBobotsMod.log(Level.INFO, "Server initialization began.");

        for (Initialized initialized : HazelsBobotsMod.INITIALIZED) {
            initialized.serverInitialize();
        }

        HazelsBobotsMod.log(Level.INFO, "Server initialization ended.");
    }
    
}