package com.pbjboss.survivaltweaks;

import com.pbjboss.survivaltweaks.handler.EventHandler;
import com.pbjboss.survivaltweaks.init.ModRecipe;
import com.pbjboss.survivaltweaks.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MODID,name = Reference.MODNAME, version = Reference.VERSION)
public class SurvivalTweaks
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        ModRecipe.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {

    }

}
