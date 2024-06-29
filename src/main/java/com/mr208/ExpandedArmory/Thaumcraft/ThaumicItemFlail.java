package com.mr208.ExpandedArmory.Thaumcraft;

import com.mr208.ExpandedArmory.Items.ExArmItemFlail;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;


public class ThaumicItemFlail extends ExArmItemFlail implements IRepairable {

    private final EnumRarity rarity;

    public ThaumicItemFlail(String id, ToolMaterial toolMaterial, EnumRarity rarity, String repairMaterial) {
        super(id, toolMaterial, repairMaterial);
        this.rarity = rarity;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1) {
        return rarity;
    }

}