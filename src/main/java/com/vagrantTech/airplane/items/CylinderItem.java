package com.vagrantTech.airplane.items;

import com.vagrantTech.airplane.entities.CylinderEntity;
import com.vagrantTech.core.VagrantTechMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CylinderItem extends Item {
    public CylinderItem() {
        this.setRegistryName("cylinderitem");
        this.setUnlocalizedName(VagrantTechMod.MODID + ".cylinderitem");
        this.setCreativeTab(CreativeTabs.MISC);
        this.maxStackSize = 1;
    }

    //Todo: Use onItemUse instead
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        if (!world.isRemote) {
            VagrantTechMod.logger.info("Cylinder Item Right Click...");

            //Vec3d v3 = player.getLookVec();
            RayTraceResult rayTraceResult = rayTrace(world, player, true);
            if(rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) {
                return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStack);
            }

            BlockPos blockPosition = rayTraceResult.getBlockPos();

            world.spawnEntity(new CylinderEntity(world, blockPosition.getX() + 0.5D, blockPosition.getY() + 1, blockPosition.getZ() + 0.5D));
        }

        if (!player.capabilities.isCreativeMode) {
            itemStack.shrink(1);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    //@Override

}