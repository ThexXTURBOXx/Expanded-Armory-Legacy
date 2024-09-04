package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.MeleeCompBattleaxe;
import ckathode.weaponmod.item.MeleeCompBoomerang;
import ckathode.weaponmod.item.MeleeCompHalberd;
import ckathode.weaponmod.item.MeleeCompKnife;
import ckathode.weaponmod.item.MeleeCompSpear;
import ckathode.weaponmod.item.MeleeCompWarhammer;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;

public class ThaumcraftIntegration {

    public static WeaponCollection thaumiumWeapons;
    public static WeaponCollection voidMetalWeapons;

    public static void initThaumcraft() {
        if (ExArmConfig.enableThaumium) initThaumium();
        if (ExArmConfig.enableVoidMetal) initVoidMetal();
    }

    private static void initVoidMetal() {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatVoid, 0x2F1346FF));
        Item voidItem = GameRegistry.findItem("Thaumcraft", "ItemResource");

        if (ThaumcraftApi.toolMatVoid.getRepairItemStack() == null) {
            ThaumcraftApi.toolMatVoid.setRepairItem(new ItemStack(voidItem, 1, 16));
        }
        Item battleaxe = null, boomerang = null, flail = null, halberd = null, katana = null, knife = null,
                musketWithBayonet = null, spear = null, warhammer = null;
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
            battleaxe = new ThaumicItemMelee("@MOD_ID@", "battleaxe.void",
                    new MeleeCompBattleaxe(ThaumcraftApi.toolMatVoid), "ingotVoid", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:void/battleaxe.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
            boomerang = new ThaumicItemMelee("@MOD_ID@", "boomerang.void",
                    new MeleeCompBoomerang(ThaumcraftApi.toolMatVoid), "ingotVoid", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:void/boomerang.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
            flail = new VoidItemFlail("@MOD_ID@", "flail.void", ThaumcraftApi.toolMatVoid, EnumRarity.uncommon,
                    "ingotVoid").setTextureName("@MOD_ID@:void/flail.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
            halberd = new ThaumicItemMelee("@MOD_ID@", "halberd.void", new MeleeCompHalberd(ThaumcraftApi.toolMatVoid),
                    "ingotVoid", EnumRarity.uncommon).setTextureName("@MOD_ID@:void/halberd.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
            katana = new ThaumicItemMelee("@MOD_ID@", "katana.void",
                    new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,
                    ThaumcraftApi.toolMatVoid), "ingotVoid", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:void/katana.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("knife")) {
            knife = new ThaumicItemMelee("@MOD_ID@", "knife.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid),
                    "ingotVoid", EnumRarity.uncommon).setTextureName("@MOD_ID@:void/knife.void");
            if (BalkonsWeaponMod.instance.modConfig.isEnabled("musket"))
                musketWithBayonet = new VoidItemMusket("@MOD_ID@", "musketbayonet.void",
                        new MeleeCompKnife(ThaumcraftApi.toolMatVoid), knife, EnumRarity.uncommon, "ingotVoid")
                        .setTextureName("@MOD_ID@:void/musketbayonet.void");
        }
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
            spear = new ThaumicItemMelee("@MOD_ID@", "spear.void", new MeleeCompSpear(ThaumcraftApi.toolMatVoid),
                    "ingotVoid", EnumRarity.uncommon).setTextureName("@MOD_ID@:void/spear.void");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
            warhammer = new ThaumicItemMelee("@MOD_ID@", "warhammer.void",
                    new MeleeCompWarhammer(ThaumcraftApi.toolMatVoid), "ingotVoid", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:void/warhammer.void");

        voidMetalWeapons = new WeaponCollection(battleaxe, boomerang, flail, halberd, katana, knife,
                musketWithBayonet, spear, warhammer);
        RegisterItems.createWeaponRecipes(voidMetalWeapons, "stickWood", "ingotVoid");
    }

    private static void initThaumium() {
        MaterialRegistry.registerCustomProjectileMaterial(
                new CustomMaterials(ThaumcraftApi.toolMatThaumium, 0x46367dFF));
        Item thaumItem = GameRegistry.findItem("Thaumcraft", "ItemResource");

        if (ThaumcraftApi.toolMatThaumium.customCraftingMaterial == null) {
            ThaumcraftApi.toolMatThaumium.setRepairItem(new ItemStack(thaumItem, 1, 2));
        }
        Item battleaxe = null, boomerang = null, flail = null, halberd = null, katana = null, knife = null,
                musketWithBayonet = null, spear = null, warhammer = null;
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
            battleaxe = new ThaumicItemMelee("@MOD_ID@", "battleaxe.thaumium",
                    new MeleeCompBattleaxe(ThaumcraftApi.toolMatThaumium), "ingotThaumium", EnumRarity.uncommon).setTextureName("@MOD_ID@:thaumium/battleaxe.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
            boomerang = new ThaumicItemMelee("@MOD_ID@", "boomerang.thaumium",
                    new MeleeCompBoomerang(ThaumcraftApi.toolMatThaumium), "ingotThaumium", EnumRarity.uncommon).setTextureName("@MOD_ID@:thaumium/boomerang.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
            flail = new ThaumicItemFlail("@MOD_ID@", "flail.thaumium", ThaumcraftApi.toolMatThaumium,
                    EnumRarity.uncommon,
                    "ingotThaumium").setTextureName("@MOD_ID@:thaumium/flail.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
            halberd = new ThaumicItemMelee("@MOD_ID@", "halberd.thaumium",
                    new MeleeCompHalberd(ThaumcraftApi.toolMatThaumium), "ingotThaumium", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:thaumium/halberd.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
            katana = new ThaumicItemMelee("@MOD_ID@", "katana.thaumium",
                    new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatThaumium),
                    "ingotThaumium", EnumRarity.uncommon).setTextureName("@MOD_ID@:thaumium/katana.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("knife")) {
            knife = new ThaumicItemMelee("@MOD_ID@", "knife.thaumium",
                    new MeleeCompKnife(ThaumcraftApi.toolMatThaumium),
                    "ingotThaumium", EnumRarity.uncommon).setTextureName("@MOD_ID@:thaumium/knife.thaumium");
            if (BalkonsWeaponMod.instance.modConfig.isEnabled("musket"))
                musketWithBayonet = new ThaumicItemMusket("@MOD_ID@", "musketbayonet.thaumium",
                        new MeleeCompKnife(ThaumcraftApi.toolMatThaumium), knife, EnumRarity.uncommon,
                        "ingotThaumium").setTextureName("@MOD_ID@:thaumium/musketbayonet.thaumium");
        }
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
            spear = new ThaumicItemMelee("@MOD_ID@", "spear.thaumium",
                    new MeleeCompSpear(ThaumcraftApi.toolMatThaumium),
                    "ingotThaumium", EnumRarity.uncommon).setTextureName("@MOD_ID@:thaumium/spear.thaumium");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
            warhammer = new ThaumicItemMelee("@MOD_ID@", "warhammer.thaumium",
                    new MeleeCompWarhammer(ThaumcraftApi.toolMatThaumium), "ingotThaumium", EnumRarity.uncommon)
                    .setTextureName("@MOD_ID@:thaumium/warhammer.thaumium");

        thaumiumWeapons = new WeaponCollection(battleaxe, boomerang, flail, halberd, katana, knife,
                musketWithBayonet, spear, warhammer);
        RegisterItems.createWeaponRecipes(thaumiumWeapons, "stickWood", "ingotThaumium");
    }

}
