import dev.architectury.pack200.java.Pack200Adapter
import org.apache.commons.lang3.SystemUtils
import org.apache.tools.ant.filters.ReplaceTokens
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

plugins {
    idea
    java
    id("gg.essential.loom") version "1.6.9999-fg1-2"
    id("dev.architectury.architectury-pack200") version "0.1.3"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

val minecraft_version: String by project
val minecraft_version_range: String by project
val archives_base_name: String by project
val mod_version: String by project
val maven_group: String by project
val forge_version: String by project
val forge_version_range: String by project
val loader_version_range: String by project
val bwm_version_curse: String by project
val bwm_version_range: String by project
val mod_id: String by project
val mod_name: String by project
val mod_license: String by project
val mod_group_id: String by project
val mod_authors: String by project
val mod_authors_list: String by project
val mod_description: String by project
val mod_issues_url: String by project
val mod_sources_url: String by project
val mod_home_url: String by project
val mod_update_json: String by project

version = "forge-$minecraft_version-$mod_version"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

loom {
    runConfigs {
        "client" {
            if (SystemUtils.IS_OS_MAC_OSX) {
                // This argument causes a crash on macOS
                vmArgs.remove("-XstartOnFirstThread")
            }
        }
        remove(getByName("server"))
    }
    forge {
        pack200Provider.set(Pack200Adapter())
    }
}

sourceSets.main {
    output.setResourcesDir(sourceSets.main.flatMap { it.java.classesDirectory })
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven/")
    maven("https://jitpack.io/")
    maven("https://cursemaven.com")
}

val shadowImpl: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

tasks.shadowJar {
    archiveClassifier.set("dev")
    configurations = listOf(shadowImpl)
    doLast {
        configurations.forEach {
            println("Copying jars into mod: ${it.files}")
        }
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    fun relocate(name: String) = relocate(name, "$maven_group.repackage.$name")
    relocate("makamys.mclib")
    relocate("net.sf")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings("net.minecraftforge:forge:$forge_version:userdev")
    forgeLegacy("net.minecraftforge:forge:$forge_version")
    shadowImpl("com.github.makamys:MCLib:0.3.7.6") {
        exclude(group = "codechicken")
    }
    modApi("curse.maven:balkons-weaponmod-legacy-1033985:$bwm_version_curse")
    modApi("curse.maven:applied-energistics-2-223794:2296430")
    modApi("curse.maven:botania-225643:2283837")
    modApi("curse.maven:railcraft-51195:2458987")
    modApi("curse.maven:simpleores-226138:2293236")
    modApi("curse.maven:thaumcraft-223628:2227552")
}

// Genius approach to replace @VERSION@ from https://stackoverflow.com/a/54094378/5894824
val processSource = tasks.register<Sync>("processSource") {
    from(sourceSets.main.get().java)
    filter<ReplaceTokens>(
        "tokens" to mapOf(
            Pair("MOD_VERSION", mod_version),
            Pair("MOD_NAME", mod_name),
            Pair("MC_RANGE", minecraft_version_range),
            Pair("BWM_VERSION_RANGE", bwm_version_range),
            Pair("MOD_ID", mod_id),
            Pair("MOD_UPDATE_JSON", mod_update_json)
        )
    )
    into(layout.buildDirectory.file("src").get())
}

tasks.withType(JavaCompile::class) {
    source = processSource.get().outputs.files.asFileTree
    options.encoding = "UTF-8"
}

tasks.withType(Jar::class) {
    archiveBaseName.set(archives_base_name)
    manifest.attributes.run {
        this["Specification-Title"] = mod_name
        this["Specification-Vendor"] = mod_authors
        this["Specification-Version"] = "1" // We are version 1 of ourselves
        this["Implementation-Title"] = mod_name
        this["Implementation-Version"] = mod_version
        this["Implementation-Vendor"] = mod_authors
        this["Implementation-Timestamp"] =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ").format(OffsetDateTime.now())
    }
}

tasks.processResources {
    inputs.property("minecraft_version", minecraft_version)
    inputs.property("minecraft_version_range", minecraft_version_range)
    inputs.property("forge_version", forge_version)
    inputs.property("forge_version_range", forge_version_range)
    inputs.property("loader_version_range", loader_version_range)
    inputs.property("mod_id", mod_id)
    inputs.property("mod_name", mod_name)
    inputs.property("mod_license", mod_license)
    inputs.property("mod_version", mod_version)
    inputs.property("mod_authors", mod_authors)
    inputs.property("mod_authors_list", mod_authors_list)
    inputs.property("mod_description", mod_description)
    inputs.property("mod_issues_url", mod_issues_url)
    inputs.property("mod_sources_url", mod_sources_url)
    inputs.property("mod_home_url", mod_home_url)

    filesMatching(listOf("mcmod.info", "pack.mcmeta")) {
        expand(inputs.properties)
    }
}

tasks.remapJar {
    archiveBaseName.set(archives_base_name)
    archiveVersion.set(version.toString())
    archiveClassifier.set("")
    inputFile.set(tasks.shadowJar.get().archiveFile)
}

tasks.assemble.get().dependsOn(tasks.remapJar)
