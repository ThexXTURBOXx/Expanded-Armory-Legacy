package com.mr208.ExpandedArmory.Botania;

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
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.WeaponCollection;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.ModItems;

public class BotaniaIntegration {

    public static WeaponCollection manasteelWeapons;
    public static Item crowbarManasteel;

    public static void initBotania() {
        if (ExArmConfig.enableManaSteel) initManasteel();
    }

    private static void initManasteel() {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(BotaniaAPI.manasteelToolMaterial,
                0x7DC3E5FF));
        ItemStack manasteelIS = new ItemStack(ModItems.manaResource, 1, 0);
        if (Item.ToolMaterial.valueOf("MANASTEEL").customCraftingMaterial == null) {
            Item.ToolMaterial.valueOf("MANASTEEL").setRepairItem(manasteelIS);
        }
        Item battleaxe = null, boomerang = null, flail = null, halberd = null, katana = null, knife = null,
                musketWithBayonet = null, spear = null, warhammer = null;
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
            battleaxe = new ExArmItemMelee("@MOD_ID@", "battleaxe.manasteel",
                    new MeleeCompBattleaxe(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/battleaxe.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
            boomerang = new ExArmItemMelee("@MOD_ID@", "boomerang.manasteel",
                    new MeleeCompBoomerang(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/boomerang.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
            flail = new BotanicalItemFlail("@MOD_ID@", "flail.manasteel", BotaniaAPI.manasteelToolMaterial,
                    "ingotManasteel").setTextureName("@MOD_ID@:manasteel/flail.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
            halberd = new ExArmItemMelee("@MOD_ID@", "halberd.manasteel",
                    new MeleeCompHalberd(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/halberd.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
            katana = new ExArmItemMelee("@MOD_ID@", "katana.manasteel",
                    new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, BotaniaAPI.manasteelToolMaterial),
                    "ingotManasteel").setTextureName("@MOD_ID@:manasteel/katana.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("knife")) {
            knife = new ExArmItemMelee("@MOD_ID@", "knife.manasteel",
                    new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/knife.manasteel");
            if (BalkonsWeaponMod.instance.modConfig.isEnabled("musket"))
                musketWithBayonet = new BotanicalItemMusket("@MOD_ID@", "musketbayonet.manasteel",
                        new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial), knife, "ingotManasteel")
                        .setTextureName("@MOD_ID@:manasteel/musketbayonet.manasteel");
        }
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
            spear = new ExArmItemMelee("@MOD_ID@", "spear.manasteel",
                    new MeleeCompSpear(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/spear.manasteel");
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
            warhammer = new ExArmItemMelee("@MOD_ID@", "warhammer.manasteel",
                    new MeleeCompWarhammer(BotaniaAPI.manasteelToolMaterial), "ingotManasteel")
                    .setTextureName("@MOD_ID@:manasteel/warhammer.manasteel");

        manasteelWeapons = new WeaponCollection(battleaxe, boomerang, flail, halberd, katana, knife,
                musketWithBayonet, spear, warhammer);
        RegisterItems.createWeaponRecipes(manasteelWeapons, "livingwoodTwig", "ingotManasteel");

        if (Loader.isModLoaded("Railcraft")) {
            crowbarManasteel = new BotanicalItemCrowbar(BotaniaAPI.manasteelToolMaterial, "manasteel",
                    "ingotManasteel").setTextureName("@MOD_ID@:manasteel/crowbar.manasteel");
            GameRegistry.registerItem(crowbarManasteel, "crowbar.manasteel", "@MOD_ID@");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crowbarManasteel).copy(), " d#", "d#d", "#d ",
                    'd', "dyeRed", '#', "ingotManasteel"));
        }
    }

}
