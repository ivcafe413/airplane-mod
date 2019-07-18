package com.vagrantTech.airplane.items;

import com.vagrantTech.core.VagrantTechMod;
import com.vagrantTech.airplane.blocks.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = VagrantTechMod.MODID)
public class ItemsRegistrar {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new CylinderItem());
        event.getRegistry().register(new ItemBlock(ModBlocks.biggerCraftingBlock)
            .setRegistryName(ModBlocks.biggerCraftingBlock.getRegistryName()));
    }
}