package com.pbjboss.survivaltweaks.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Random;

public class EventHandler
{

    ArrayList<Item> axes = new ArrayList();

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent e)
    {
        int drops = ((int) Math.floor(Math.random() * 100));
        if (e.block == Blocks.leaves)
        {
            if (drops < 50)
            {
            }

            if (drops > 49 && drops < 80)
            {
                e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
            }

            if (drops > 80)
            {
                e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
                e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
            }
        }


    }

    @SubscribeEvent
    public void onHarvestBlock(BlockEvent.HarvestDropsEvent e)
    {
        if (e.block == Blocks.log)
        {
            if (e.harvester != null)
            {
                EntityPlayer player = e.harvester;
                if (player != null)
                {
                    if (player.getHeldItem() != null)
                    {
                        ItemStack heldStack = player.getHeldItem();

                        if (heldStack.getItem() != Items.wooden_axe && heldStack.getItem() != Items.stone_axe && heldStack.getItem() != Items.iron_axe && heldStack.getItem() != Items.diamond_axe)
                        {
                            e.drops.clear();
                        }
                    }else{
                        e.drops.clear();
                    }
                }
            }
        }
    }
}
