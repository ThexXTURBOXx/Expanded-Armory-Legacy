package com.mr208.ExpandedArmory.Items;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import static com.mr208.ExpandedArmory.ExArmRef.MOD_ID;

public class ItemIngot extends Item {

    public static final Map<String, ItemIngot> ITEM_INGOTS = new HashMap<>();

    public ItemIngot(String oreDict) {
        ITEM_INGOTS.put(oreDict, this);
        this.setUnlocalizedName(MOD_ID + "_" + oreDict);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName(MOD_ID + ":" + oreDict);
    }

    public static void registerOreDictionary() {
        for (String oreDict : ITEM_INGOTS.keySet())
            OreDictionary.registerOre(oreDict, ITEM_INGOTS.get(oreDict));
    }

}
