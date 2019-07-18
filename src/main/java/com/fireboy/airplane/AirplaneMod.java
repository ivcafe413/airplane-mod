package com.fireboy.airplane;

import com.fireboy.airplane.proxy.IProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AirplaneMod.MOD_ID, name = AirplaneMod.NAME, version = AirplaneMod.VERSION)
public class AirplaneMod {
    public static final String MOD_ID = "fireboyairplanemod";
    public static final String NAME = "Fireboy Airplane Mod";
    public static final String VERSION = "1.0";

    public static final String SERVER_PROXY = "com.fireboy.airplane.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "com.fireboy.airplane.proxy.ClientProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static IProxy proxy;

    public static final Logger logger = LogManager.getLogger(MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Capabilities Go Here
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Network Registry, GuiHandlers
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Instance
    public static AirplaneMod instance;
}

