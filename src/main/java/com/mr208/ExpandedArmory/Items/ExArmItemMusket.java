package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMusket;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import java.util.Objects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemMusket extends ItemMusket implements IWeaponMaterialCheck {

    private final int materialID;
    private final String repairMaterial;

    public ExArmItemMusket(String id, MeleeComponent meleeComponent, Item bayonetItem, String repairMaterial) {
        super(id, meleeComponent, bayonetItem);
        this.materialID = meleeComponent.weaponMaterial.ordinal();
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial) {
        for (int ores : OreDictionary.getOreIDs(repairMaterial)) {
            if (Objects.equals(OreDictionary.getOreName(ores), this.repairMaterial)) return true;
        }
        return super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }

}
