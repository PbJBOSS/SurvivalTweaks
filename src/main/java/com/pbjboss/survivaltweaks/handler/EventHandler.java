package com.pbjboss.survivaltweaks.handler;

import com.pbjboss.survivaltweaks.util.LogHelper;
import com.sun.xml.internal.bind.v2.TODO;
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
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.Random;

public class EventHandler
{
    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent e)
    {
        if (ConfigurationHandler.leavesDropSticks)
        {
            int drops = ((int) Math.floor(Math.random() * 100));
            if (e.block == Blocks.leaves)
            {
                int chanceOfDropping = ConfigurationHandler.leavesDrop1StickPercent + ConfigurationHandler.leavesDrop2SticksPercent;
                int chanceOfNotDropping = 100 - chanceOfDropping;
                System.out.println(drops);
                if (drops < chanceOfNotDropping)
                {
                    LogHelper.info("0 Stick");

                }else if (drops < chanceOfNotDropping + ConfigurationHandler.leavesDrop1StickPercent)
                {
                    LogHelper.info("1 Stick");

                    e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
                }else if (drops < chanceOfNotDropping + ConfigurationHandler.leavesDrop1StickPercent + ConfigurationHandler.leavesDrop2SticksPercent)
                {
                    LogHelper.info("2 Stick");

                    e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
                    e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(Items.stick)));
                }
            }
        }


    }

    @SubscribeEvent
    public void onHarvestBlock(BlockEvent.HarvestDropsEvent e)
    {
        if (!ConfigurationHandler.canHarvestWood)
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
                        } else
                        {
                            e.drops.clear();
                        }
                    }
                }
            }
        }
    }
//TODO add two use axe event
    /**@SubscribeEvent
    public void onAxeUseEvent()
    {
        if (!ConfigurationHandler.axeOneUse)
        {

        }
    }**/
}
