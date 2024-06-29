package com.mr208.ExpandedArmory.AE2;

import appeng.api.AEApi;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class AE2Integration {

    public static WeaponCollection certusQuartzWeapons;
    public static Item.ToolMaterial certusQuartz;

    public static WeaponCollection quartzWeapons;
    public static Item.ToolMaterial netherQuartz;

    public static void initAE2() {
        if (ExArmConfig.enableCertusQuartz) initCertus();
        if (ExArmConfig.enableNetherQuartz) initNether();
    }

    private static void initNether() {
        ItemStack quartzIS = new ItemStack(Items.quartz);
        netherQuartz = EnumHelper.addToolMaterial("NETHER_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());
        netherQuartz.setRepairItem(quartzIS);
        OreDictionary.registerOre("quartzNether", Items.quartz);
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xBFB8AEFF));
        //MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xD9D4CFFF));

        quartzWeapons = RegisterItems.registerRegularWeapon("quartz", netherQuartz, "quartzNether");
        RegisterItems.createWeaponRecipes(quartzWeapons, "stickWood", "quartzNether");
    }

    private static void initCertus() {
        ItemStack certusIS = AEApi.instance().materials().materialCertusQuartzCrystal.stack(1);
        certusQuartz = EnumHelper.addToolMaterial("CERTUS_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());
        certusQuartz.setRepairItem(certusIS);
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(certusQuartz, 0xADC6EEFF));
        //MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(certusQuartz, 0x91CDEAFF));

        OreDictionary.registerOre("quartzCertus", certusIS);

        certusQuartzWeapons = RegisterItems.registerRegularWeapon("certus", certusQuartz, "quartzCertus");
        RegisterItems.createWeaponRecipes(certusQuartzWeapons, "stickWood", "quartzCertus");
    }

}
