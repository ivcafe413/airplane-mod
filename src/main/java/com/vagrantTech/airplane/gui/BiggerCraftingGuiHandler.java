package com.vagrantTech.airplane.gui;

import com.vagrantTech.airplane.containers.BiggerCraftingContainer;
import com.vagrantTech.core.enums.EnumGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BiggerCraftingGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EnumGui.BIGGER_CRAFTING.ordinal()) {
            return new BiggerCraftingContainer(player.inventory, world);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EnumGui.BIGGER_CRAFTING.ordinal()) {
            return new BiggerCraftingGuiContainer(new BiggerCraftingContainer(player.inventory, world));
        }
        return null;
    }
}