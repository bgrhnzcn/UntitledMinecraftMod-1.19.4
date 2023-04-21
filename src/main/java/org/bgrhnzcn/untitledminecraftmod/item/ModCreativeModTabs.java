package org.bgrhnzcn.untitledminecraftmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.bgrhnzcn.untitledminecraftmod.UntitledMinecraftMod;

//Custom Creative Mod Tab Setup
@Mod.EventBusSubscriber(modid = UntitledMinecraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModTabs {
    public static CreativeModeTab UNTITLED_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        UNTITLED_TAB = event.registerCreativeModeTab(new ResourceLocation(UntitledMinecraftMod.MOD_ID,"untitled_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TEST_INGOT.get()))
                        .title(Component.translatable("creativemodetab.untitled_tab")));
    }
}
