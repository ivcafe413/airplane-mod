package com.vagrantTech.airplane.entities;

import com.vagrantTech.core.VagrantTechMod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
    private static int modId = 0;
    public static void register() {
        EntityRegistry.registerModEntity(new ResourceLocation(VagrantTechMod.MODID, "cylinderentity"), CylinderEntity.class, "Cylinder", modId++, VagrantTechMod.instance, 64, 3, true);
    }
}