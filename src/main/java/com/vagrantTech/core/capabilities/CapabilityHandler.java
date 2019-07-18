package com.vagrantTech.core.capabilities;

import com.vagrantTech.core.VagrantTechMod;
import com.vagrantTech.core.capabilities.ExtendedInventoryCapability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemStackHandler;

@Mod.EventBusSubscriber
public class CapabilityHandler {
    public static final ResourceLocation INVENTORY_CAPABILITY = new ResourceLocation(VagrantTechMod.MODID,
            "extended_inventory");

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer))
            return;
        event.addCapability(INVENTORY_CAPABILITY, new ExtendedInventoryCapability());
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        ItemStackHandler oldInventory = event.getOriginal().getCapability(ExtendedInventoryCapability.EXTENDED_INVENTORY, null);
        ItemStackHandler inventory = player.getCapability(ExtendedInventoryCapability.EXTENDED_INVENTORY, null);

        // IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);
        // IMana oldMana = event.getOriginal().getCapability(ManaProvider.MANA_CAP,
        // null);
        // mana.set(oldMana.getMana());

        for (int i = 0; i < oldInventory.getSlots(); i++) {
            ItemStack stack = oldInventory.getStackInSlot(i);
            inventory.setStackInSlot(i, stack);
        }
    }
}