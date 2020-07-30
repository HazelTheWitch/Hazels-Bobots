package com.hazeltrinity.hazelsbobots;

import com.hazeltrinity.hazelsbobots.util.Initialized;

import org.apache.logging.log4j.Level;

import net.fabricmc.api.ClientModInitializer;

public class HazelsBobotsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HazelsBobotsMod.log(Level.INFO, "Client initialization began.");

        for (Initialized initialized : HazelsBobotsMod.INITIALIZED) {
            initialized.clientInitialize();
        };

        HazelsBobotsMod.log(Level.INFO, "Client initialization ended.");
    }
    
}