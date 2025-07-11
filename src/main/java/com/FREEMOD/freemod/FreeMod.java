package com.FREEMOD.freemod;

import com.FREEMOD.freemod.block.ModBlocks;
import com.FREEMOD.freemod.effect.ModEffects;
import com.FREEMOD.freemod.fluid.AcidFluid;
import com.FREEMOD.freemod.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FreeMod.MOD_ID)
public class FreeMod {
    public static final String MOD_ID = "freemod";


    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Add a comment
    public FreeMod() {
        //Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

//        OnsenFluid.register(eventBus);
        AcidFluid.register(eventBus);
        ModEffects.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);//part15

        //Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    //part 15 レンダラー処理
    private void clientSetup(final FMLClientSetupEvent event){
//        ItemBlockRenderTypes.setRenderLayer(OnsenFluid.ONSEN_BLOCK.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(OnsenFluid.ONSEN_FLUID.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(OnsenFluid.ONSEN_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AcidFluid.ACID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AcidFluid.ACID_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AcidFluid.ACID_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_LEAVES.get(),RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_SAPLING.get(),RenderType.cutout());


    }

    private void setup(final FMLCommonSetupEvent event){
        //some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
