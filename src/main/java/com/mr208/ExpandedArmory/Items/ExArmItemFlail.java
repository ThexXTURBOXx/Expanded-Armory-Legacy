package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemFlail;
import ckathode.weaponmod.item.MeleeCompNone;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemFlail extends ItemFlail implements IWeaponMaterialCheck {

    private final int materialID;
    private final String repairMaterial;

    public ExArmItemFlail(String id, ToolMaterial toolMaterial, String repairMaterial) {
        this(id, new MeleeCompNone(toolMaterial), repairMaterial);
    }

    public ExArmItemFlail(String id, MeleeComponent meleeComponent, String repairMaterial) {
        super(id, meleeComponent);
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
