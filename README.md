# Expanded Armory: Legacy

[![Workflow status](https://img.shields.io/github/actions/workflow/status/ThexXTURBOXx/Expanded-Armory-Legacy/build.yml?logo=githubactions&style=flat-square)](https://github.com/ThexXTURBOXx/Expanded-Armory-Legacy/actions/workflows/build.yml)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1197267?logo=curseforge&style=flat-square)](https://www.curseforge.com/minecraft/mc-mods/expanded-armory-legacy)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/75W8JAu2?logo=modrinth&style=flat-square)](https://modrinth.com/mod/expanded-armory-legacy)
[![Translate on Crowdin](https://img.shields.io/static/v1?label=Translate&message=on%20Crowdin&logo=crowdin&style=flat-square)](https://crowdin.com/project/balkons-weaponmod-legacy)
[![Sponsor me!](https://img.shields.io/github/sponsors/ThexXTURBOXx?logo=github&style=flat-square)](https://github.com/sponsors/ThexXTURBOXx)

Expanded Armory: Legacy is a simple mod, it takes the tool materials from other mods and brings them to Balkon's WeaponMod: Legacy.  
This is [HyperSpeeed](https://nmexis.me/)'s modernisation fork of
the [original project](https://github.com/mallrat208/ExpandedArmory).

## Why?

Rest in Pieces, Expanded Armory!  
This project is meant as a homage to our good old friend: Expanded Armory.  
Nine years ago (at the time of writing this it is beginning-2025), the mod was abandoned.
As one of the two creators of Reforged, I wanted to pose a challenge to myself:  
Directly port BWM and this gem of a mod to modern versions of Minecraft.

I am working full-time, so I can only dedicate a bit of my precious time to projects like this.  
I hope you enjoy playing around with it!

Without anything further to say here, enjoy!

## Contributing

There are many ways to contribute!

### Development

Development should be rather easy. BWM: Legacy currently uses Loom in three different flavors:

- [Architectury Loom](https://github.com/architectury/architectury-loom) for everything above 1.16.5. It is the easiest
  way to enable multi-platform modding and is officially endorsed by
  the [Architectury API](https://github.com/architectury/architectury) (which this mod depends on in 1.16.5+).
- [Essential Loom](https://github.com/EssentialGG/architectury-loom) for all versions between 1.8.9 and 1.12.2. Sadly,
  Architectury Loom does not officially support Minecraft versions that old. So,
  the [Essential team](https://github.com/EssentialGG) added many fixes to Architectury Loom to support these legacy
  versions.
- [My own Loom](https://github.com/ThexXTURBOXx/architectury-loom/tree/dev/1.6-1.7.10) for everything between and below.
  Sadly, even Essential Loom is not even able to handle some of these other versions correctly. So, I forked it and
  hence created a fourth fork layer of the official Loom - perfect! I added fixes and hacks to make Loom even
  1.7.10-compatible and fixed a few additional bugs that I found in upstream versions; that's all.

This way, you don't have to worry about most of the background tasks.  
If you want to change the mod's code, you can just do the following:

1. Clone the repo: `git clone https://github.com/ThexXTURBOXx/Expanded-Armory-Legacy.git`
2. Checkout the branch you want to work on, e.g., `git checkout 1.7.10`
3. Open `build.gradle` or `build.gradle.kts` (depending on which version you want to develop on) in your favorite IDE (I
   am using IntelliJ IDEA and everything works fine here... Don't know about other IDEs, though!)
4. Your IDE should download and build some stuff. This might take quite some time...
5. Now, you should be able to change the code properly!

To test your changes, you can just do the following:

1. Run `gradlew build` to compile the mod
2. If everything worked fine, you should find the mod jar in either `build/libs/ExpandedArmory-forge-1.5.0.jar`
   or `<PLATFORM>/build/libs/ExpandedArmory-<PLATFORM>-1.5.0.jar`

When you are done with your changes, push them to
a [fork](https://github.com/ThexXTURBOXx/Expanded-Armory-Legacy/fork) of my repository
and [open a PR](https://github.com/ThexXTURBOXx/Expanded-Armory-Legacy/compare/1.7.10...Sunconure11:ExpandedArmory:master)!  
**Make sure to target my repository, not the upstream (original) Expanded Armory repository!**

<!--TODO
### Translation

This project uses [Crowdin](https://crowdin.com/project/balkons-weaponmod-legacy)!  
If you want to translate the mod, feel free to change one of the existing languages there!  
If you want to translate the mod to another language that I have not yet added there,
please [open an issue](https://github.com/ThexXTURBOXx/Balkons-WeaponMod-Legacy/issues/new) to ask me to add it there
first.-->

### Bug Reports and Feature Requests

If you find a bug or want to see something new in the mod, feel free to let me know by
[opening an issue](https://github.com/ThexXTURBOXx/Expanded-Armory-Legacy/issues/new)!
