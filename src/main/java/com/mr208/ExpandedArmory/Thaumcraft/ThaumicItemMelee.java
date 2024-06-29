package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import cpw.mods.fml.common.Optional;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;


public class ThaumicItemMelee extends ExArmItemMelee implements IRepairable {

    private final String repairMaterial;

    public ThaumicItemMelee(String id, MeleeComponent meleeComponent, String repairMaterial, EnumRarity rarity) {
        super(id, meleeComponent, repairMaterial, rarity);
        this.repairMaterial = repairMaterial;
    }

    @Optional.Method(modid = "Thaumcraft")
    public boolean doRepair(ItemStack itemStack, EntityPlayer entityPlayer, int i) {
        return "ingotThaumium".equals(repairMaterial) || "ingotVoid".equals(repairMaterial);
    }

}
