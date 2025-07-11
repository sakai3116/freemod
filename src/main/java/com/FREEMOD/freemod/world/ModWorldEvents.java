package com.FREEMOD.freemod.world;

import com.FREEMOD.freemod.FreeMod;
import com.FREEMOD.freemod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FreeMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModTreeGeneration.generateTree(event);//part 32
        //ModFlowerGeneration.generateFlowers(event);//part 33
        //ModOreGeneration.generateOres(event);//part 34
    }
}