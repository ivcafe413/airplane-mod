package com.vagrantTech.airplane.entities;

import com.vagrantTech.core.VagrantTechMod;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class CylinderEntity extends Entity {
    
    public CylinderEntity(World world) {
        super(world);

        VagrantTechMod.logger.info("Spawn Cylinder");
        
        this.setSize(1,1);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
    }

    public CylinderEntity(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    @Override
    protected void entityInit() {
        
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(){
        return this.getEntityBoundingBox();
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        //compound.setWhatever("name", this.getWhatever())
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        //this.setWhatever(compound.getWhatever("name"))
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }
}