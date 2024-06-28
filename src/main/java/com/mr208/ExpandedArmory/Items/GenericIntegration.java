package com.mr208.ExpandedArmory.Items;


import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.Railcraft.RailcraftIntegration;
import com.mr208.ExpandedArmory.RegisterItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;

import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;

public class GenericIntegration {

    public static ItemIngot ingotBronze;
    public static Item battleaxeBronze;
    public static Item boomerangBronze;
    public static Item flailBronze;
    public static Item halberdBronze;
    public static Item katanaBronze;
    public static Item knifeBronze;
    public static Item musketbayonetBronze;
    public static Item spearBronze;
    public static Item warhammerBronze;

    public static ItemIngot ingotSteel;
    public static Item battleaxeSteel;
    public static Item boomerangSteel;
    public static Item flailSteel;
    public static Item halberdSteel;
    public static Item katanaSteel;
    public static Item knifeSteel;
    public static Item musketbayonetSteel;
    public static Item spearSteel;
    public static Item warhammerSteel;

    public static Item crowbarResistance;


    public static void preInitGI()
    {
        GameRegistry.registerItem(ingotBronze = new ItemIngot("ingotBronze"),"ingotBronze");
        ingotBronze.registerOreDictionary();
        GameRegistry.registerItem(ingotSteel = new ItemIngot("ingotSteel"),"ingotSteel");
        ingotSteel.registerOreDictionary();

		if(Loader.isModLoaded("Railcraft")) RailcraftIntegration.preInit();
    }

    public static void initBronze() {

        Item.ToolMaterial bronzeMaterial = getBronzeMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(bronzeMaterial,0xE3A55CFF));
        if(bronzeMaterial.customCraftingMaterial==null)   bronzeMaterial.setRepairItem(new ItemStack(ingotBronze,1,0));
		Item[] weaponArray = {battleaxeBronze, boomerangBronze, flailBronze, halberdBronze, katanaBronze, knifeBronze, musketbayonetBronze, spearBronze, warhammerBronze};
        RegisterItems.RegisterRegularWeapon(weaponArray,"bronze",bronzeMaterial,"ingotBronze");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotBronze");
    }


    public static void initSteel() {

        Item.ToolMaterial steelMaterial = getSteelMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(steelMaterial,0x9d9d9dFF));
        if(steelMaterial.customCraftingMaterial==null)    steelMaterial.setRepairItem(new ItemStack(ingotSteel, 1,0));
        Item[] weaponArray = {battleaxeSteel, boomerangSteel, flailSteel, halberdSteel, katanaSteel, knifeSteel, musketbayonetSteel, spearSteel, warhammerSteel};
        RegisterItems.RegisterRegularWeapon(weaponArray,"steel",steelMaterial,"ingotSteel");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotSteel");


    }


    private static Item.ToolMaterial getBronzeMaterial() {
        if (Loader.isModLoaded("fusion")) return Item.ToolMaterial.valueOf("BRONZE");
        if (Loader.isModLoaded("ThermalFoundation")) return Item.ToolMaterial.valueOf("TF:BRONZE");
        return EnumHelper.addToolMaterial("EA|BRONZE", 2, 500, 6f, 2f, 15);
    }

    private static Item.ToolMaterial getSteelMaterial() {
        if (Loader.isModLoaded("fusion")) return Item.ToolMaterial.valueOf("STEEL");
        if (Loader.isModLoaded("Railcraft")) return Item.ToolMaterial.valueOf("RAILCRAFT_STEEL");
        return EnumHelper.addToolMaterial("EA|STEEL", 2, 500, 7f, 2f, 9);
    }
}