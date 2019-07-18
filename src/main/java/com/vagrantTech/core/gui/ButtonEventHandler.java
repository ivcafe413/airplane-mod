package com.vagrantTech.core.gui;

import com.vagrantTech.core.VagrantTechMod;
import com.vagrantTech.core.enums.EnumGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ButtonEventHandler {
    private static int BUTTON_ID = 0;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void addExtendedInventoryTabToInventory(InitGuiEvent.Post event) {
        // VagrantTechMod.logger.info("GuiScreenEvent.InitGuiEvent.Post");
        if (Minecraft.getMinecraft().currentScreen instanceof GuiInventory) {
            //VagrantTechMod.logger.info("Attempting to add the button.");

            ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
            int screenWidth = res.getScaledWidth();
            int screenHeight = res.getScaledHeight();

            // 176 = Vanilla Inventory Height
            // 166 = Vanilla Inventory Width
            //Todo: IF recipe book is open, push right a bunch
            int x = screenWidth / 2 - (176 / 2);
            int y = screenHeight / 2 - (166 / 2) - 20 + 1; // -20y To move up above the inventory, adjust 1 down

            ExtendedInventoryButton spellTab = new ExtendedInventoryButton(++BUTTON_ID, x, y, 40, 20, "Spells");

            event.getButtonList().add(spellTab);
        }
    }

    @SubscribeEvent
    public static void openExtendedInventory(ActionPerformedEvent.Pre event) {
        if(event.getButton() instanceof ExtendedInventoryButton) {
            //VagrantTechMod.logger.info("We clicked my button!");
            
            //Minecraft.getMinecraft().displayGuiScreen(new ExtendedInventoryGuiScreen());
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayer player = minecraft.player;
            player.openGui(VagrantTechMod.instance, EnumGui.EXTENDED_INVENTORY.ordinal(), minecraft.world, 0, 0, 0);
        }
    }
}