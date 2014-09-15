package com.pbjboss.survivaltweaks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipe
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(Blocks.planks), "xx", "xx", 'x', Items.stick);
    }
}
