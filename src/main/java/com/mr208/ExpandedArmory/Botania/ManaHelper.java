package com.mr208.ExpandedArmory.Botania;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaHelper {

    public static void damageItem(ItemStack item, int damage, EntityLivingBase player, int cost) {
        int manaNeeded = damage * cost;
        boolean manaCostMet = player instanceof EntityPlayer &&
                              ManaItemHandler.requestManaExact(item, (EntityPlayer) player, manaNeeded, true);
        if (!manaCostMet) item.damageItem(damage, player);
    }

}
