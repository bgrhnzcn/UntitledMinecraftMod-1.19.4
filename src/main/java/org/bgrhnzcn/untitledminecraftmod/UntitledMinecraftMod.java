package org.bgrhnzcn.untitledminecraftmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.bgrhnzcn.untitledminecraftmod.block.ModBlocks;
import org.bgrhnzcn.untitledminecraftmod.item.ModCreativeModTabs;
import org.bgrhnzcn.untitledminecraftmod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UntitledMinecraftMod.MOD_ID)
public class UntitledMinecraftMod {


    public static final String MOD_ID = "untitledminecraftmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UntitledMinecraftMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Calling registers of classes.
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    //Creative Tab adds.
    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == ModCreativeModTabs.UNTITLED_TAB){
            event.accept(ModItems.RAW_TEST_ORE);
            event.accept(ModItems.TEST_INGOT);
            event.accept(ModBlocks.TEST_INGOT_BLOCK);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
