package com.mr208.ExpandedArmory.Railcraft;

import com.mr208.ExpandedArmory.Items.GenericIntegration;
import com.mr208.ExpandedArmory.Items.ItemCrowbarResistance;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;

public class RailcraftIntegration {

    public static Item crowbarResistance;
    public static Item.ToolMaterial freeSteel;

    public static void preInit() {
        Item.ToolMaterial diamondMat = Item.ToolMaterial.EMERALD;
        freeSteel = EnumHelper.addToolMaterial("FREESTEEL", diamondMat.getHarvestLevel(), diamondMat.getMaxUses(),
                diamondMat.getEfficiencyOnProperMaterial(), diamondMat.getDamageVsEntity(),
                diamondMat.getEnchantability()).setRepairItem(new ItemStack(GenericIntegration.ingotSteel));
        GameRegistry.registerItem(crowbarResistance = new ItemCrowbarResistance(freeSteel), "crowbar.resistance");
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(
                new ItemStack(crowbarResistance).copy(), 1, 1, 2));
    }

}

