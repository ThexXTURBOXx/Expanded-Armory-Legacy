package com.mr208.ExpandedArmory;

import ckathode.weaponmod.entity.projectile.ICustomProjectileMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomMaterials implements ICustomProjectileMaterials {

    public final Item.ToolMaterial customMat;
    public final int entityColorI;
    public final float[] entityColorF;

    public CustomMaterials(Item.ToolMaterial material, int color) {
        customMat = material;
        entityColorI = color;
        entityColorF = new float[4];
        entityColorF[0] = ((entityColorI >> 24) & 0xFF) / 255f;
        entityColorF[1] = ((entityColorI >> 16) & 0xFF) / 255f;
        entityColorF[2] = ((entityColorI >> 8) & 0xFF) / 255f;
        entityColorF[3] = (entityColorI & 0xFF) / 255f;
    }

    @Override
    public int[] getAllMaterialIDs() {
        return new int[]{customMat.ordinal()};
    }

    @Override
    public int getMaterialID(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IWeaponMaterialCheck) {
            return ((IWeaponMaterialCheck) itemStack.getItem()).getMaterialID();
        }
        return 0;
    }

    @Override
    public float[] getColorFromMaterialID(int i) {
        return entityColorF;
    }

}
