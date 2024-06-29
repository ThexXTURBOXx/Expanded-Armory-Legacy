package com.mr208.ExpandedArmory;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ExArmConfig {

    public static Configuration conf;

    // General Alloys and Metals
    public static Boolean enableBronze;
    public static Boolean enableSteel;

    // Flaxbeard's Steampower
    public static Boolean enableFSP;
    public static Boolean enableBrass;
    public static Boolean enableGildedIron;

    // Thaumcraft
    public static Boolean enableThaumcraftWeapons;
    public static Boolean enableThaumium;
    public static Boolean enableVoidMetal;

    // Applied Energistics 2
    public static Boolean enableAEWeapons;
    public static Boolean enableCertusQuartz;
    public static Boolean enableNetherQuartz;

    // Botania
    public static Boolean enableBotania;
    public static Boolean enableManaSteel;
    public static Boolean enableTerraSteel;
    public static Boolean enableElementium;

    // SimpleOres
    public static Boolean enableAdamantium;
    public static Boolean enableOnyx;

    // Fusion
    public static Boolean enableThyrium;
    public static Boolean enableSinisite;

    // Netherrocks
    public static Boolean enableMalachite;
    public static Boolean enableAshstone;
    public static Boolean enableDragonstone;
    public static Boolean enableArgonite;


    public static void init(File configFile) {
        if (conf == null) {
            conf = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        // Generic Metals
        // conf.setCategoryComment("Generic Metals","These Weapons will only load if there is the ingot form of the
        // Metal in question available in the OreDictionary");
        enableBronze = conf.getBoolean("Bronze Weapons", "Bronze", true,
                "Enable Bronze Weapons?");
        enableSteel = conf.getBoolean("2. Steel Weapons", "Steel", true,
                "Enable Steel Weapons?");


        // Applied Energistics 2
        enableAEWeapons = conf.getBoolean("1. Enable AE2 Weapons", "AE2", true,
                "Enables Certus and Nether Quartz weapons if enabled below");
        enableCertusQuartz = conf.getBoolean("2. Certus Quartz Weapons", "AE2", true,
                "Enable Certus Quartz Weapons?");
        enableNetherQuartz = conf.getBoolean("3. NetherQuartz Weapons", "AE2", true,
                "Enable Nether Quartz Weapons?");

        // Flaxbeard's Steampower
        enableFSP = conf.getBoolean("1. Enable FSP Weapons", "FSP", true,
                "Enables Brass and Gilded Iron Weapons if enabled below");
        enableBrass = conf.getBoolean("2. Brass Weapons", "FSP", true,
                "Enable Brass Weapons?");
        enableGildedIron = conf.getBoolean("3. Gilded Iron Weapons", "FSP", true,
                "Enable Gilded Iron?");


        // Thaumcraft!
        enableThaumcraftWeapons = conf.getBoolean("1. Enable Thaumcraft Support", "Thaumcraft", true,
                "Enables Thaumium and Void Metal weapons if enabled below. ");
        enableThaumium = conf.getBoolean("2. Thaumium Weapons", "Thaumcraft", true,
                "Enable Thaumium Weapons?");
        enableVoidMetal = conf.getBoolean("3. Void Metal Weapons", "Thaumcraft", true,
                "Enable Void Metal Weapons?");

        // Botania
        enableBotania = conf.getBoolean("1. Enable Botania Support", "Botania", true,
                "Enables Manasteel, Terrasteel, and Elementium if enabled below");
        enableManaSteel = conf.getBoolean("2. Manasteel Weapons", "Botania", true,
                "Enable Manasteel Weapons?");

        // Simple Ores
        enableAdamantium = conf.getBoolean("Enable Adamantium Weapons", "Simple Ores 2", true,
                "Enables Adamantium Weapons for Simple Ores 2");
        enableOnyx = conf.getBoolean("Enable Onyx Weapons", "Simple Ores", true,
                "Enables Onyx Weapons for Simple Ores 2");

        // Fusion
        enableThyrium = conf.getBoolean("Enable Thyrium Weapons", "Fusion", true,
                "Enables Thyrium Weapons for Fusion");
        enableSinisite = conf.getBoolean("Enable Sinisite Weapons", "Fusion", true,
                "Enables Sinisite Weapons for Fusion");

        // Netherrocks
        enableMalachite = conf.getBoolean("Enable Malachite Weapons", "Netherrocks", true,
                "Enables Malachite Weapons for Netherrocks");
        enableAshstone = conf.getBoolean("Enable Ashsstone Weapons", "Netherrocks", true,
                "Enables Ashstone Weapons for Netherrocks");
        enableDragonstone = conf.getBoolean("Enable Dragonstone Weapons", "Netherrocks", true,
                "Enables Dragonstone Weapons for Netherrocks");
        enableArgonite = conf.getBoolean("Enable Argonite Weapons", "Netherrocks", true,
                "Enables Argonite Weapons for Netherrocks");


        if (conf.hasChanged())
            conf.save();
    }
}
