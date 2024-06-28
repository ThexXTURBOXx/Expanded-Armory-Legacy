package com.mr208.ExpandedArmory;

import com.mr208.ExpandedArmory.FSP.FSPIntegration;
import com.mr208.ExpandedArmory.SimpleOres.SimpleOreIntegration;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.mr208.ExpandedArmory.AE2.AE2Integration;
import com.mr208.ExpandedArmory.Botania.BotaniaIntegration;
import com.mr208.ExpandedArmory.Items.GenericIntegration;
import com.mr208.ExpandedArmory.Thaumcraft.ThaumcraftIntegration;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ExArmRef.MOD_ID, name= ExArmRef.MOD_NAME, version= ExArmRef.MOD_VER, dependencies = "required-after:Forge@[10.13.4.1614,10.14);required-after:weaponmod@[1.20.0,2.0.0);after:Botania;after:appliedenergistics2;after:Thaumcraft;after:simpleores;after:fusion;after:netherrocks;after:Steamcraft")
public class ExpandedArmory {

	@Mod.Instance(ExArmRef.MOD_ID)
    public static ExpandedArmory instance;

	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ExArmConfig.init(event.getSuggestedConfigurationFile());
		if(ExArmConfig.enableFSP && Loader.isModLoaded("Steamcraft")) FSPIntegration.preInitFSP();
		GenericIntegration.preInitGI();



    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {

        if(ExArmConfig.enableBotania && Loader.isModLoaded("Botania")) BotaniaIntegration.initBotania();
        if(ExArmConfig.enableAEWeapons && Loader.isModLoaded("appliedenergistics2")) AE2Integration.initAE2();
        if(ExArmConfig.enableThaumcraftWeapons && Loader.isModLoaded("Thaumcraft")) ThaumcraftIntegration.initThaumcraft();
		if(ExArmConfig.enableFSP && Loader.isModLoaded("Steamcraft")) FSPIntegration.initFSP();
        if(ExArmConfig.enableSteel) GenericIntegration.initSteel();
        if(ExArmConfig.enableBronze)    GenericIntegration.initBronze();
        SimpleOreIntegration.initSimpleMods();

    }
}
