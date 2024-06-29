package com.mr208.ExpandedArmory.FSP;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.Items.ItemIngot;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FSPIntegration {

    public static Item ingotBrass;
    public static WeaponCollection brassWeapons;
    public static Item.ToolMaterial brass;

    public static Item ingotGilded;
    public static WeaponCollection gildedWeapons;
    public static Item.ToolMaterial gildedIron;

    public static void preInitFSP() {
        GameRegistry.registerItem(ingotBrass = new ItemIngot("ingotBrass"), "ingotBrass");
        GameRegistry.registerItem(ingotGilded = new ItemIngot("ingotGildedIron"), "ingotGildedIron");
    }

    public static void initFSP() {
        if (ExArmConfig.enableBrass) initBrass();
        if (ExArmConfig.enableGildedIron) initGilded();
    }

    private static void initBrass() {
        brass = Item.ToolMaterial.valueOf("BRASS");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(brass, 0xECDB42FF));
        if (brass.getRepairItemStack() == null) brass.setRepairItem(new ItemStack(ingotBrass));
        brassWeapons = RegisterItems.registerRegularWeapon("brass", brass, "ingotBrass");
        RegisterItems.createWeaponRecipes(brassWeapons, "stickWood", "ingotBrass");
    }

    private static void initGilded() {
        Item ingotFSP = GameRegistry.findItem("Steamcraft", "steamcraftIngot");
        if (ingotFSP != null) OreDictionary.registerOre("ingotGildedIron", new ItemStack(ingotFSP, 1, 3));
        gildedIron = Item.ToolMaterial.valueOf("GILDEDGOLD");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(gildedIron, 0xFFF068FF));
        if (gildedIron.getRepairItemStack() == null) gildedIron.setRepairItem(new ItemStack(ingotGilded));
        gildedWeapons = RegisterItems.registerRegularWeapon("gildediron", gildedIron, "ingotGildedIron");
        RegisterItems.createWeaponRecipes(gildedWeapons, "stickWood", "ingotGildedIron");
    }

}
