package com.mr208.ExpandedArmory.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import static com.mr208.ExpandedArmory.ExArmRef.MOD_ID;

public class ItemIngot extends Item {

    private final String oreDict;

    public ItemIngot(String oreDict) {
        this.oreDict = oreDict;
        this.setUnlocalizedName(MOD_ID + "_" + oreDict);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName(MOD_ID + ":" + oreDict);
    }

    public void registerOreDictionary() {
        OreDictionary.registerOre(oreDict, this);
    }

}
