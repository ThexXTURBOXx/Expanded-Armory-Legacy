package com.mr208.ExpandedArmory.Proxy;

import ckathode.weaponmod.render.RenderLongItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class EAClientProxy extends EACommonProxy {

    @Override
    public void registerLongWeapon(Item weapon) {
        MinecraftForgeClient.registerItemRenderer(weapon, RenderLongItem.INSTANCE);
    }

}
