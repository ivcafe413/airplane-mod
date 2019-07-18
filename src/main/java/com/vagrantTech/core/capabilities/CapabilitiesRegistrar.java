package com.vagrantTech.core.capabilities;

import java.util.concurrent.Callable;

import com.vagrantTech.core.VagrantTechMod;
import com.vagrantTech.core.inventory.ExtendedInventoryHandler;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.items.ItemStackHandler;

public class CapabilitiesRegistrar {
    public static void register() {
        VagrantTechMod.logger.info("Registering Capability");
        CapabilityManager.INSTANCE.register(ItemStackHandler.class, new IStorage<ItemStackHandler>() {
            @Override
            public NBTBase writeNBT(Capability<ItemStackHandler> capability, ItemStackHandler instance,
                    EnumFacing side) {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<ItemStackHandler> capability, ItemStackHandler instance, EnumFacing side,
                    NBTBase nbt) {
                instance.deserializeNBT((NBTTagCompound) nbt);
            }
        }, new Callable<ItemStackHandler>() {
            @Override
            public ItemStackHandler call() throws Exception {
                return new ExtendedInventoryHandler();
            }
        });
    }
}