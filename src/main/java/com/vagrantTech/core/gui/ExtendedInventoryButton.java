package com.vagrantTech.core.gui;

import net.minecraft.client.gui.GuiButton;
//import net.minecraft.util.ResourceLocation;

public class ExtendedInventoryButton extends GuiButton {
    //private ResourceLocation tabResource = new ResourceLocation("vagranttechmod:textures/gui/spellsTab");
    public ExtendedInventoryButton(int buttonId, int x, int y, int width, int height, String textString) {
        super(buttonId, x, y, width, height, textString);
        //Todo: Need to change tab texture
        //Todo: Requires overriding of draw for different texture
        //this.BUTTON_TEXTURES = tabResource;
    }
}