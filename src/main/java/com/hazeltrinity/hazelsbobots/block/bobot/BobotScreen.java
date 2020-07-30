package com.hazeltrinity.hazelsbobots.block.bobot;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class BobotScreen extends CottonInventoryScreen<BobotScreenDescription> {

    public BobotScreen(BobotScreenDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
    
}