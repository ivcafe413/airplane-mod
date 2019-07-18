package com.vagrantTech.airplane.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class BiggerCraftingContainer extends Container {
    public InventoryCrafting craftMatrix;
    public InventoryCraftResult craftResult = new InventoryCraftResult();
    private EntityPlayer player;
    private World world;

    public BiggerCraftingContainer(InventoryPlayer playerInventory, World world) {
        this.craftMatrix = new InventoryCrafting(this, 4, 3);
        this.player = playerInventory.player;
        this.world = world;

        // Loops
        // Slot indicies can be different for different inventories
        // Add Crafting Slots(4x3)
        for (int row = 0; row < 3; row++) {
            //int x = 27;
            for (int col = 0; col < 4; col++) {
                this.addSlotToContainer(new Slot(this.craftMatrix, col + (row * 4), 27 + (col * 18), 6 + (row * 18)));
                //x += 18;
            }
            //y += 18;
        }
        // Add Result Slot
        this.addSlotToContainer(new SlotCrafting(this.player, this.craftMatrix, this.craftResult, 0, 117, 24));

        // Add Player Inventory Slots(9x3)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(playerInventory, col + (row * 9) + 9, 9 + (col * 18), 70 + (row * 18)));
            }
        }

        // Add Player Hotbar Slots(9x1)
        for (int col = 0; col < 9; col++) {
            this.addSlotToContainer(new Slot(playerInventory, col, 9 + (col * 18), 128));
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        //CraftingManager.findMatchingResult(craftMatrix, player.world);
        this.craftResult.setInventorySlotContents(0, CraftingManager.findMatchingResult(this.craftMatrix, this.world));
        //this.slotChangedCraftingGrid(this.world, this.player, this.craftMatrix, this.craftResult);
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if(!this.world.isRemote)
        {
            this.clearContainer(entityPlayer, this.world, this.craftMatrix);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        return ItemStack.EMPTY;
    }
}