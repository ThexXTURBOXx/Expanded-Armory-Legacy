package com.mr208.ExpandedArmory;


import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.item.MeleeCompBattleaxe;
import ckathode.weaponmod.item.MeleeCompBoomerang;
import ckathode.weaponmod.item.MeleeCompHalberd;
import ckathode.weaponmod.item.MeleeCompKnife;
import ckathode.weaponmod.item.MeleeCompSpear;
import ckathode.weaponmod.item.MeleeCompWarhammer;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemFlail;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;


public class RegisterItems {

    public static WeaponCollection registerRegularWeapon(String itemName, Item.ToolMaterial material,
                                                         String repairItem) {
        Item battleaxe = null, boomerang = null, flail = null, halberd = null, katana = null, knife = null,
                musketWithBayonet = null, spear = null, warhammer = null;
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
            battleaxe = new ExArmItemMelee("battleaxe." + itemName, new MeleeCompBattleaxe(material),
                    repairItem).setTextureName("@MOD_ID@:" + itemName + "/battleaxe." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
            boomerang = new ExArmItemMelee("boomerang." + itemName, new MeleeCompBoomerang(material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/boomerang." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
            flail = new ExArmItemFlail("flail." + itemName, material, repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/flail." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
            halberd = new ExArmItemMelee("halberd." + itemName, new MeleeCompHalberd(material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/halberd." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
            katana = new ExArmItemMelee("katana." + itemName,
                    new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/katana." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("knife")) {
            knife = new ExArmItemMelee("knife." + itemName, new MeleeCompKnife(material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/knife." + itemName);
            if (BalkonsWeaponMod.instance.modConfig.isEnabled("musket"))
                musketWithBayonet = new ExArmItemMusket("musketbayonet." + itemName,
                        new MeleeCompKnife(material), knife, repairItem)
                        .setTextureName("@MOD_ID@:" + itemName + "/musketbayonet." + itemName);
        }
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
            spear = new ExArmItemMelee("spear." + itemName, new MeleeCompSpear(material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/spear." + itemName);
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
            warhammer = new ExArmItemMelee("warhammer." + itemName, new MeleeCompWarhammer(material), repairItem)
                    .setTextureName("@MOD_ID@:" + itemName + "/warhammer." + itemName);
        return new WeaponCollection(
                battleaxe, boomerang, flail, halberd, katana, knife, musketWithBayonet, spear, warhammer);
    }

    public static void createWeaponRecipes(WeaponCollection weapons, Object stickItem, Object materialItem) {
        // Battleaxe
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe") && weapons.battleaxe != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.battleaxe), "###", "#X#", " X ",
                    'X', stickItem, '#', materialItem));
        // Boomerang
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang") && weapons.boomerang != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.boomerang), "XX#", "  X", "  X",
                    'X', "plankWood", '#', materialItem));
        // Flail
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("flail") && weapons.flail != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.flail), "  O", " XO", "X #",
                    'X', stickItem, 'O', "string", '#', materialItem));
        // Halberd
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("halberd") && weapons.halberd != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.halberd), " ##", " X#", "X  ",
                    'X', stickItem, '#', materialItem));
        // Katana
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("katana") && weapons.katana != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.katana), "  #", " # ", "X  ",
                    'X', stickItem, '#', materialItem));
        // Knife
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("knife") && weapons.knife != null) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.knife), "#X",
                    'X', stickItem, '#', materialItem));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons.knife), "#", "X",
                    'X', stickItem, '#', materialItem));
            // Musket with Bayonet
            if (BalkonsWeaponMod.instance.modConfig.isEnabled("musket") && weapons.musketWithBayonet != null)
                GameRegistry.addShapelessRecipe(new ItemStack(weapons.musketWithBayonet),
                        weapons.knife, BalkonsWeaponMod.musket);
        }
        // Spear
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("spear") && weapons.spear != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(weapons.spear, "  #", " X ", "X  ",
                    'X', stickItem, '#', materialItem));
        // Warhammer
        if (BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer") && weapons.warhammer != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(weapons.warhammer, "#X#", "#X#", " X ",
                    'X', stickItem, '#', materialItem));
    }

}
