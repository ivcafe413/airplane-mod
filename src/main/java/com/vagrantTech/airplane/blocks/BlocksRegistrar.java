package com.vagrantTech.airplane.blocks;

import com.vagrantTech.core.VagrantTechMod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = VagrantTechMod.MODID)
public class BlocksRegistrar {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        VagrantTechMod.logger.info("Registering Blocks...");
        event.getRegistry().register(new BiggerCraftingBlock());
    }
}