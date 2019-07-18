package com.vagrantTech.core.gui;

import com.vagrantTech.core.enums.EnumGui;
import com.vagrantTech.core.inventory.ExtendedInventoryContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ExtendedInventoryGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == EnumGui.EXTENDED_INVENTORY.ordinal()) {
            return new ExtendedInventoryContainer(player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == EnumGui.EXTENDED_INVENTORY.ordinal()) {
            return new ExtendedInventoryGuiContainer(new ExtendedInventoryContainer(player));
        }
        return null;
    }
}
