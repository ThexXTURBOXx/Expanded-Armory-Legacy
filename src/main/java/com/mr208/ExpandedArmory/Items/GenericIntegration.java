package com.mr208.ExpandedArmory.Items;


import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.Railcraft.RailcraftIntegration;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class GenericIntegration {

    public static ItemIngot ingotBronze;
    public static WeaponCollection bronzeWeapons;

    public static ItemIngot ingotSteel;
    public static WeaponCollection steelWeapons;

    public static void preInitGI() {
        GameRegistry.registerItem(ingotBronze = new ItemIngot("ingotBronze"), "ingotBronze");
        ingotBronze.registerOreDictionary();
        GameRegistry.registerItem(ingotSteel = new ItemIngot("ingotSteel"), "ingotSteel");
        ingotSteel.registerOreDictionary();

        if (Loader.isModLoaded("Railcraft")) RailcraftIntegration.preInit();
    }

    public static void initBronze() {
        Item.ToolMaterial bronzeMaterial = getBronzeMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(bronzeMaterial, 0xE3A55CFF));
        if (bronzeMaterial.customCraftingMaterial == null)
            bronzeMaterial.setRepairItem(new ItemStack(ingotBronze, 1, 0));
        bronzeWeapons = RegisterItems.registerRegularWeapon("bronze", bronzeMaterial, "ingotBronze");
        RegisterItems.createWeaponRecipes(bronzeWeapons, "stickWood", "ingotBronze");
    }


    public static void initSteel() {
        Item.ToolMaterial steelMaterial = getSteelMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(steelMaterial, 0x9d9d9dFF));
        if (steelMaterial.customCraftingMaterial == null) steelMaterial.setRepairItem(new ItemStack(ingotSteel, 1, 0));
        steelWeapons = RegisterItems.registerRegularWeapon("steel", steelMaterial, "ingotSteel");
        RegisterItems.createWeaponRecipes(steelWeapons, "stickWood", "ingotSteel");
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