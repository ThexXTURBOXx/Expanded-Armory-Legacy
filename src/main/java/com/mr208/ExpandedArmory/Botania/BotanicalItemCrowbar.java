package com.mr208.ExpandedArmory.Botania;

import com.mr208.ExpandedArmory.Items.ExArmItemCrowbar;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;


public class BotanicalItemCrowbar extends ExArmItemCrowbar implements IManaUsingItem {

    public static final int MANA_PER_DMG = 51;

    public BotanicalItemCrowbar(Item.ToolMaterial tmMaterial, String name, String sMaterial) {
        super(tmMaterial, name, sMaterial);
    }

    @Override
    public boolean hitEntity(ItemStack itemWeapon, EntityLivingBase targetEntity, EntityLivingBase usingEntity) {
        if (usesMana(itemWeapon)) ManaHelper.damageItem(itemWeapon, 1, usingEntity, MANA_PER_DMG);
        return super.hitEntity(itemWeapon, targetEntity, usingEntity);
    }

    @Override
    public boolean usesMana(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemWeapon, World world, Block block, int x, int y, int z,
                                    EntityLivingBase player) {
        if (usesMana(itemWeapon) && block.getBlockHardness(world, x, y, z) != 0f)
            ManaHelper.damageItem(itemWeapon, 1, player, MANA_PER_DMG);
        return super.onBlockDestroyed(itemWeapon, world, block, x, y, z, player);
    }

    @Override
    public void onUpdate(ItemStack weapon, World world, Entity player, int num, boolean bool) {
        if (!world.isRemote && player instanceof EntityPlayer && weapon.getItemDamage() > 0 &&
            ManaItemHandler.requestManaExactForTool(weapon, (EntityPlayer) player, MANA_PER_DMG * 2, true))
            weapon.setItemDamage(weapon.getItemDamage() - 1);
    }

}
