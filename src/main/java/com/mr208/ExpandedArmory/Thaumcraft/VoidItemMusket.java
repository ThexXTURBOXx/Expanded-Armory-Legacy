package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

public class VoidItemMusket extends ThaumicItemMusket implements IWarpingGear {

    public VoidItemMusket(String modId, String id, MeleeComponent meleeComponent, Item bayonetItem, EnumRarity rarity,
                          String repairMaterial) {
        super(modId, id, meleeComponent, bayonetItem, rarity, repairMaterial);
    }

    @Override
    public int getWarp(ItemStack itemStack, EntityPlayer player) {
        return 1;
    }

    @Override
    public void onUpdate(@NotNull ItemStack stack, @NotNull World world, @NotNull Entity entity, int i, boolean flag) {
        super.onUpdate(stack, world, entity, i, flag);
        if (stack.isItemDamaged() && entity.ticksExisted % 20 == 0 && entity instanceof EntityLivingBase) {
            stack.damageItem(-1, (EntityLivingBase) entity);
        }
    }

    @Override
    public boolean hitEntity(@NotNull ItemStack weapon, EntityLivingBase victim, @NotNull EntityLivingBase attacker) {
        if (!victim.worldObj.isRemote && (!(victim instanceof EntityPlayer) || !(attacker instanceof EntityPlayer) ||
                                          MinecraftServer.getServer().isPVPEnabled())) {
            try {
                victim.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60));
            } catch (Exception ignored) {
            }
        }
        return super.hitEntity(weapon, victim, attacker);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack weapon, EntityPlayer player, List list, boolean bool) {
        list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapless"));
        super.addInformation(weapon, player, list, bool);
    }

}
