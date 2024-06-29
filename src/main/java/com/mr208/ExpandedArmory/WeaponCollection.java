package com.mr208.ExpandedArmory;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNullableByDefault;
import net.minecraft.item.Item;

@Nullable
@ParametersAreNullableByDefault
public class WeaponCollection {

    public final Item battleaxe;
    public final Item boomerang;
    public final Item flail;
    public final Item halberd;
    public final Item katana;
    public final Item knife;
    public final Item musketWithBayonet;
    public final Item spear;
    public final Item warhammer;

    public WeaponCollection(Item battleaxe, Item boomerang, Item flail, Item halberd, Item katana, Item knife,
                            Item musketWithBayonet, Item spear, Item warhammer) {
        this.battleaxe = battleaxe;
        this.boomerang = boomerang;
        this.flail = flail;
        this.halberd = halberd;
        this.katana = katana;
        this.knife = knife;
        this.musketWithBayonet = musketWithBayonet;
        this.spear = spear;
        this.warhammer = warhammer;
    }

}
