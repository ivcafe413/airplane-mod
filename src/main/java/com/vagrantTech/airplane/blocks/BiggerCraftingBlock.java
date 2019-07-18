package com.vagrantTech.airplane.blocks;

import com.vagrantTech.core.VagrantTechMod;
import com.vagrantTech.core.enums.EnumGui;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiggerCraftingBlock extends Block {
    public BiggerCraftingBlock() {
        super(Material.WOOD);
        setUnlocalizedName(VagrantTechMod.MODID + ".biggercraftingblock");
        setRegistryName("biggercraftingblock");
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(world.isRemote) {
            //Server
            return true;
        }

        //Client, OpenGui
        player.openGui(VagrantTechMod.instance, EnumGui.BIGGER_CRAFTING.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}