package com.vagrantTech.core;

import com.vagrantTech.airplane.entities.ModEntities;
import com.vagrantTech.airplane.gui.BiggerCraftingGuiHandler;
import com.vagrantTech.core.capabilities.CapabilitiesRegistrar;
import com.vagrantTech.core.gui.ExtendedInventoryGuiHandler;
import com.vagrantTech.core.proxy.IProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = VagrantTechMod.MODID, name = VagrantTechMod.NAME, version = VagrantTechMod.VERSION)
public class VagrantTechMod {
    public static final String MODID = "vagranttechmod";
    public static final String NAME = "VagrantTech Mod";
    public static final String VERSION = "1.0";

    public static final String SERVER_PROXY = "com.vagrantTech.core.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "com.vagrantTech.core.proxy.ClientProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static IProxy proxy;

    public static final Logger logger = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModEntities.register();
        CapabilitiesRegistrar.register();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ExtendedInventoryGuiHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new BiggerCraftingGuiHandler());

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Instance
    public static VagrantTechMod instance;
}
