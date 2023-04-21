package org.bgrhnzcn.untitledminecraftmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bgrhnzcn.untitledminecraftmod.UntitledMinecraftMod;


public class ModItems {
    //Registery for items.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UntitledMinecraftMod.MOD_ID);

    //This part is adding items.
    public static final RegistryObject<Item> RAW_TEST_ORE = ITEMS.register("raw_test_ore",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEST_INGOT = ITEMS.register("test_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    //Basic register() method.
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
