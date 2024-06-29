package com.mr208.ExpandedArmory.Botania;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class BotanicalItemMusket extends ExArmItemMusket implements IManaUsingItem {

    private static final int MANA_PER_DMG = 51;

    public BotanicalItemMusket(String id, MeleeComponent meleeComponent, Item bayonetItem, String repairMaterial) {
        super(id, meleeComponent, bayonetItem, repairMaterial);
    }

    @Override
    public boolean hitEntity(@NotNull ItemStack itemWeapon, @NotNull EntityLivingBase targetEntity,
                             @NotNull EntityLivingBase usingEntity) {
        if (usesMana(itemWeapon)) ManaHelper.damageItem(itemWeapon, 1, usingEntity, MANA_PER_DMG);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemWeapon, World world, Block block, int x, int y, int z,
                                    EntityLivingBase player) {
        if (usesMana(itemWeapon) && block.getBlockHardness(world, x, y, z) != 0f)
            ManaHelper.damageItem(itemWeapon, 1, player, MANA_PER_DMG);
        return true;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }

    @Override
    public void onUpdate(@NotNull ItemStack weapon, World world, @NotNull Entity player, int num, boolean bool) {
        if (!world.isRemote && player instanceof EntityPlayer && weapon.getItemDamage() > 0 &&
            ManaItemHandler.requestManaExactForTool(weapon, (EntityPlayer) player, MANA_PER_DMG * 2, true))
            weapon.setItemDamage(weapon.getItemDamage() - 1);
    }

}
