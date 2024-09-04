package com.mr208.ExpandedArmory.Botania;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;


public class BotanicalItemMelee extends ExArmItemMelee implements IManaUsingItem {

    public static final int MANA_PER_DMG = 51;

    public BotanicalItemMelee(String modId, String id, MeleeComponent meleeComponent, String repairMaterial) {
        super(modId, id, meleeComponent, repairMaterial);
    }

    @Override
    public boolean hitEntity(@NotNull ItemStack itemWeapon, @NotNull EntityLivingBase victim,
                             @NotNull EntityLivingBase attacker) {
        if (usesMana(itemWeapon)) ManaHelper.damageItem(itemWeapon, 1, attacker, MANA_PER_DMG);
        return super.hitEntity(itemWeapon, victim, attacker);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemWeapon, World world, Block block, int x, int y, int z,
                                    EntityLivingBase player) {
        if (usesMana(itemWeapon) && block.getBlockHardness(world, x, y, z) != 0f)
            ManaHelper.damageItem(itemWeapon, 1, player, MANA_PER_DMG);
        return super.onBlockDestroyed(itemWeapon, world, block, x, y, z, player);
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }

    @Override
    public void onUpdate(@NotNull ItemStack weapon, @NotNull World world, @NotNull Entity player, int i, boolean flag) {
        super.onUpdate(weapon, world, player, i, flag);
        if (!world.isRemote && player instanceof EntityPlayer && weapon.getItemDamage() > 0 &&
            ManaItemHandler.requestManaExactForTool(weapon, (EntityPlayer) player, MANA_PER_DMG * 2, true))
            weapon.setItemDamage(weapon.getItemDamage() - 1);
    }

}
