package com.vagrantTech.core.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.ItemStackHandler;

public class ExtendedInventoryCapability implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(ItemStackHandler.class)
    public static Capability<ItemStackHandler> EXTENDED_INVENTORY = null;

    // Secondary Inventory
    private ItemStackHandler secondaryInventory = EXTENDED_INVENTORY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return (capability == EXTENDED_INVENTORY);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == EXTENDED_INVENTORY ? EXTENDED_INVENTORY.<T>cast(this.secondaryInventory) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        //return (this.writeToNBT(nbtinventory)).getCompoundTagAt(0);
        return EXTENDED_INVENTORY.getStorage().writeNBT(EXTENDED_INVENTORY, this.secondaryInventory, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        // nbtinventory = new NBTTagList();
        // nbtinventory.appendTag(nbt);
        // this.readFromNBT(nbtinventory);
        EXTENDED_INVENTORY.getStorage().readNBT(EXTENDED_INVENTORY, this.secondaryInventory, null, nbt);
    }
}