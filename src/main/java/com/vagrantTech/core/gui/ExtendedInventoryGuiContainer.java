package com.vagrantTech.core.gui;

import java.io.IOException;

import com.vagrantTech.core.inventory.ExtendedInventoryContainer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.ResourceLocation;

public class ExtendedInventoryGuiContainer extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private GuiButton closeButton;
    private static final ResourceLocation background = new ResourceLocation("minecraft:textures/gui/container/generic_54.png");

    public ExtendedInventoryGuiContainer(ExtendedInventoryContainer container) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    public void initGui() {
        super.initGui();

        ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
        int screenWidth = res.getScaledWidth();
        int screenHeight = res.getScaledHeight();

        //This has to be instantiated every time the gui is re-initialized
        closeButton = new GuiButton(1, screenWidth / 2 + (WIDTH / 2) - 40, screenHeight / 2 - (HEIGHT / 2) - 20, 40, 20, "Close");

        this.buttonList.add(closeButton);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == closeButton) {
            // mc.thePlayer.closeScreen();
            Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(Minecraft.getMinecraft().player));
        }
    }

    @Override
	 public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	 }
}