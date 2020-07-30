package com.hazeltrinity.hazelsbobots.block.bobot;

import com.hazeltrinity.hazelsbobots.block.BobotBlocks;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;

public class BobotScreenDescription extends SyncedGuiDescription {
    public static final int INVENTORY_SIZE = 23;

    public BobotScreenDescription(int syncId, PlayerInventory inventory, ScreenHandlerContext ctx) {
        super(BobotBlocks.BOBOT_SCREEN_HANDLER, syncId, inventory, getBlockInventory(ctx, INVENTORY_SIZE), getBlockPropertyDelegate(ctx));

        WGridPanel root = new WGridPanel(9);
        setRootPanel(root);
        root.setSize(0, 0);

        WToggleButton runButton = new WToggleButton(new LiteralText("Run"));
        root.add(runButton, 0, 1);

        WItemSlot programSlot = WItemSlot.of(blockInventory, 0);
        root.add(programSlot, 16, 1);

        WItemSlot upgradeSlots = WItemSlot.of(blockInventory, 1, 2, 2);
        root.add(upgradeSlots, 0, 4);

        WItemSlot inventorySlots = WItemSlot.of(blockInventory, 5, 6, 3);
        root.add(inventorySlots, 6, 4);

        root.add(createPlayerInventoryPanel(), 0, 10);

        root.validate(this);
    }
}