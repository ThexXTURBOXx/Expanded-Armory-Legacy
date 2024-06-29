package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMelee;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Botania.ManaHelper;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;


@Optional.InterfaceList(
        value = {@Optional.Interface(iface = "vazkii.botania.api.mana.IManaUsingItem", modid = "botania")})
public class ExArmItemMelee extends ItemMelee implements IWeaponMaterialCheck, IManaUsingItem {

    private final int materialID;
    private final String repairMaterial;
    private final EnumRarity itemRarity;
    private final int MANA_PER_DMG = 51;

    public ExArmItemMelee(String id, MeleeComponent meleeComponent, String repairMaterial) {
        super(id, meleeComponent);
        this.materialID = meleeComponent.weaponMaterial.ordinal();
        this.repairMaterial = repairMaterial;
        this.itemRarity = EnumRarity.common;
    }

    public ExArmItemMelee(String id, MeleeComponent meleeComponent, String repairMaterial, EnumRarity rarity) {
        super(id, meleeComponent);
        this.materialID = meleeComponent.weaponMaterial.ordinal();
        this.repairMaterial = repairMaterial;
        this.itemRarity = rarity;
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public void onUpdate(@NotNull ItemStack stack, @NotNull World world, @NotNull Entity entity, int i, boolean flag) {
        super.onUpdate(stack, world, entity, i, flag);
        if ("ingotVoid".equals(repairMaterial)) {
            if (stack.isItemDamaged() && entity.ticksExisted % 20 == 0 && entity instanceof EntityLivingBase) {
                stack.damageItem(-1, (EntityLivingBase) entity);
            }
        }
        if ("ingotManasteel".equals(repairMaterial)) {
            if (!world.isRemote && entity instanceof EntityPlayer && stack.getItemDamage() > 0 &&
                ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) entity, MANA_PER_DMG * 2, true))
                stack.setItemDamage(stack.getItemDamage() - 1);
        }
    }

    @Override
    public boolean hitEntity(@NotNull ItemStack weapon, @NotNull EntityLivingBase victim,
                             @NotNull EntityLivingBase attacker) {
        if ("ingotVoid".equals(repairMaterial)) {
            if (!victim.worldObj.isRemote && (!(victim instanceof EntityPlayer) || !(attacker instanceof EntityPlayer) ||
                                              MinecraftServer.getServer().isPVPEnabled())) {
                try {
                    victim.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60));
                } catch (Exception ignored) {
                }
            }
        }
        if ("ingotManasteel".equals(repairMaterial)) {
            if (usesMana(weapon)) ManaHelper.damageItem(weapon, 1, attacker, MANA_PER_DMG);
        }

        return super.hitEntity(weapon, victim, attacker);
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial) {
        for (int ores : OreDictionary.getOreIDs(repairMaterial)) {
            if (Objects.equals(OreDictionary.getOreName(ores), this.repairMaterial)) return true;
        }
        return super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack weapon, EntityPlayer player, List list, boolean bool) {
        if ("ingotVoid".equals(repairMaterial)) {
            list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapless"));
        }
        super.addInformation(weapon, player, list, bool);
    }

    @Override
    public EnumRarity getRarity(ItemStack par1) {
        return itemRarity;
    }

    @Override
    public boolean usesMana(ItemStack itemStack) {
        return "ingotManasteel".equals(repairMaterial);
    }

}