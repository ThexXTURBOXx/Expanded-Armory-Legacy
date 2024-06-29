package com.mr208.ExpandedArmory.SimpleOres;

import alexndr.plugins.SimpleOres.SimpleOres;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleOreIntegration {

    public static WeaponCollection adamantiumWeapons;
    public static WeaponCollection onyxWeapons;
    public static WeaponCollection thyriumWeapons;
    public static WeaponCollection sinisiteWeapons;
    public static WeaponCollection malachiteWeapons;
    public static WeaponCollection ashstoneWeapons;
    public static WeaponCollection dragonstoneWeapons;
    public static WeaponCollection argoniteWeapons;

    public static void initSimpleMods() {
        if (Loader.isModLoaded("simpleores")) {
            if (ExArmConfig.enableAdamantium) initAdamantium();
            if (ExArmConfig.enableOnyx) initOnyx();
        }

        if (Loader.isModLoaded("fusion")) {
            if (ExArmConfig.enableThyrium) initThyrium();
            if (ExArmConfig.enableSinisite) initSinisite();
        }

        if (Loader.isModLoaded("netherrocks")) {
            if (ExArmConfig.enableMalachite) initMalachite();
            if (ExArmConfig.enableAshstone) initAshstone();
            if (ExArmConfig.enableDragonstone) initDragonstone();
            if (ExArmConfig.enableArgonite) initArgonite();
        }
    }

    public static void initAdamantium() {
        Item.ToolMaterial adamantiumMaterial = SimpleOres.toolAdamantium;
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(adamantiumMaterial, 0x158020FF));

        Item ingotAdamantium = GameRegistry.findItem("simpleores", "adamantium_ingot");

        if (adamantiumMaterial.getRepairItemStack() == null) {
            adamantiumMaterial.setRepairItem(new ItemStack(ingotAdamantium));
        }

        adamantiumWeapons = RegisterItems.registerRegularWeapon("adamantium", adamantiumMaterial, "ingotAdamantium");
        RegisterItems.createWeaponRecipes(adamantiumWeapons, "stickWood", "ingotAdamantium");
    }

    public static void initOnyx() {
        Item.ToolMaterial onyxMaterial = SimpleOres.toolOnyx;
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(onyxMaterial, 0x363636FF));

        Item ingotOnyx = GameRegistry.findItem("simpleores", "onyx_gem");

        if (onyxMaterial.getRepairItemStack() == null) {
            onyxMaterial.setRepairItem(new ItemStack(ingotOnyx));
        }

        onyxWeapons = RegisterItems.registerRegularWeapon("onyx", onyxMaterial, "gemOnyx");
        RegisterItems.createWeaponRecipes(onyxWeapons, "stickWood", "gemOnyx");
    }

    public static void initThyrium() {
        Item.ToolMaterial thyriumMaterial = Item.ToolMaterial.valueOf("THYRIUM");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(thyriumMaterial, 0x64d6b7FF));

        Item ingotThyrium = GameRegistry.findItem("fusion", "thyrium_ingot");

        if (thyriumMaterial.getRepairItemStack() == null) {
            thyriumMaterial.setRepairItem(new ItemStack(ingotThyrium));
        }

        thyriumWeapons = RegisterItems.registerRegularWeapon("thyrium", thyriumMaterial, "ingotThyrium");
        RegisterItems.createWeaponRecipes(thyriumWeapons, "stickWood", "ingotThyrium");
    }

    public static void initSinisite() {
        Item.ToolMaterial sinisiteMaterial = Item.ToolMaterial.valueOf("SINISITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(sinisiteMaterial, 0x171770FF));

        Item ingotSinisite = GameRegistry.findItem("fusion", "sinisite_ingot");

        if (sinisiteMaterial.getRepairItemStack() == null) {
            sinisiteMaterial.setRepairItem(new ItemStack(ingotSinisite));
        }

        sinisiteWeapons = RegisterItems.registerRegularWeapon("sinisite", sinisiteMaterial, "ingotSinisite");
        RegisterItems.createWeaponRecipes(sinisiteWeapons, "stickWood", "ingotSinisite");
    }

    public static void initMalachite() {
        Item.ToolMaterial malachiteMaterial = Item.ToolMaterial.valueOf("MALACHITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(malachiteMaterial, 0x08ba5cFF));

        Item ingotMalachite = GameRegistry.findItem("netherrocks", "malachite_ingot");

        if (malachiteMaterial.getRepairItemStack() == null) {
            malachiteMaterial.setRepairItem(new ItemStack(ingotMalachite));
        }

        malachiteWeapons = RegisterItems.registerRegularWeapon("malachite", malachiteMaterial, "ingotMalachite");
        RegisterItems.createWeaponRecipes(malachiteWeapons, "stickWood", "ingotMalachite");
    }

    public static void initAshstone() {
        Item.ToolMaterial ashstoneMaterial = Item.ToolMaterial.valueOf("ASHSTONE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ashstoneMaterial, 0x7c7c7cFF));

        Item ingotAshstone = GameRegistry.findItem("netherrocks", "ashstone_gem");

        if (ashstoneMaterial.getRepairItemStack() == null) {
            ashstoneMaterial.setRepairItem(new ItemStack(ingotAshstone));
        }

        ashstoneWeapons = RegisterItems.registerRegularWeapon("ashstone", ashstoneMaterial, "gemAshstone");
        RegisterItems.createWeaponRecipes(ashstoneWeapons, "stickWood", "gemAshstone");
    }

    public static void initDragonstone() {
        Item.ToolMaterial dragonstoneMaterial = Item.ToolMaterial.valueOf("DRAGONSTONE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(dragonstoneMaterial, 0x661714FF));

        Item ingotDragonstone = GameRegistry.findItem("netherrocks", "dragonstone_gem");

        if (dragonstoneMaterial.getRepairItemStack() == null) {
            dragonstoneMaterial.setRepairItem(new ItemStack(ingotDragonstone));
        }

        dragonstoneWeapons = RegisterItems.registerRegularWeapon("dragonstone", dragonstoneMaterial, "gemDragonstone");
        RegisterItems.createWeaponRecipes(dragonstoneWeapons, "stickWood", "gemDragonstone");
    }

    public static void initArgonite() {
        Item.ToolMaterial argoniteMaterial = Item.ToolMaterial.valueOf("ARGONITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(argoniteMaterial, 0x1b0044FF));

        Item ingotArgonite = GameRegistry.findItem("netherrocks", "argonite_ingot");

        if (argoniteMaterial.getRepairItemStack() == null) {
            argoniteMaterial.setRepairItem(new ItemStack(ingotArgonite));
        }

        argoniteWeapons = RegisterItems.registerRegularWeapon("argonite", argoniteMaterial, "ingotArgonite");
        RegisterItems.createWeaponRecipes(argoniteWeapons, "stickWood", "ingotArgonite");
    }

}
