package com.mr208.ExpandedArmory.Items;

import com.mr208.ExpandedArmory.ExArmRef;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class ItemIngot extends Item {

    private final String oreDict;

    public ItemIngot(String oreDict)
    {
        this.oreDict = oreDict;
        this.setUnlocalizedName(ExArmRef.MOD_ID+"_"+oreDict);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName(ExArmRef.MOD_ID+":"+oreDict);
    }

    public void registerOreDictionary() {
        OreDictionary.registerOre(oreDict,this);
    }

}
