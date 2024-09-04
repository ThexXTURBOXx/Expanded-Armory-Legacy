package com.mr208.ExpandedArmory.Items;

import cpw.mods.fml.common.Optional;
import java.util.Objects;
import mods.railcraft.common.items.ItemCrowbar;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@Optional.Interface(iface = "mods.railcraft.common.items.ItemCrowbar", modid = "Railcraft")
public class ExArmItemCrowbar extends ItemCrowbar {

    private final String repairMaterial;
    private final String materialName;

    public ExArmItemCrowbar(Item.ToolMaterial tmMaterial, String name, String sMaterial) {
        super(tmMaterial);
        this.materialName = name;
        this.setUnlocalizedName("crowbar." + name);
        this.repairMaterial = sMaterial;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("@MOD_ID@:" + materialName + "/crowbar." + materialName);
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial) {
        for (int ores : OreDictionary.getOreIDs(repairMaterial)) {
            if (Objects.equals(OreDictionary.getOreName(ores), this.repairMaterial)) return true;
        }
        return super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }

}
