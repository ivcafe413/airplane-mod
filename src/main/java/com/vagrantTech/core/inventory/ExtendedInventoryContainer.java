package com.vagrantTech.core.inventory;

import com.vagrantTech.core.capabilities.ExtendedInventoryCapability;

//import com.vagrantTech.core.capabilities.ExtendedInventoryCapability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
//import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ExtendedInventoryContainer extends Container {
    public ExtendedInventoryContainer(EntityPlayer player) {
        IItemHandler itemHandler = player.getCapability(ExtendedInventoryCapability.EXTENDED_INVENTORY, null);
        int x = 9; //Start 9 over
        int y = 6; //and 6 down

        for(int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotItemHandler(itemHandler, i, x, y));
            x += 18; //Jump 18 to the right each time
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}