package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;

public class ThaumicItemMusket extends ExArmItemMusket implements IRepairable {

    private final EnumRarity rarity;

    public ThaumicItemMusket(String id, MeleeComponent meleeComponent, Item bayonetItem, EnumRarity rarity,
                             String repairMaterial) {
        super(id, meleeComponent, bayonetItem, repairMaterial);
        this.rarity = rarity;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1) {
        return rarity;
    }

}
